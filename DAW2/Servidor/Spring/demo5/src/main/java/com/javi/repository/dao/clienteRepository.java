package com.javi.repository.dao;

import java.util.List;
import com.javi.repository.entity.Cliente;

public interface clienteRepository {
	public List<Cliente> findAll();

	public void save(Cliente convertToEntity);
}
