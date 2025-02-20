package com.iescamp.presencial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.repository.dao.EspecialidadRepository;
import com.iescamp.presencial.repository.dao.MedicoRepository;
import com.iescamp.presencial.repository.entity.Especialidad;
import com.iescamp.presencial.repository.entity.Medico;
import com.iescamp.presencial.web.controller.PacienteController;

@Service
public class MedicoServiceImpl implements MedicoService {
	private static final Logger log = LoggerFactory.getLogger(MedicoService.class);

	@Autowired
	MedicoRepository medicoRepository;

	@Autowired
	EspecialidadRepository especialidadRepository;

	@Override
	public MedicoDTO login(MedicoDTO usuario) { // Metodo para iniciar sesion, devuelve null si las credenciales no son correctas
		log.info("Comprobamos si las credenciales para iniciar sesión de matricula: " + usuario.getMatricula()
				+ " y contraseña: " + usuario.getContrasenya() + " son correctas");
		Medico m = medicoRepository.login(usuario.getMatricula(), usuario.getContrasenya()).orElse(null);
		if (m == null) {
			return null;
		} else {
			return MedicoDTO.convertToDTO(m);
		}
	}

	@Override
	public MedicoDTO findById(int id) { // Mostrar un metodo por id
		log.info("Buscamos el medico con id: " + id);
		return MedicoDTO.convertToDTO(medicoRepository.findById(id).orElse(null));
	}

	@Override
	public List<MedicoDTO> findByEspecialidad(Integer idEsp) { // Mostrar todos los medicos por especialidad
		log.info("Buscamos todos los medicos de la especialidad con id: " + idEsp);
		return medicoRepository.findByEspecialidad(idEsp).stream().map(m -> MedicoDTO.convertToDTO(m))
				.collect(Collectors.toList());
	}

	@Override
	public List<MedicoDTO> findAll() { // Mostrar todos los medicos
		log.info("Buscamos todos los medicos");
		return medicoRepository.findAll().stream().map(m -> MedicoDTO.convertToDTO(m)).collect(Collectors.toList());
	}

	@Override
	public void save(MedicoDTO medicoDTO) { // Guardar un medico
		log.info("Guardamos el medico: " + medicoDTO);
		Especialidad es = especialidadRepository.findById(medicoDTO.getEspecialidadDTO().getId()).orElse(null);
		medicoRepository.save(MedicoDTO.convertToEntity(medicoDTO, es, null));

	}

}
