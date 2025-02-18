package com.javi.service;

import java.util.List;

import com.javi.model.dto.ClientesEmpresaDTO;
import com.javi.model.dto.EmpresaDTO;

public interface EmpresaService {
	public List<ClientesEmpresaDTO> findAllByCliente(Long idCliente);

    public EmpresaDTO findById(Long id);

    public void save(EmpresaDTO empresaDTO, Long idCliente);

    public void deleteById(Long id);

	public void addExistente(EmpresaDTO empresaDTO, Long idCliente);

	public EmpresaDTO findByParams(EmpresaDTO empresaDTO);

	public void remove(Long id, Long idCliente);

	public ClientesEmpresaDTO findbyClienteAndEmpresa(Long idCliente, Long id);

	public void addToExistent(EmpresaDTO empresaDTO, Long idCliente);
}
