package com.iescamp.presencial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescamp.presencial.model.dto.PacienteDTO;
import com.iescamp.presencial.repository.dao.PacienteRepository;
import com.iescamp.presencial.web.controller.CitaController;

@Service
public class PacienteServiceImpl implements PacienteService {
	private static final Logger log = LoggerFactory.getLogger(PacienteService.class);

	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public List<PacienteDTO> findAll() { // Mostrar todos los pacientes
		log.info("Buscamos todos los pacientes");
		return pacienteRepository.findAll().stream().map(p -> PacienteDTO.convertToDTO(p)).collect(Collectors.toList());
	}

	@Override
	public void save(PacienteDTO paciente) { // Guardar un paciente
		log.info("Guardamos el paciente: " + paciente);
		pacienteRepository.save(PacienteDTO.convertToEntity(paciente, null));
	}

	@Override
	public PacienteDTO findById(Integer idPaciente) { // Mostrar un paciente por id
		log.info("Buscamos el paciente con id: " + idPaciente);
		return PacienteDTO.convertToDTO(pacienteRepository.findById(idPaciente).orElse(null));
	}

	@Override
	public void deleteById(Integer idPaciente) { // Borra un paciente por id
		log.info("Borramos el paciente con id: " + idPaciente);
		pacienteRepository.deleteById(idPaciente);

	}

}
