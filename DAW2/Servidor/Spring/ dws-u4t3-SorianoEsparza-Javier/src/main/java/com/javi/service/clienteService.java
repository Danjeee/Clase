package com.javi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteDTO;

public interface clienteService {
	public List<ClienteDTO> findAll();

	public void save(ClienteDTO cdto);

	public void delete(ClienteDTO cdto);

	public ClienteDTO findById(ClienteDTO cdto);
}
