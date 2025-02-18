package com.javi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.ClientesEmpresaDTO;
import com.javi.model.dto.EmpresaDTO;
import com.javi.repository.dao.ClienteRepository;
import com.javi.repository.dao.ClientesEmpresaRepository;
import com.javi.repository.dao.EmpresaRepository;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.ClienteEmpresa;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	ClientesEmpresaRepository cer;
	
	@Autowired
	EmpresaRepository er;
	
	@Autowired
	ClienteRepository cr;
	
	@Override
	public List<ClientesEmpresaDTO> findAllByCliente(Long idCliente) {
		
		Cliente cli = cr.findById(idCliente).orElse(null);
		List<ClienteEmpresa> aux = cer.findAllByCliente(idCliente);
		List<ClientesEmpresaDTO> out = aux.stream().map(e -> ClientesEmpresaDTO.convertToDTO(e, ClienteDTO.convertToDTO(cli), EmpresaDTO.convertToDTO(e.getEmpresa()))).collect(Collectors.toList());
		
		return out;
	}

	@Override
	public List<EmpresaDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpresaDTO findById(Long id) {
		return EmpresaDTO.convertToDTO(er.findById(id).orElse(null));
	}

	@Override
	public void save(EmpresaDTO empresaDTO, Long idCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
