package com.javi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.javi.service.ClienteService;
import com.javi.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaservice; 
	
	@Autowired
	ClienteService cs;
	
	@GetMapping("/clientes/{idCliente}/empresas")
	public ModelAndView showAllByUser(@PathVariable Long idCliente) {
		ModelAndView mvc = new ModelAndView("empresas")
									.addObject("listaEmpresasDTO", empresaservice.findAllByCliente(idCliente))
									.addObject("clienteDTO", cs.findById(idCliente) );
		
		return mvc;
	}
	
	@GetMapping("/clientes/{idCliente}/empresas/{idEmpresa}")
	public ModelAndView show(@PathVariable Long idCliente, @PathVariable Long idEmpresa) {
		ModelAndView mvc = new ModelAndView("empresashow")
									.addObject("empresaDTO", empresaservice.findById(idEmpresa))
									.addObject("idCliente", idCliente );
		
		return mvc;
	}
}
