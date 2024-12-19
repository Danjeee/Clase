package com.javi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteDTO;
import com.javi.repository.dao.clienteRepository;
import com.javi.repository.entity.Cliente;

@Service
public class clienteServiceImpl implements clienteService {

	@Autowired
	private clienteRepository cr;

	private static final Logger log = LoggerFactory.getLogger(clienteServiceImpl.class);

	@Override
	public List<ClienteDTO> findAll() {
		log.info("Solicitamos lista");
		List<Cliente> listaClientes = cr.findAll();
		List<ClienteDTO> listaClientesDTO = new ArrayList<ClienteDTO>();
		for (Cliente c : listaClientes) {
			listaClientesDTO.add(ClienteDTO.convertToDTO(c));
		}
		return listaClientesDTO;
	}

	
	@Override
	public void save(ClienteDTO cdto) {
		if (cdto.getId() != -1) {
			log.info("Aqui actualizamos el cliente");
			cr.update(cdto.getNif(), cdto.getNombre(), cdto.getApellidos(), cdto.getClave(), cdto.getEmail(), cdto.getId());
		} else {
			log.info("Aqui salvamos el cliente");
			cdto.getRecomendacionDTO().setId(findAll().size());
			cdto.setId(findAll().size());
			log.info(String.valueOf(cdto.getId()));
			cr.save(ClienteDTO.convertToEntity(cdto));
		}

	}

	@Override
	public void delete(ClienteDTO cdto) {
		cr.deleteById(cdto.getId());
	}
	

	@Override
	public ClienteDTO findById(ClienteDTO cdto) {
		Optional<Cliente> cli = Optional.ofNullable(ClienteDTO.convertToEntity(cdto));
		if (cli.isPresent()) {
			return ClienteDTO.convertToDTO(cr.findById(cli.get().getId()).get());
		} else {
			return null;
		}
	}
}
