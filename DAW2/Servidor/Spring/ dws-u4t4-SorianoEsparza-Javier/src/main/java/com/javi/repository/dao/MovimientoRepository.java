package com.javi.repository.dao;

import java.util.ArrayList;
import java.util.List;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;

public interface MovimientoRepository {
	public void save(Movimiento mov);
	public Movimiento findById(Movimiento mov);
	public ArrayList<Movimiento> findByUser(Cliente cli);
	public ArrayList<Movimiento> findByAccount(Cuenta cu);
	

}
