package com.javi.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javi.repository.entity.ClienteDireccion;
import com.javi.repository.entity.ClienteServicio;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ClienteServicioRepository extends JpaRepository<ClienteDireccion, Long> {

    @Query("SELECT c FROM ClienteServicio c WHERE c.cliente.id = :idCliente AND c.servicio.id = :idServicio")
    Optional<ClienteServicio> findByClienteIdAndServicioId(@Param("idCliente") Long idCliente,
            @Param("idServicio") Long idServicio);

    @Query("SELECT c FROM ClienteServicio c WHERE c.cliente.id = :idCliente")
    List<ClienteServicio> findByClienteId(@Param("idCliente") Long idCliente);
}
