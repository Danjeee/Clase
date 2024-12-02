package com.javi.service;

import com.javi.model.dto.CuentaDTO;

public interface CuentaService {
	public void save(CuentaDTO cuv);

	public void delete(CuentaDTO cuv);

	public CuentaDTO findById(CuentaDTO cu);

}
