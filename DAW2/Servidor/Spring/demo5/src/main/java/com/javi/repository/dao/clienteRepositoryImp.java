package com.javi.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javi.model.dto.ClienteDTO;
import com.javi.repository.entity.Cliente;
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
		Cliente c2 = new Cliente();
		c2.setCliente(1, "2393D", "Javi", "Soriano Esparza", "0000", "javisores@example.com");
		Recomendacion r2 = new Recomendacion();
		r2.setRecomendacion(1, "algo");
		c2.setRecomendacion(r2);
		r2.setCliente(c2);
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
		datos.remove(cli);
		datos.add(cli);
		
	}

}
