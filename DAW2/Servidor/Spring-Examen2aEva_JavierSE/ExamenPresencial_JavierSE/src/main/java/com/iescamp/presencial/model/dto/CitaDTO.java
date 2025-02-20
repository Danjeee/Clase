package com.iescamp.presencial.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.iescamp.presencial.repository.entity.Cita;
import com.iescamp.presencial.repository.entity.Medico;
import com.iescamp.presencial.repository.entity.Paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fechahora;
	private boolean estado;
	private PacienteDTO pacienteDTO;
	private MedicoDTO medicoDTO;

	public static CitaDTO convertToDTO(Cita c, PacienteDTO p, MedicoDTO m) {
		return CitaDTO.builder().id(c.getId())
								.fechahora(c.getFechahora())
								.estado(c.isEstado())
								.pacienteDTO(p)
								.medicoDTO(m)
								.build();
	}

	public static Cita convertToEntity(CitaDTO c, Paciente p, Medico m) {
		return Cita.builder().id(c.getId())
							 .fechahora(c.getFechahora())
							 .estado(c.isEstado())
							 .paciente(p)
							 .medico(m)
							 .build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CitaDTO other = (CitaDTO) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
