package com.javi.service;

import java.util.ArrayList;
import java.util.List;

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
			cr.update(ClienteDTO.convertToEntity(cdto));
		} else {
			log.info("Aqui salvamos el cliente");
			cdto.getRecomendacionDTO().setId(findAll().size());
			cdto.setId(findAll().size());
			cr.save(ClienteDTO.convertToEntity(cdto));
		}
		
	}

	@Override
	public void delete(ClienteDTO cdto) {
		cr.delete(ClienteDTO.convertToEntity(cdto));
	}

	@Override
	public ClienteDTO findById(ClienteDTO cdto) {
		Cliente cli = ClienteDTO.convertToEntity(cdto);
		return ClienteDTO.convertToDTO(cr.findById(cli));
	}
}
