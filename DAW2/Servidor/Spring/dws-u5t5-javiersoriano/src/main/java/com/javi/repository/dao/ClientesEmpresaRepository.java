package com.javi.repository.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javi.model.dto.ClientesEmpresaDTO;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.ClienteEmpresa;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ClientesEmpresaRepository extends JpaRepository<ClienteEmpresa, Long>{

	@Query(value="SELECT * FROM clientesempresas WHERE id_cliente = :idc", nativeQuery = true)
	List<ClienteEmpresa> findAllByCliente(@Param("idc")Long idCliente);

	@Query(value = "SELECT * FROM clientesempresas WHERE id_cliente = ?1 AND id_empresa = ?2", nativeQuery = true)
	Optional<ClienteEmpresa> findByClienteIdAndEmpresaId(Long idCliente, Long id);

	@Query(value= "SELECT * FROM clientesempresas WHERE id_empresa = ?1", nativeQuery = true)
	List<ClienteEmpresa> findAllByEmpresa(Long id);

}
