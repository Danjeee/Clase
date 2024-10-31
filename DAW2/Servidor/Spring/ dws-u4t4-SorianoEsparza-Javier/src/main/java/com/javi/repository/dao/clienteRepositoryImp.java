package com.javi.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javi.model.dto.ClienteDTO;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Recomendacion;

@Repository
public class clienteRepositoryImp implements clienteRepository {
	private static List<Cliente> datos = new ArrayList<>();
	static {
		Cliente c1 = new Cliente();
		c1.setCliente(0, "123A", "Juan", "Manuel", "siempre", "juan@example.com");
		Recomendacion r1 = new Recomendacion();
		r1.setRecomendacion(0, "nada");
		c1.setRecomendacion(r1);
		r1.setCliente(c1);
		Cuenta cu1 = new Cuenta();
		cu1.setCliente(c1);
		String id = "1" + String.valueOf(c1.getId()) +""+ String.valueOf(c1.getCuentas().size());
		cu1.setCuenta(Integer.parseInt(id), "Cuenta nomina", 100.0f);
		c1.getCuentas().add(cu1);
		Cuenta cu2 = new Cuenta();
		id = "1" + String.valueOf(c1.getId()) +""+ String.valueOf(c1.getCuentas().size());
		cu2.setCuenta(Integer.parseInt(id), "Cuenta ahorros", 2000.0f);
		cu2.setCliente(c1);
		c1.getCuentas().add(cu2);
		Cliente c2 = new Cliente();
		c2.setCliente(1, "2393D", "Javi", "Soriano Esparza", "0000", "javisores@example.com");
		Recomendacion r2 = new Recomendacion();
		r2.setRecomendacion(1, "algo");
		c2.setRecomendacion(r2);
		r2.setCliente(c2);
		Cuenta cu3 = new Cuenta();
		id = "1" + String.valueOf(c2.getId()) +""+ String.valueOf(c2.getCuentas().size());
		cu3.setCuenta(Integer.parseInt(id), "Cuenta verde", 200.0f);
		cu3.setCliente(c2);
		c2.getCuentas().add(cu3);
		datos.add(c1);
		datos.add(c2);
	}
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return datos;
	}
	@Override
	public void save(Cliente cli) {
		datos.add(cli);
		
	}
	@Override
	public void delete(Cliente cli) {
		datos.remove(cli);
		
	}
	@Override
	public Cliente findById(Cliente cli) {
		return datos.get(datos.indexOf(cli));
	}
	@Override
	public void update(Cliente cli) {
		int pos = datos.indexOf(cli);
		datos.set(pos, cli);
		
	}

}
