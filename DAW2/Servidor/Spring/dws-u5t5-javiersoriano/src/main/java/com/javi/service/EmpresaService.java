package com.javi.service;

import java.util.List;

import com.javi.model.dto.ClientesEmpresaDTO;
import com.javi.model.dto.EmpresaDTO;

public interface EmpresaService {
	public List<ClientesEmpresaDTO> findAllByCliente(Long idCliente);

    public List<EmpresaDTO> findAll();

    public EmpresaDTO findById(Long id);

    public void save(EmpresaDTO empresaDTO, Long idCliente);

    public void deleteById(Long id);
}
