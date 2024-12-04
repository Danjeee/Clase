package com.javi.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javi.repository.entity.Recomendacion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface recomendacionRepository extends JpaRepository<Recomendacion, Integer> {

}
