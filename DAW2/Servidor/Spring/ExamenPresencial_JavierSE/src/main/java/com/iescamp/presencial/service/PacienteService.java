package com.iescamp.presencial.service;

import java.util.List;

import com.iescamp.presencial.model.dto.PacienteDTO;

public interface PacienteService {

	List<PacienteDTO> findAll();

	void save(PacienteDTO paciente);

	PacienteDTO findById(Integer idPaciente);

	void deleteById(Integer idPaciente);

}
