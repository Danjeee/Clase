package com.javi.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javi.model.dto.ClienteDTO;
import com.javi.service.clienteService;
import com.javi.service.clienteServiceImpl;

@Controller
public class ClienteController {
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	@Autowired
	private clienteService cs;
	
	@GetMapping("/clientes")
	public ModelAndView findAll() {
	log.info("clientes");	
	ModelAndView mvc = new ModelAndView("index");
	List<ClienteDTO> listaclientesDTO = cs.findAll();
	mvc.addObject("lista", listaclientesDTO);
	log.info(listaclientesDTO.toString());
	return mvc;
	}
}
