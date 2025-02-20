package com.iescamp.presencial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescamp.presencial.model.dto.EspecialidadDTO;
import com.iescamp.presencial.repository.dao.EspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

	@Autowired
	EspecialidadRepository er;
	
	@Override
	public List<EspecialidadDTO> findAll() {
		return er.findAll().stream().map(e->EspecialidadDTO.convertToDTO(e)).collect(Collectors.toList());
	}

	@Override
	public EspecialidadDTO findById(Integer idEsp) {
		return EspecialidadDTO.convertToDTO(er.findById(idEsp).orElse(null));
	}
	
}
