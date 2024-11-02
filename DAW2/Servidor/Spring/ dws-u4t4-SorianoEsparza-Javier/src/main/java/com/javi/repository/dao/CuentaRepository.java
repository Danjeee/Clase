package com.javi.repository.dao;

import java.util.ArrayList;
import java.util.List;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;

public interface CuentaRepository {
	public void save(Cuenta cuv);

	public void update(Cuenta cuv);

	public void delete(Cuenta cuv);

	public Cuenta findById(Cuenta cu);

}
