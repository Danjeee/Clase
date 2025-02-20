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
	MedicoService medicoService;
	@Autowired
	EspecialidadService especialidadService;

	@GetMapping("/especialidades/{idEsp}")
	public ModelAndView showPorEspecialidades(@PathVariable("idEsp") Integer idEsp, HttpSession http) { // Muestra todos los medicos segun la especialidad
		if (((MedicoDTO) http.getAttribute("usuario")).isAdministrador()) {
			log.info("Mostramos todos los medicos de la especialidad: " + especialidadService.findById(idEsp));
			ModelAndView mvc = new ModelAndView("medicos");
			mvc.addObject("listaMedicosDTO", medicoService.findByEspecialidad(idEsp));
			return LoginController.checkLogged(http, mvc);
		} else { // Si no eres admin, te redirige a principal
			log.info("Al no ser admin no puedes acceder aqui");
			return new ModelAndView("redirect:/principal");
		}

	}

	@GetMapping("")
	public ModelAndView show(HttpSession http) { // Muestra todos los medicos
		if (((MedicoDTO) http.getAttribute("usuario")).isAdministrador()) {
			log.info("Mostramos todos los medicos");
			ModelAndView mvc = new ModelAndView("medicos");
			mvc.addObject("listaMedicosDTO", medicoService.findAll());
			return LoginController.checkLogged(http, mvc);
		} else { // Si no eres admin, te redirige a principal
			log.info("Al no ser admin no puedes acceder aqui");
			return new ModelAndView("redirect:/principal");
		}

	}

}
