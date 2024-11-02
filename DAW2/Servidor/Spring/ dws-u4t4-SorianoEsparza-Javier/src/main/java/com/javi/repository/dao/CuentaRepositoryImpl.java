package com.javi.repository.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.service.CuentaServiceImpl;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository {

	private static final Logger log = LoggerFactory.getLogger(CuentaRepository.class);
	
	@Autowired
	clienteRepository cr;

	@Override
	public void save(Cuenta cuv) {
		Cliente cli = cr.findById(cuv.getCliente());
		cli.getCuentas().add(cuv);
		cr.update(cli);
	}

	@Override
	public Cuenta findById(Cuenta cu) {
		for (Cliente c : cr.findAll()) {
			for (Cuenta cuaux : c.getCuentas()) {
				if (cuaux.equals(cu)) {
					return cuaux;
				}
			}
		}
		return null;
	}

	@Override
	public void update(Cuenta cuv) {
		Cliente cli = cr.findById(cuv.getCliente());
		cli.getCuentas().set(cli.getCuentas().indexOf(cuv), cuv);
		cr.update(cli);

	}

	@Override
	public void delete(Cuenta cuv) {
		Cliente cli = cr.findById(cuv.getCliente());
		cli.getCuentas().remove(cli.getCuentas().indexOf(cuv));
		cr.update(cli);

	}

}
