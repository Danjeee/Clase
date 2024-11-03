package com.javi.repository.entity;

import java.util.Objects;

import lombok.Data;

@Data
public class Cliente {
	private int id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String clave;
	private String email;
	private Recomendacion recomendacion;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	public void setCliente(int id, String nif, String nombre, String apellidos, String clave, String email) {
		this.id = id;
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.clave = clave;
		this.email = email;
	}
}
