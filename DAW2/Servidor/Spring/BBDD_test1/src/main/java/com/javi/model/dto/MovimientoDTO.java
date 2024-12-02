package com.javi.model.dto;

import java.util.Date;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;
import com.javi.web.controller.MovimientoController;

import lombok.Data;
import lombok.ToString;

@Data
public class MovimientoDTO {
	
	private static final Logger log = LoggerFactory.getLogger(MovimientoDTO.class);
	private long id;
	private String tipo;
	@ToString.Exclude
	private CuentaDTO idEmisor;
	@ToString.Exclude
	private CuentaDTO idReceptor;
	private float cant;
	private Date fecha;

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
/*
	public void setMovimientoDTO(Movimiento mov) {
		this.id = mov.getId();
		this.tipo = mov.getTipo();
		this.cant = mov.getCant();
		CuentaDTO emisor = new CuentaDTO();
		emisor.setId(mov.getIdEmisor().getId());
		this.idEmisor = emisor;
		CuentaDTO receptor = new CuentaDTO();
		receptor.setId(mov.getIdReceptor().getId());
		this.idReceptor = receptor;
		this.fecha = mov.getFecha();
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
		Cuenta emisor = new Cuenta();
		emisor.setId(mdto.getIdEmisor().getId());
		Cuenta receptor = new Cuenta();
		receptor.setId(mdto.getIdReceptor().getId());
		mov.setIdEmisor(emisor);
		mov.setIdReceptor(receptor);
		mov.setFecha(mdto.getFecha());

		return mov;
	}

	public MovimientoDTO() {
		super();
		id = -1;
	}
	*/
}
