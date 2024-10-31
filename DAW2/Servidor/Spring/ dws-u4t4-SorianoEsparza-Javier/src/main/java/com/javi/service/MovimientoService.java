package com.javi.service;

import java.util.List;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.MovimientoDTO;

public interface MovimientoService {
	public List<MovimientoDTO> findAll();

	public void save(MovimientoDTO cdto);

	public void delete(MovimientoDTO cdto);
	
	public MovimientoDTO findById(MovimientoDTO cdto);
}
