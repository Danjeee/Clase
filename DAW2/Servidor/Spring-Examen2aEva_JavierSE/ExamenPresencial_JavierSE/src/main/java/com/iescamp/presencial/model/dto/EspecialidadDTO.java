package com.iescamp.presencial.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.iescamp.presencial.repository.entity.Cita;
import com.iescamp.presencial.repository.entity.Especialidad;
import com.iescamp.presencial.repository.entity.Medico;
import com.iescamp.presencial.repository.entity.Paciente;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	
	public static EspecialidadDTO convertToDTO(Especialidad e) {
		return EspecialidadDTO.builder().id(e.getId())
										.nombre(e.getNombre()).build();
	}
	public static Especialidad convertToEntity(EspecialidadDTO e, List<Medico> m) {
		return Especialidad.builder().id(e.id)
									 .nombre(e.getNombre())
									 .medicos(m)
									 .build();
	}
	
}
