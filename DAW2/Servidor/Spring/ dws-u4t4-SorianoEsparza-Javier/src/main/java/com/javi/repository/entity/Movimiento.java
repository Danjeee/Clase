package com.javi.repository.entity;

import java.util.Objects;

import lombok.Data;
import lombok.ToString;

@Data
public class Movimiento {
	public long id;
	public String tipo;
	@ToString.Exclude
	private int idEmisor;
	@ToString.Exclude
	private int idReceptor;
	public float cant;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setMovimiento(int id, String tipo, float cant, int emisor, int receptor) {
		this.id = id;
		this.tipo = tipo;
		this.cant = cant;
		this.idEmisor = emisor;
		this.idReceptor = receptor;
	}
}
