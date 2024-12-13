package com.javi.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
	@Query(value="SELECT * FROM CUENTAS WHERE idcliente = :codigoCliente", nativeQuery = true)
	public List<Cuenta> findAllByCliente(@Param("codigoCliente") Integer idCliente);
}
