package com.iescamp.presencial.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iescamp.presencial.model.dto.CitaDTO;
import com.iescamp.presencial.repository.entity.Cita;
import com.iescamp.presencial.repository.entity.Paciente;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{

	@Query(value="SELECT * FROM citas WHERE idpaciente = ?1", nativeQuery = true)
	List<Cita> findAllByPaciente(Integer idPaciente);

	@Query(value="SELECT * FROM citas WHERE idmedico = ?1", nativeQuery = true)
	List<Cita> findAllByMedico(Integer idMedico);
}
