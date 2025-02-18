package com.javi.service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteServicioDTO;
import com.javi.repository.dao.ClienteServicioRepository;
import com.javi.repository.dao.ClienteRepository;
import com.javi.repository.dao.ServicioRepository;
import com.javi.repository.entity.Cliente;
import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.ServicioDTO;
import com.javi.repository.entity.ClienteServicio;
import com.javi.repository.entity.Servicio;

@Service
public class ServicioServiceImpl implements ServicioService {

        private static final Logger log = LoggerFactory.getLogger(ServicioServiceImpl.class);

        @Autowired
        private ServicioRepository servicioRepository;

        @Autowired
        private ClienteRepository clienteRepository;

        @Autowired
        private ClienteServicioRepository ClienteServicioRepository;

        @Override
        public List<ClienteServicioDTO> findAllByCliente(Long idCliente) {
                log.info(this.getClass().getSimpleName()
                                + " findAllByCliente: devolver todas las servicio asociadas al cliente con id: {}",
                                idCliente);

                Cliente cliente = this.clienteRepository.findById(idCliente).orElse(null);
                List<ClienteServicio> listaClienteServicioes = this.ClienteServicioRepository
                                .findByClienteId(idCliente);
                List<ClienteServicioDTO> listaClienteServicioesDTO = listaClienteServicioes.stream()
                                .map(c -> ClienteServicioDTO.convertToDTO(c, ClienteDTO.convertToDTO(cliente),
                                                ServicioDTO.convertToDTO(c.getServicio())))
                                .collect(Collectors.toList());

                return listaClienteServicioesDTO;
        }

        @Override
        public List<ServicioDTO> findAll() {
                log.info(this.getClass().getSimpleName() + " findAll: devolver todas las servicioes");

                return this.servicioRepository.findAll().stream().map(ServicioDTO::convertToDTO)
                                .collect(Collectors.toList());
        }

        @Override
        public ServicioDTO findById(Long id) {
                log.info(this.getClass().getSimpleName() + " findById: devolver servicio con id: {}", id);

                return this.servicioRepository.findById(id).map(ServicioDTO::convertToDTO).orElse(null);
        }

        @Override
        public void save(ServicioDTO servicioDTO, Long idCliente) {
                log.info(this.getClass().getSimpleName() + " save: guardar servicio con datos: {}", servicioDTO);
                Set<ClienteServicio> listaClienteServicioes = this.ClienteServicioRepository
                                .findByClienteId(idCliente)
                                .stream().collect(Collectors.toSet());
                Servicio servicio = ServicioDTO.convertToEntity(servicioDTO, listaClienteServicioes);
                this.servicioRepository.save(servicio);
                
                if (servicioDTO.getId() == null) {
                        Cliente cliente = this.clienteRepository.findById(idCliente).orElse(null);
                        cliente.getListaClienteServicios()
                                        .add(ClienteServicio.builder().cliente(cliente).servicio(servicio)
                                                        .fechaAlta(new Date()).precio(servicioDTO.getPrecio_aux()).build());
                        this.clienteRepository.save(cliente);
                }
                
                if (servicioDTO.getId() != null && servicioDTO.getPrecio_aux() != null) {
                	ClienteServicio cs = ClienteServicioRepository.findByClienteIdAndServicioId(idCliente, servicioDTO.getId()).orElse(null);
                    this.servicioRepository.updatePrice(cs.getId(), servicioDTO.getPrecio_aux());
                }
        }

        @Override
        public void addExistente(ServicioDTO servicioDTO, Long idCliente) {
                Cliente cli = clienteRepository.findById(idCliente).orElse(null);
                Servicio serv = servicioRepository.findbyParams(servicioDTO.getNombre(), servicioDTO.getDescripcion()).orElse(null);
                ClienteServicio cs = ClienteServicio.builder().cliente(cli).servicio(serv).precio(servicioDTO.getPrecio_aux()).fechaAlta(new Date()).build();
                ClienteServicioRepository.save(cs);
                cli.getListaClienteServicios().add(cs);
                clienteRepository.save(cli);
                serv.getListaClienteServicio().add(cs);
                servicioRepository.save(serv);
        }

        @Override
        public void deleteById(Long id) {
                log.info(this.getClass().getSimpleName() + " deleteById: borrar direccion con id: {}", id);

                this.servicioRepository.deleteById(id);
        }

		@Override
		public void remove(Long serv, Long idCliente) {
			Cliente cli = clienteRepository.findById(idCliente).orElse(null);
			ClienteServicio cs = ClienteServicioRepository.findByClienteIdAndServicioId(idCliente, serv).orElse(null);

			Servicio servicio = servicioRepository.findById(serv).orElse(null);
			if (servicio.getListaClienteServicio().size()-1 > 0) {
				servicio.getListaClienteServicio().remove(cs);
				servicioRepository.save(servicio);
			} else {
				servicioRepository.deleteById(serv);
			}
			ClienteServicioRepository.deleteById(cs.getId());
			cli.getListaClienteServicios().remove(cs);
			clienteRepository.save(cli);
			
		}

		@Override
		public ServicioDTO findByParams(ServicioDTO servicioDTO) {
			 try {
				 return ServicioDTO.convertToDTO(servicioRepository.findbyParams(servicioDTO.getNombre(), servicioDTO.getDescripcion()).orElse(null));
			 } catch (NullPointerException ex) {
				 return null;
			 }
		}
}
