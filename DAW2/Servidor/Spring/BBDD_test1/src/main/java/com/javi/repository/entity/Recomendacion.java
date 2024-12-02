package com.javi.repository.entity;

import java.util.Objects;

import lombok.Data;
import lombok.ToString;

public class Recomendacion {
	private long id;
	private String observaciones;
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
		Recomendacion other = (Recomendacion) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setRecomendacion(long id, String observaciones) {
		this.id = id;
		this.observaciones = observaciones;
	}
}
