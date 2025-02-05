package com.javi.service;

import java.util.List;

import com.javi.model.dto.ClienteServicioDTO;
import com.javi.model.dto.ServicioDTO;


public interface ServicioService {

    public List<ClienteServicioDTO> findAllByCliente(Long idCliente);

    public List<ServicioDTO> findAll();

    public ServicioDTO findById(Long id);

    public void save(ServicioDTO ServicioDTO, Long idCliente);

    public void addExistente(ServicioDTO ServicioDTO, Long idCliente);

    public void deleteById(Long id);
}
