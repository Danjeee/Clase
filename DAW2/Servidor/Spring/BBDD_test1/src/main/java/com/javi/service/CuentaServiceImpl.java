package com.javi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.CuentaDTO;
import com.javi.repository.dao.CuentaRepository;
import com.javi.repository.dao.clienteRepository;import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;

public class CuentaServiceImpl implements CuentaService {

	private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);
	
	@Autowired
	CuentaRepository cr;
	@Autowired
	clienteService clir;

	@Override
	public void save(CuentaDTO cdto) {
		ClienteDTO clid = clir.findById(cdto.getClienteDTO());
		if (cdto.getId() != -1) {
			cr.update(CuentaDTO.convertToEntity(cdto, ClienteDTO.convertToEntity(clid)));
		} else {
			String id = "1" + String.valueOf(clid.getId()) + "" + String.valueOf(clid.getCuentasDTO().size());
			cdto.setId(Integer.parseInt(id));
			cr.save(CuentaDTO.convertToEntity(cdto, ClienteDTO.convertToEntity(clid)));
		}

	}

	@Override
	public void delete(CuentaDTO cuv) {
		cr.delete(CuentaDTO.convertToEntity(cuv, ClienteDTO.convertToEntity(clir.findById(cuv.getClienteDTO()))));

	}

	@Override
	public CuentaDTO findById(CuentaDTO cu) {
		Optional<Cuenta> cuaux = cr.findById(cu.getId());
		CuentaDTO c = new CuentaDTO();
		if (cuaux.isPresent()) {
			c = CuentaDTO.convertToDTO(cu);
		}
		return c;
		
	}

	@Override
	public List<CuentaDTO> findAllByCliente(ClienteDTO c) {
		List<CuentaDTO> listadtos = new ArrayList<CuentaDTO>();
		for (Cuenta cu : cr.findAllByCliente(c.getId())) {
			listadtos.add(CuentaDTO.convertToDTO(cu, c));
		}
		
		return listadtos;
	}

}
