package com.iescamp.presencial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescamp.presencial.model.dto.EspecialidadDTO;
import com.iescamp.presencial.repository.dao.EspecialidadRepository;
import com.iescamp.presencial.web.controller.CitaController;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

	private static final Logger log = LoggerFactory.getLogger(EspecialidadService.class);

	@Autowired
	EspecialidadRepository especialidadRepository;

	@Override
	public List<EspecialidadDTO> findAll() { // Mostrar todas las especialidades
		log.info("Buscamos todas las especialidades");
		return especialidadRepository.findAll().stream().map(e -> EspecialidadDTO.convertToDTO(e))
				.collect(Collectors.toList());
	}

	@Override
	public EspecialidadDTO findById(Integer idEsp) { // Mostrar una especialidad por id
		log.info("Buscamos la especialidad con id: " + idEsp);
		return EspecialidadDTO.convertToDTO(especialidadRepository.findById(idEsp).orElse(null));
	}

}
