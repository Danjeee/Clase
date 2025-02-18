package com.javi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.ClientesEmpresaDTO;
import com.javi.model.dto.DireccionDTO;
import com.javi.model.dto.EmpresaDTO;
import com.javi.model.dto.ServicioDTO;
import com.javi.repository.dao.ClienteRepository;
import com.javi.repository.dao.ClientesEmpresaRepository;
import com.javi.repository.dao.EmpresaRepository;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.ClienteDireccion;
import com.javi.repository.entity.Empresa;
import com.javi.repository.entity.Servicio;
import com.javi.repository.entity.ClienteEmpresa;
import com.javi.repository.entity.ClienteServicio;
import com.javi.repository.entity.Direccion;

@Service
public class EmpresaServiceImpl implements EmpresaService {

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
		List<ClientesEmpresaDTO> out = aux.stream().map(e -> ClientesEmpresaDTO.convertToDTO(e,
				ClienteDTO.convertToDTO(cli), EmpresaDTO.convertToDTO(e.getEmpresa()))).collect(Collectors.toList());

		return out;
	}

	@Override
	public EmpresaDTO findById(Long id) {
		return EmpresaDTO.convertToDTO(er.findById(id).orElse(null));
	}

	@Override
	public void save(EmpresaDTO empresaDTO, Long idCliente) {
		List<ClienteEmpresa> listaClienteempresaes = this.cer.findAllByCliente(idCliente);
		Empresa empresa = empresaDTO.convertToEntity(empresaDTO, listaClienteempresaes);
		this.er.save(empresa);

		if (empresaDTO.getId() == null) {
			Cliente cliente = this.cr.findById(idCliente).orElse(null);
			cliente.getListaClienteempresa().add(ClienteEmpresa.builder().cliente(cliente).empresa(empresa)
					.puesto(empresaDTO.getP_aux()).anos_en_empresa(empresaDTO.getA_aux()).build());
			this.cr.save(cliente);
		}

	}

	@Override
	public void deleteById(Long id) {
		this.er.deleteById(id);

	}

	@Override
	public void addExistente(EmpresaDTO empresaDTO, Long idCliente) {
		List<ClienteEmpresa> listacer = this.cer.findAllByCliente(idCliente);
		Empresa emp = EmpresaDTO.convertToEntity(empresaDTO, listacer);
		er.save(emp);

		ClienteEmpresa cs = this.cer
				.findByClienteIdAndEmpresaId(idCliente, emp.getId())
				.orElse(ClienteEmpresa.builder().cliente(this.cr.findById(idCliente).orElse(null))
						.empresa(emp).puesto(empresaDTO.getP_aux()).anos_en_empresa(empresaDTO.getA_aux()).build());
		cs.setAnos_en_empresa(empresaDTO.getA_aux());
		cs.setPuesto(empresaDTO.getP_aux());
		Cliente cliente = this.cr.findById(idCliente).orElse(null);
		cliente.getListaClienteempresa().add(cs);
		cr.save(cliente);
		cer.save(cs);
	}

	@Override
	public EmpresaDTO findByParams(EmpresaDTO empresaDTO) {
		try {
			return EmpresaDTO
					.convertToDTO(er.findbyParams(empresaDTO.getNombre(), empresaDTO.getDescripcion()).orElse(null));
		} catch (NullPointerException ex) {
			return null;
		}
	}

	@Override
	public void remove(Long id, Long idCliente) {
		Cliente cli = cr.findById(idCliente).orElse(null);
		ClienteEmpresa cs = cer.findByClienteIdAndEmpresaId(idCliente, id).orElse(null);

		Empresa emp = er.findById(id).orElse(null);
		if (emp.getListaclientesempresa().size() - 1 > 0) {
			emp.getListaclientesempresa().remove(cs);
			er.save(emp);
		} else {
			er.deleteById(id);
		}
		cer.deleteById(cs.getId());
		cli.getListaClienteServicios().remove(cs);
		cr.save(cli);

	}

	@Override
	public ClientesEmpresaDTO findbyClienteAndEmpresa(Long idCliente, Long id) {
		ClienteDTO cdto = ClienteDTO.convertToDTO(cr.findById(idCliente).orElse(null));
		EmpresaDTO edto = EmpresaDTO.convertToDTO(er.findById(id).orElse(null));
		return ClientesEmpresaDTO.convertToDTO(cer.findByClienteIdAndEmpresaId(idCliente, id).orElse(null), cdto, edto);
	}

	@Override
	public void addToExistent(EmpresaDTO empresaDTO, Long idCliente) {
		Cliente cli = cr.findById(idCliente).orElse(null);
        Empresa emp = er.findbyParams(empresaDTO.getNombre(), empresaDTO.getDescripcion()).orElse(null);
        ClienteEmpresa cs = ClienteEmpresa.builder().cliente(cli).empresa(emp).puesto(empresaDTO.getP_aux()).anos_en_empresa(empresaDTO.getA_aux()).build();
        cer.save(cs);
        cli.getListaClienteempresa().add(cs);
        cr.save(cli);
        emp.getListaclientesempresa().add(cs);
        er.save(emp);
	}

}
