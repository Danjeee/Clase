package com.javi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.CuentaDTO;
import com.javi.model.dto.MovimientoDTO;
import com.javi.repository.dao.MovimientoRepository;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	private MovimientoRepository mr;


	@Override public void save(MovimientoDTO cdto) { 
		mr.save(MovimientoDTO.convertToEntity(cdto));
  }

	@Override public MovimientoDTO findById(MovimientoDTO cdto) { 
		
		return MovimientoDTO.convertToDTO(mr.findById(MovimientoDTO.convertToEntity(cdto)));
		}
	@Override
	public ArrayList<MovimientoDTO> findByUser(ClienteDTO cli) {
		ArrayList<MovimientoDTO> movs = new ArrayList<>();
		for (Movimiento m : mr.findByUser(ClienteDTO.convertToEntity(cli))) {
			movs.add(MovimientoDTO.convertToDTO(m));
		}
		return movs;
	}

	@Override
	public ArrayList<MovimientoDTO> findByAccount(CuentaDTO cu) {
		ArrayList<MovimientoDTO> movs = new ArrayList<>();
		for (Movimiento m : mr.findByAccount(CuentaDTO.convertToEntity(cu, ClienteDTO.convertToEntity(cu.getClienteDTO())))) {
			movs.add(MovimientoDTO.convertToDTO(m));
		}
		return movs;
	}
}
