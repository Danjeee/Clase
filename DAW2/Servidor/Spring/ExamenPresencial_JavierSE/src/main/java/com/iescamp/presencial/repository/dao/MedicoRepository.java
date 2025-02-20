package com.iescamp.presencial.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.repository.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	@Query(value="SELECT * FROM medicos WHERE idespecialidad = ?1" ,nativeQuery = true)
	List<Medico> findByEspecialidad(Integer idEsp);

	@Query(value="SELECT * FROM medicos WHERE matricula = ?1 AND contrasenya = ?2", nativeQuery = true)
	Optional<Medico> login(String matricula, String contrasenya);
	
}
