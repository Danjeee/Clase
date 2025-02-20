package com.iescamp.presencial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iescamp.presencial.model.dto.CitaDTO;
import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.model.dto.PacienteDTO;
import com.iescamp.presencial.repository.dao.CitaRepository;
import com.iescamp.presencial.repository.dao.MedicoRepository;
import com.iescamp.presencial.repository.dao.PacienteRepository;
import com.iescamp.presencial.repository.entity.Cita;

@Service
public class CitaServiceImpl implements CitaService {

	@Autowired
	CitaRepository cr;

	@Autowired
	PacienteRepository pr;

	@Autowired
	MedicoRepository mr;

	@Override
	public void save(CitaDTO cita) {
		cr.save(CitaDTO.convertToEntity(cita, pr.findById(cita.getPacienteDTO().getId()).orElse(null),
				mr.findById(cita.getMedicoDTO().getId()).orElse(null)));
	}

	@Override
	public List<CitaDTO> findAllByPaciente(Integer idPaciente) {
		return cr.findAllByPaciente(idPaciente).stream()
				.map(c -> CitaDTO.convertToDTO(c, PacienteDTO.convertToDTO(pr.findById(idPaciente).orElse(null)),
						MedicoDTO.convertToDTO(mr.findById(c.getMedico().getId()).orElse(null))))
				.collect(Collectors.toList());
	}

	@Override
	public List<CitaDTO> findAll() {
		return cr.findAll().stream()
				.map(c -> CitaDTO.convertToDTO(c,
						PacienteDTO.convertToDTO(pr.findById(c.getPaciente().getId()).orElse(null)),
						MedicoDTO.convertToDTO(mr.findById(c.getMedico().getId()).orElse(null))))
				.collect(Collectors.toList());
	}

	@Override
	public CitaDTO findById(Integer idCita) {
		Cita c = cr.findById(idCita).orElse(null);
		return CitaDTO.convertToDTO(c, PacienteDTO.convertToDTO(pr.findById(c.getPaciente().getId()).orElse(null)),
				MedicoDTO.convertToDTO(mr.findById(c.getMedico().getId()).orElse(null)));
	}

	@Override
	public void deleteById(Integer idCita) {
		cr.deleteById(idCita);

	}

	@Override
	public List<CitaDTO> findAllByMedico(Integer idMedico) {
		return cr.findAllByMedico(idMedico).stream()
				.map(c -> CitaDTO.convertToDTO(c,
						PacienteDTO.convertToDTO(pr.findById(c.getPaciente().getId()).orElse(null)),
						MedicoDTO.convertToDTO(mr.findById(c.getMedico().getId()).orElse(null))))
				.collect(Collectors.toList());
	}

}
