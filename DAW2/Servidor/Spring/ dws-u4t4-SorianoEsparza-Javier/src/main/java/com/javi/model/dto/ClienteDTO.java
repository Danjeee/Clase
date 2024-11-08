package com.javi.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Recomendacion;

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
	private ArrayList<CuentaDTO> cuentasDTO = new ArrayList<>();

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

	private void set(Cliente c, ClienteDTO cdto) {
		this.id = (c.getId());
		this.nombre = (c.getNombre());
		this.apellidos = (c.getApellidos());
		this.nif = (c.getNif());
		this.clave = (c.getClave());
		this.email = (c.getEmail());
		this.recomendacionDTO = (RecomendacionDTO.convertToDTO(c.getRecomendacion(), cdto));
		for (Cuenta i : c.getCuentas()) {
			this.cuentasDTO.add(CuentaDTO.convertToDTO(i, cdto));
		}
	}

	public static ClienteDTO convertToDTO(Cliente cliente) {
		ClienteDTO c = new ClienteDTO();
		c.set(cliente, c);
		return c;
	}

	public boolean isANewAcc(CuentaDTO a) {
		for (CuentaDTO c : this.cuentasDTO) {
			if (c.getId() == a.getId()) {
				return false;
			}
		}
		return true;
	}

	public CuentaDTO findAccount(CuentaDTO cdto) {
		for (CuentaDTO c : this.cuentasDTO) {
			if (c.equals(cdto)) {
				return c;
			}
		}
		return null;
	}

	public static Cliente convertToEntity(ClienteDTO cliente) {
		Cliente c = new Cliente();
		c.setId(cliente.getId());
		c.setNombre(cliente.getNombre());
		c.setApellidos(cliente.getApellidos());
		c.setNif(cliente.getNif());
		c.setClave(cliente.getClave());
		c.setEmail(cliente.getEmail());
		c.setRecomendacion(RecomendacionDTO.convertToEntity(cliente.getRecomendacionDTO(), c));
		for (CuentaDTO i : cliente.getCuentasDTO()) {
			c.getCuentas().add(CuentaDTO.convertToEntity(i, c));
		}
		return c;
	}

	public ClienteDTO() {
		super();
		this.recomendacionDTO = new RecomendacionDTO();
		id = -1;
	}
}
