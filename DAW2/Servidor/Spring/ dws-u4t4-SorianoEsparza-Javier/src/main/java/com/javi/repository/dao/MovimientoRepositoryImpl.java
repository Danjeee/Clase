
package com.javi.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;


@Repository
public class MovimientoRepositoryImpl implements MovimientoRepository {

	@Autowired
	CuentaRepository cr;
	@Autowired
	clienteRepository clir;
	@Override
	public void save(Movimiento mov) {
		Cuenta auxemi = new Cuenta();
		auxemi.setId(mov.getIdEmisor());
		Cuenta auxrec = new Cuenta();
		auxrec.setId(mov.getIdReceptor());
		Cuenta emisor = cr.findById(auxemi);
		Cuenta receptor = cr.findById(auxrec);
		String id = mov.getIdEmisor() + "" +mov.getIdReceptor() +"" +findByAccount(emisor).size() + "" + findByAccount(receptor).size();
		mov.setId(Integer.parseInt(id));
		emisor.getMovimientos().add(mov);
		receptor.getMovimientos().add(mov);
		emisor.setSaldo(emisor.getSaldo()-mov.cant);
		receptor.setSaldo(receptor.getSaldo()+mov.cant);
		cr.update(emisor);
		cr.update(receptor);
	}

	@Override
	public Movimiento findById(Movimiento mov) {
		for (Cliente c : clir.findAll()) {
			for (Cuenta cu : c.getCuentas()) {
				for (Movimiento m : cu.getMovimientos()){
					if (m.equals(mov)) {
						return m;
					}
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<Movimiento> findByUser(Cliente cli) {
		ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
		Cliente c = clir.findById(cli);
		for (Cuenta cu : c.getCuentas()) {
			movs.addAll(cu.getMovimientos());
		}
		return movs;
	}

	@Override
	public ArrayList<Movimiento> findByAccount(Cuenta cu) {
		Cuenta c = cr.findById(cu);
		return c.getMovimientos();
	}

}
