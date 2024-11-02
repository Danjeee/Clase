package com.javi.service;

import java.util.ArrayList;
import java.util.List;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.CuentaDTO;
import com.javi.model.dto.MovimientoDTO;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;

public interface MovimientoService {

	public void save(MovimientoDTO cdto);

	public MovimientoDTO findById(MovimientoDTO cdto);
	
	public ArrayList<MovimientoDTO> findByUser(ClienteDTO cli);

	public ArrayList<MovimientoDTO> findByAccount(CuentaDTO cu);
}
