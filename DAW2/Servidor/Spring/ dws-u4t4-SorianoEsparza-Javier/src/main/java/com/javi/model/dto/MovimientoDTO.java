package com.javi.model.dto;

import java.util.Objects;

import com.javi.repository.entity.Movimiento;

import lombok.Data;
import lombok.ToString;

@Data
public class MovimientoDTO {
	private long id;
	private String tipo;
	@ToString.Exclude
	private int idEmisor;
	@ToString.Exclude
	private int idReceptor;
	private float cant;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimientoDTO other = (MovimientoDTO) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setMovimientoDTO(Movimiento mov) {
		this.id = mov.getId();
		this.tipo = mov.getTipo();
		this.cant = mov.getCant();
		this.idEmisor = mov.getIdEmisor();
		this.idReceptor = mov.getIdReceptor();
	}

	public static MovimientoDTO convertToDTO(Movimiento mov) {
		MovimientoDTO mdto = new MovimientoDTO();
		mdto.setMovimientoDTO(mov);
		return mdto;
	}

	public static Movimiento convertToEntity(MovimientoDTO mdto) {
		Movimiento mov = new Movimiento();
		mov.setId(mdto.getId());
		mov.setCant(mdto.getCant());
		mov.setTipo(mdto.getTipo());
		mov.setIdEmisor(mdto.getIdEmisor());
		mov.setIdReceptor(mdto.getIdReceptor());

		return mov;
	}

	public MovimientoDTO() {
		super();
		id = -1;
	}
}
