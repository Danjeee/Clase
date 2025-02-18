package com.javi.repository.dao;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import com.javi.repository.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@Transactional
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
