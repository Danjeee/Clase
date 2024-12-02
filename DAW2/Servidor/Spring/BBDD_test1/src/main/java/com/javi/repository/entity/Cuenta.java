package com.javi.repository.entity;

import java.util.ArrayList;
import java.util.Objects;

import lombok.Data;
import lombok.ToString;

public class Cuenta {
	private int id;
	private String nombre;
	private float saldo;
	@ToString.Exclude
	private Cliente cliente;
	private ArrayList<Movimiento> movimientos = new ArrayList<>();
	private String banco;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setCuenta(int id, String nombre, float saldo, String banco) {
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
		this.banco = banco;
	}
	public Cuenta(){
		super();
		this.cliente = new Cliente();
	}
}
