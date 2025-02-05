package com.javi.service;

import java.util.List;

import com.javi.model.dto.CuentaDTO;


public interface CuentaService {

    public List<CuentaDTO> findAllByCliente(Long idCliente);

    public CuentaDTO findById(Long id);

    public void save(CuentaDTO cuentaDTO, Long idCliente);

    public void deleteById(Long id);
}
