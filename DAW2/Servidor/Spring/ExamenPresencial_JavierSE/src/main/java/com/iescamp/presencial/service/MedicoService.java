package com.iescamp.presencial.service;

import java.util.List;

import com.iescamp.presencial.model.dto.MedicoDTO;

public interface MedicoService {

	MedicoDTO login(MedicoDTO usuario);

	MedicoDTO findById(int id);

	List<MedicoDTO> findByEspecialidad(Integer idEsp);

	List<MedicoDTO> findAll();

	void save(MedicoDTO medicoDTO);

}
