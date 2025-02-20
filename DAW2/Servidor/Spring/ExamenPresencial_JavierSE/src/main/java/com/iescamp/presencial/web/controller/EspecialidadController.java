package com.iescamp.presencial.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.service.EspecialidadService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadController {
	private static final Logger log = LoggerFactory.getLogger(EspecialidadController.class);

	@Autowired
	EspecialidadService especialidadService;

	@GetMapping("")
	public ModelAndView showall(HttpSession http) { // Muestra todas las especialidades
		if (((MedicoDTO) http.getAttribute("usuario")).isAdministrador()) { // Si eres admin, puedes acceder
			log.info("Mostramos todas las especialidades");
			ModelAndView mvc = new ModelAndView("especialidades");
			mvc.addObject("listaEspecialidadesDTO", especialidadService.findAll());
			return LoginController.checkLogged(http, mvc);
		} else { // Si no eres admin no te deja acceder
			log.info("No eres admin, no puede acceder aqui");
			return new ModelAndView("redirect:/principal");
		}
	}

}
