package com.example.test.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrimerControlador {
	private static final Logger log = LoggerFactory.getLogger(PrimerControlador.class);

	@GetMapping("/holamodel")
	public String holaModel(Model m) {
		String nombreApp = "MiApp";
		String msg = "Hola desde thymeleaf con model";
		m.addAttribute("titulo", nombreApp);
		m.addAttribute("mensaje", msg);
		log.info("Hola desde thymeleaf");
		return "heloview";
	}
}
