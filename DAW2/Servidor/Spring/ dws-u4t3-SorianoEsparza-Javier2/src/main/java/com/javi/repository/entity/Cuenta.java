package com.javi.repository.entity;

import java.util.Objects;

import lombok.Data;
import lombok.ToString;

@Data
public class Cuenta {
	private int id;
	private String nombre;
	private float saldo;
	@ToString.Exclude
	private Cliente cliente;
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
	public void setCuenta(int id, String nombre, float saldo) {
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
	}
}
