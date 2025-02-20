package com.iescamp.presencial.service;

import java.util.List;

import com.iescamp.presencial.model.dto.CitaDTO;

public interface CitaService {

	void save(CitaDTO cita);

	List<CitaDTO> findAllByPaciente(Integer idPaciente);

	List<CitaDTO> findAll();

	CitaDTO findById(Integer idCita);

	void deleteById(Integer idCita);

	List<CitaDTO> findAllByMedico(Integer id);


}
