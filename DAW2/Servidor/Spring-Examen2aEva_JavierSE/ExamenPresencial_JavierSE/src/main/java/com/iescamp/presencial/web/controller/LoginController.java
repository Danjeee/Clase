package com.iescamp.presencial.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.service.MedicoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(EspecialidadController.class);
	@Autowired
	MedicoService medicoService;

	public static ModelAndView checkLogged(HttpSession http, ModelAndView mvc) { // Metodo estatico para comprobar que
																					// estes loggeado, se usa en la
																					// mayoria de vistas
		if (http.getAttribute("usuario") != null) { // Si el usuario no es nulo, es decir, está logeado, devuelve el ModelAndView que se le ha pasado añadiendole el objeto usuario
			mvc.addObject("usuario", http.getAttribute("usuario"));
			return mvc;
		} else {
			return new ModelAndView("redirect:/"); // Si el usuario es nulo, redirecciona a / (login)
		}
	}

	@GetMapping("/")
	public ModelAndView loginform(HttpSession http) { // Formulario de login
		ModelAndView mvc = new ModelAndView("login");
		mvc.addObject("usuario", new MedicoDTO());
		return mvc;
	}

	@PostMapping("/auth/login")
	public ModelAndView login(HttpSession http, @ModelAttribute MedicoDTO usuario) { // Metodo login
		MedicoDTO registro = medicoService.login(usuario);
		if (registro == null) {
			log.info("Inicio de sesion incorrecto");
			return new ModelAndView("redirect:/");
		} else {
			http.setAttribute("usuario", registro);
			log.info("Sesion iniciada correctamente como: " + registro);
			return new ModelAndView("redirect:/principal");
		}
	}

	@PostMapping("/auth/logout")
	public ModelAndView logout(HttpSession http) { // Metodo logout
		log.info("Sesion cerrada");
		http.setAttribute("usuario", null);
		return new ModelAndView("redirect:/");
	}
}
