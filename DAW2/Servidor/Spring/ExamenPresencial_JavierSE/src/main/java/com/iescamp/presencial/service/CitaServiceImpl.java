package com.iescamp.presencial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescamp.presencial.model.dto.CitaDTO;
import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.model.dto.PacienteDTO;
import com.iescamp.presencial.repository.dao.CitaRepository;
import com.iescamp.presencial.repository.dao.MedicoRepository;
import com.iescamp.presencial.repository.dao.PacienteRepository;
import com.iescamp.presencial.repository.entity.Cita;
import com.iescamp.presencial.web.controller.CitaController;

@Service
public class CitaServiceImpl implements CitaService {
	private static final Logger log = LoggerFactory.getLogger(CitaService.class);

	@Autowired
	CitaRepository clienteRepository;

	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	MedicoRepository medicoRepository;

	@Override
	public void save(CitaDTO cita) { // Guardado
		log.info("Guardamos la cita: " + cita);
		clienteRepository.save(
				CitaDTO.convertToEntity(cita, pacienteRepository.findById(cita.getPacienteDTO().getId()).orElse(null),
						medicoRepository.findById(cita.getMedicoDTO().getId()).orElse(null)));
	}

	@Override
	public List<CitaDTO> findAllByPaciente(Integer idPaciente) { // Mostrar todas las citas buscando por paciente
		log.info("Buscamos todas las citas del paciente con id: " + idPaciente);
		return clienteRepository.findAllByPaciente(idPaciente).stream()
				.map(c -> CitaDTO.convertToDTO(c,
						PacienteDTO.convertToDTO(pacienteRepository.findById(idPaciente).orElse(null)),
						MedicoDTO.convertToDTO(medicoRepository.findById(c.getMedico().getId()).orElse(null))))
				.collect(Collectors.toList());
	}

	@Override
	public List<CitaDTO> findAll() { // Mostrar todas las citas
		log.info("Recuperamos todas las citas");
		return clienteRepository.findAll().stream()
				.map(c -> CitaDTO.convertToDTO(c,
						PacienteDTO.convertToDTO(pacienteRepository.findById(c.getPaciente().getId()).orElse(null)),
						MedicoDTO.convertToDTO(medicoRepository.findById(c.getMedico().getId()).orElse(null))))
				.collect(Collectors.toList());
	}

	@Override
	public CitaDTO findById(Integer idCita) { // Buscar una cita por id
		log.info("Buscamos la cita con id: " + idCita);
		Cita c = clienteRepository.findById(idCita).orElse(null);
		return CitaDTO.convertToDTO(c,
				PacienteDTO.convertToDTO(pacienteRepository.findById(c.getPaciente().getId()).orElse(null)),
				MedicoDTO.convertToDTO(medicoRepository.findById(c.getMedico().getId()).orElse(null)));
	}

	@Override
	public void deleteById(Integer idCita) { // Borrar una cita por id
		log.info("Borramos la cita con id: " + idCita);
		clienteRepository.deleteById(idCita);

	}

	@Override
	public List<CitaDTO> findAllByMedico(Integer idMedico) { // Buscar todas las citas de un medico
		log.info("Buscamos todas las citas del medico con id: " + idMedico);
		return clienteRepository.findAllByMedico(idMedico).stream()
				.map(c -> CitaDTO.convertToDTO(c,
						PacienteDTO.convertToDTO(pacienteRepository.findById(c.getPaciente().getId()).orElse(null)),
						MedicoDTO.convertToDTO(medicoRepository.findById(c.getMedico().getId()).orElse(null))))
				.collect(Collectors.toList());
	}

}
