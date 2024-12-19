package com.javi.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface clienteRepository extends JpaRepository<Cliente, Integer> {
	@Modifying
	@Query(value="UPDATE clientes SET nif = ?1, nombre = ?2, apellidos = ?3, claveseguridad = ?4, email = ?5 WHERE id = ?6", nativeQuery=true)
	void update(String nif, String nombre, String apellidos, String clave, String email, int id);
}
