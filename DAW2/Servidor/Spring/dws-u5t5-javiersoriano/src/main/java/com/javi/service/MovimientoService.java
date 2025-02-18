package com.javi.service;

import java.util.List;

import com.javi.model.dto.MovimientoDTO;


public interface MovimientoService {

    public List<MovimientoDTO> findAllByCuentaOrigen(Long idCuenta);

    public List<MovimientoDTO> findAllByCuentaDestino(Long idCuenta);

    public MovimientoDTO findById(Long id);

    public void save(MovimientoDTO movimientoDTO, Long idCuentaOrigen, Long idCuentaDestino);

    public void deleteById(Long id);
}
