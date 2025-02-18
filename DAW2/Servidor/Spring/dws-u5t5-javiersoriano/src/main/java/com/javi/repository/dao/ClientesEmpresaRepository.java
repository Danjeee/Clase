package com.javi.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javi.repository.entity.ClienteEmpresa;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ClientesEmpresaRepository extends JpaRepository<ClienteEmpresa, Long>{

	@Query(value="SELECT * FROM clientesempresas WHERE id_cliente = :idc", nativeQuery = true)
	List<ClienteEmpresa> findAllByCliente(@Param("idc")Long idCliente);

}
