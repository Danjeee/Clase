package com.javi.repository.dao;

import java.util.List;

import com.javi.model.dto.ClienteDTO;
import com.javi.repository.entity.Cliente;

public interface clienteRepository {
	public List<Cliente> findAll();

	public void save(Cliente convertToEntity);

	public void delete(Cliente cli);

	public Cliente findById(Cliente cli);

	public void update(Cliente convertToEntity);
}
