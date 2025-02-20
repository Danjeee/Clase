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
	MedicoService ms;
	
	public static ModelAndView checkLogged(HttpSession http, ModelAndView mvc) { //Metodo estatico para comprobar que estes loggeado, se usa en la mayoria de vistas
		if (http.getAttribute("usuario") != null) {
			mvc.addObject("usuario",http.getAttribute("usuario"));
			return mvc;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@GetMapping("/")
	public ModelAndView loginform(HttpSession http) {
		ModelAndView mvc = new ModelAndView("login");
		mvc.addObject("usuario", new MedicoDTO());
		return mvc;
	}
	
	@PostMapping("/auth/login")
	public ModelAndView login(HttpSession http, @ModelAttribute MedicoDTO usuario) {
		MedicoDTO registro = ms.login(usuario);
		if (registro == null) {
			 log.info("Inicio de sesion incorrecto");
			 return new ModelAndView("redirect:/");
		} else {
			 http.setAttribute("usuario", registro);
			 log.info("Sesion iniciada correctamente como: "+registro);
			 return new ModelAndView("redirect:/principal");
		}	
	}
	
	@GetMapping("/auth/logout")
	public ModelAndView logout(HttpSession http) {
		log.info("Sesion cerrada");
		http.setAttribute("usuario", null);
		return new ModelAndView("redirect:/");
	}
}
	
