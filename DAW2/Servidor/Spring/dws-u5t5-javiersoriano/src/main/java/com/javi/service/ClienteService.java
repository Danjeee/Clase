package com.javi.service;

import java.util.List;

import com.javi.model.dto.ClienteDTO;


public interface ClienteService {

    public List<ClienteDTO> findAll();

    public ClienteDTO findById(Long id);

    public void save(ClienteDTO clienteDTO);

    public void deleteById(Long id);
}
