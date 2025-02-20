package com.iescamp.presencial.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.iescamp.presencial.repository.entity.Cita;
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
public class PacienteDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private int id;
	private String nombre;
	private String apellidos;
	private String nif;
    @DateTimeFormat(iso = ISO.DATE)
	private Date fechanacimiento;
	private int telefono;
	private String direccion;
	
	public static PacienteDTO convertToDTO(Paciente p) {
		return PacienteDTO.builder().id(p.getId())
									.nombre(p.getNombre())
									.apellidos(p.getApellidos())
									.nif(p.getNif())
									.fechanacimiento(p.getFechanacimiento())
									.telefono(Integer.parseInt(p.getTelefono()))
									.direccion(p.getDireccion())
									.build();
	}
	public static Paciente convertToEntity(PacienteDTO p, List<Cita> c) {
		return Paciente.builder().id(p.getId())
									.nombre(p.getNombre())
									.apellidos(p.getApellidos())
									.nif(p.getNif())
									.fechanacimiento(p.getFechanacimiento())
									.telefono(String.valueOf(p.getTelefono()))
									.direccion(p.getDireccion())
									.citas(c)
									.build();
	}

}
