package com.iescamp.presencial.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.service.EspecialidadService;
import com.iescamp.presencial.service.MedicoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	
	private static final Logger log = LoggerFactory.getLogger(MedicoController.class);
	
	@Autowired
	MedicoService ms;
	@Autowired
	EspecialidadService es;

	@GetMapping("/especialidades/{idEsp}")
	public ModelAndView showPorEspecialidades(@PathVariable("idEsp")Integer idEsp, HttpSession http) {
		if (((MedicoDTO)http.getAttribute("usuario")).isAdministrador()) {
			log.info("Mostramos todos los medicos de la especialidad: "+es.findById(idEsp));
			ModelAndView mvc = new ModelAndView("medicos");
			mvc.addObject("listaMedicosDTO", ms.findByEspecialidad(idEsp));
			return LoginController.checkLogged(http, mvc);
		} else {
			log.info("Al no ser admin no puedes acceder aqui");
			return new ModelAndView("redirect:/principal");
		}
		
	}
	
	@GetMapping("")
	public ModelAndView show(HttpSession http) {
		if (((MedicoDTO)http.getAttribute("usuario")).isAdministrador()) {
			log.info("Mostramos todos los medicos");
			ModelAndView mvc = new ModelAndView("medicos");
			mvc.addObject("listaMedicosDTO", ms.findAll());
			return LoginController.checkLogged(http, mvc);
		} else {
			log.info("Al no ser admin no puedes acceder aqui");
			return new ModelAndView("redirect:/principal");
		}
		
	}
	
	
}
