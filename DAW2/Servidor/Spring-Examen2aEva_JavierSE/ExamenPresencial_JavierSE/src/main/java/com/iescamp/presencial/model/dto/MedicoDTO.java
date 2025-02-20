package com.iescamp.presencial.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
public class MedicoDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
	private String nombre;
	private String apellidos;
	private String matricula;
	private int telefono;
	private String contrasenya;
	private boolean administrador;
	private EspecialidadDTO especialidadDTO;

	public static MedicoDTO convertToDTO(Medico m) {
		return MedicoDTO.builder().id(m.getId())
				  .nombre(m.getNombre())
				  .apellidos(m.getApellidos())
				  .matricula(m.getMatricula())
				  .telefono(Integer.parseInt(m.getTelefono()))
				  .contrasenya(m.getContrasenya())
				  .administrador(m.isAdministrador())
				  .especialidadDTO(EspecialidadDTO.convertToDTO(m.getEspecialidad()))
				  .build();
		
	}
	
	public static Medico convertToEntity(MedicoDTO m, Especialidad e, List<Cita> c) {
		return Medico.builder().id(m.getId())
				  .nombre(m.getNombre())
				  .apellidos(m.getApellidos())
				  .matricula(m.getMatricula())
				  .telefono(String.valueOf(m.getTelefono()))
				  .contrasenya(m.getContrasenya())
				  .administrador(m.isAdministrador())
				  .especialidad(e)
				  .citas(c)
				  .build();
	}
	
}
