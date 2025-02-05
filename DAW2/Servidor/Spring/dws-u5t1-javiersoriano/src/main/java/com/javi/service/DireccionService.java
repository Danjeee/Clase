package com.javi.service;

import java.util.List;

import com.javi.model.dto.ClienteDireccionDTO;
import com.javi.model.dto.DireccionDTO;


public interface DireccionService {

    public List<ClienteDireccionDTO> findAllByCliente(Long idCliente);

    public List<DireccionDTO> findAll();

    public DireccionDTO findById(Long id);

    public void save(DireccionDTO direccionDTO, Long idCliente);

    public void addExistente(DireccionDTO direccionDTO, Long idCliente);

    public void deleteById(Long id);
}
