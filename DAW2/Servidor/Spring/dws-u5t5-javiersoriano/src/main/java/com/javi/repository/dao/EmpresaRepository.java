package com.javi.repository.dao;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Empresa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
@Transactional
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	@Query(value="SELECT * FROM empresas WHERE nombre = ?1 AND descripcion = ?2", nativeQuery = true)
	Optional<Empresa> findbyParams(String nombre, String descripcion);

}
