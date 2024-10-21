package com.javi.model.dto;

import java.io.Serializable;
import java.util.Objects;

import com.javi.repository.entity.Recomendacion;

import lombok.Data;
import lombok.ToString;

@Data
public class RecomendacionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String observaciones;
	@ToString.Exclude
	private ClienteDTO clienteDTO;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecomendacionDTO other = (RecomendacionDTO) obj;
		return id == other.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	private void set(Recomendacion r, ClienteDTO c) {
		this.id = (r.getId());
		this.observaciones = (r.getObservaciones());
		this.clienteDTO = c;
	}
	public static RecomendacionDTO convertToDTO(Recomendacion r, ClienteDTO c) {
		RecomendacionDTO rdto = new RecomendacionDTO();
		rdto.set(r, c);
		return rdto;
	}
	public static Recomendacion convertToEntity(RecomendacionDTO recomendacionDTO) {
		Recomendacion r = new Recomendacion();
		r.setId(recomendacionDTO.getId());
		r.setObservaciones(recomendacionDTO.getObservaciones());
		r.setCliente(ClienteDTO.convertToEntity(recomendacionDTO.getClienteDTO()));
		return r;
	}
}
