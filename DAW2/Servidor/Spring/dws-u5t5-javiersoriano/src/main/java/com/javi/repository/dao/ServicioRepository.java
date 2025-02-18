package com.javi.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javi.repository.entity.Direccion;
import com.javi.repository.entity.Servicio;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    @Query(value = "SELECT A.* FROM servicios A, clientesservicios B "
            + " WHERE A.id=B.idservicio AND B.idcliente = :idcliente", nativeQuery = true)
    public List<Servicio> findAllByCliente(@Param("idcliente") Long idCliente);

    @Query(value = "SELECT id FROM servicios ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public Long getLast();
    
    @Query(value = "SELECT * FROM servicios WHERE nombre_servicio = :name AND descripcion = :descripcion", nativeQuery = true)
	public Optional<Servicio> findbyParams(@Param("name")String name, @Param("descripcion")String desc);
    
    @Modifying
    @Query(value = "UPDATE clientesservicios SET precio_personalizado = :precio WHERE id = :idCS", nativeQuery = true)
	public void updatePrice(@Param("idCS")Long idCS, @Param("precio") float precio);
}
