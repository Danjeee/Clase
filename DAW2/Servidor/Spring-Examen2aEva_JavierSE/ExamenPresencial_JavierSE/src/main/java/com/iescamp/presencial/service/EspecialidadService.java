package com.iescamp.presencial.service;

import java.util.List;

import com.iescamp.presencial.model.dto.EspecialidadDTO;

public interface EspecialidadService {

	List<EspecialidadDTO> findAll();

	EspecialidadDTO findById(Integer idEsp);

}
