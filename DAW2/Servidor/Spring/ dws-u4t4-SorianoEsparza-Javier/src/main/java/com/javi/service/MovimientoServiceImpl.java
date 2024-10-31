/*package com.javi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.MovimientoDTO;
import com.javi.repository.dao.MovimientoRepository;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Movimiento;

public class MovimientoServiceImpl implements MovimientoService{
	@Autowired
	private MovimientoRepository mr;

	@Override
	public List<MovimientoDTO> findAll() {
		List<Movimiento> listaMovimientos = mr.findAll();
		List<MovimientoDTO> listaMovimientosDTO = new ArrayList<MovimientoDTO>();
		for (Movimiento c : listaMovimientos) {
			listaMovimientosDTO.add(MovimientoDTO.convertToDTO(c));
		}
		return listaMovimientosDTO;
	}

	@Override
	public void save(MovimientoDTO cdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MovimientoDTO cdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MovimientoDTO findById(MovimientoDTO cdto) {
		// TODO Auto-generated method stub
		return null;
	}
}
*/