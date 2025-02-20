package com.iescamp.presencial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescamp.presencial.model.dto.PacienteDTO;
import com.iescamp.presencial.repository.dao.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	PacienteRepository pr;
	
	@Override
	public List<PacienteDTO> findAll() {
		return pr.findAll().stream().map(p->PacienteDTO.convertToDTO(p)).collect(Collectors.toList());
	}

	@Override
	public void save(PacienteDTO paciente) {
		pr.save(PacienteDTO.convertToEntity(paciente, null));
	}

	@Override
	public PacienteDTO findById(Integer idPaciente) {
		return PacienteDTO.convertToDTO(pr.findById(idPaciente).orElse(null));
	}

	@Override
	public void deleteById(Integer idPaciente) {
		pr.deleteById(idPaciente);
		
	}
	
}
