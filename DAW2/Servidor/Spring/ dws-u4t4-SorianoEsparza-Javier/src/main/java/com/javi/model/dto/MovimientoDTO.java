package com.javi.model.dto;

import java.util.Objects;

import com.javi.repository.entity.Movimiento;

import lombok.Data;

@Data
public class MovimientoDTO {
	public long id;
	public String tipo;
	public CuentaDTO emisor;
	public CuentaDTO receptor;
	public float cant;
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
		this.emisor = CuentaDTO.convertToDTO(mov.getEmisor(), ClienteDTO.convertToDTO(mov.getEmisor().getCliente()));
		this.receptor =  CuentaDTO.convertToDTO(mov.getReceptor(), ClienteDTO.convertToDTO(mov.getReceptor().getCliente()));
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
		mov.setEmisor(CuentaDTO.convertToEntity(mdto.getEmisor(), ClienteDTO.convertToEntity(mdto.getEmisor().getClienteDTO())));
		mov.setEmisor(CuentaDTO.convertToEntity(mdto.getReceptor(), ClienteDTO.convertToEntity(mdto.getReceptor().getClienteDTO())));
		
		return mov;
	}
	public MovimientoDTO() {
		super();
		id = -1;
	}
}
