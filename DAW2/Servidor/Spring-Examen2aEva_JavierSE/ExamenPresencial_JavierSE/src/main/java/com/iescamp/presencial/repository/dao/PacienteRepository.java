package com.iescamp.presencial.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iescamp.presencial.repository.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	
}