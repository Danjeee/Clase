package com.iescamp.presencial.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class PrincipalController {
	@GetMapping("/principal")
	public ModelAndView principal(HttpSession http) { // Vista principal

		return LoginController.checkLogged(http,
				new ModelAndView("principal").addObject("usuario", http.getAttribute("usuario")));
	}

}
