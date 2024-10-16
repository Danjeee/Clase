package com.javi.model.dto;

import java.io.Serializable;
import java.util.Objects;

import com.javi.repository.entity.Cliente;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String clave;
	private String email;
	private RecomendacionDTO recomendacionDTO;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		return id == other.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	private void set(Cliente c) {
		this.id = (c.getId());
		this.nombre = (c.getNombre());
		this.apellidos = (c.getApellidos());
		this.nif = (c.getNif());
		this.clave = (c.getClave());
		this.email = (c.getEmail());
		this.recomendacionDTO = (RecomendacionDTO.convertToDTO(c.getRecomendacion()));
	}
	public static ClienteDTO convertToDTO(Cliente cliente) {
		ClienteDTO c = new ClienteDTO();
		c.set(cliente);
		return c;
	}
	public static Cliente convertToEntity(ClienteDTO cliente) {
		Cliente c = new Cliente();
		return c;
	}
}
