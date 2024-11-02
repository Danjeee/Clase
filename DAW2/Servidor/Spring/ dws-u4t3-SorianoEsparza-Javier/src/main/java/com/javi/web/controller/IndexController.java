package com.javi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@Value("${aplicacion.nombreAlumno}")
	private String nombreAlumno;
	@Value("${aplicacion.nombre}")
	private String aplicacion;
	@Value("${asignatura}")
	private String nombreAsignatura;

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@GetMapping("/")
	public ModelAndView index() {
		log.info("Hola");
		ModelAndView mvc = new ModelAndView("index");
		mvc.addObject("nA", nombreAlumno);
		mvc.addObject("n", aplicacion);
		mvc.addObject("a", nombreAsignatura);
		return mvc;
	}

}
