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
public class MedicoServiceImpl implements MedicoService{
	private static final Logger log = LoggerFactory.getLogger(MedicoService.class);

	@Autowired
	MedicoRepository mr;
	
	@Autowired
	EspecialidadRepository er;
	
	@Override
	public MedicoDTO login(MedicoDTO usuario) {
		Medico m = mr.login(usuario.getMatricula(), usuario.getContrasenya()).orElse(null);
		if (m==null) {
			return null;
		} else {
			return MedicoDTO.convertToDTO(m);
		}
	}

	@Override
	public MedicoDTO findById(int id) {
		return MedicoDTO.convertToDTO(mr.findById(id).orElse(null));
	}

	@Override
	public List<MedicoDTO> findByEspecialidad(Integer idEsp) {
		return mr.findByEspecialidad(idEsp).stream().map(m->MedicoDTO.convertToDTO(m)).collect(Collectors.toList());
	}

	@Override
	public List<MedicoDTO> findAll() {
		return mr.findAll().stream().map(m->MedicoDTO.convertToDTO(m)).collect(Collectors.toList());
	}

	@Override
	public void save(MedicoDTO medicoDTO) {
		log.info(medicoDTO.toString());
		Especialidad es = er.findById(medicoDTO.getEspecialidadDTO().getId()).orElse(null);
		mr.save(MedicoDTO.convertToEntity(medicoDTO, es, null));
		
	}
	

}
