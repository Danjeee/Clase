package com.javi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.CuentaDTO;


public interface CuentaService {
	public void save(CuentaDTO cuv);

	public void delete(CuentaDTO cuv);

	public CuentaDTO findById(CuentaDTO cu);
	
	public List<CuentaDTO> findAllByCliente(ClienteDTO c);

}
