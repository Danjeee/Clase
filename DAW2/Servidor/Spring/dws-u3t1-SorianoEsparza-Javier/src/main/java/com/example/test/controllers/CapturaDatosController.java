package com.example.test.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.test.pojos.*;

@Controller
public class CapturaDatosController {

	private static final Logger log = LoggerFactory.getLogger(CapturaDatosController.class);
	
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mvc = new ModelAndView("formulario1");
		mvc.addObject("alquiler", new Alquiler());
		return mvc;
	}
	@PostMapping("/disfrutaDeLaPelicula")
	public ModelAndView mostrar(@ModelAttribute Alquiler alquiler) {
		ModelAndView mvc = new ModelAndView("formulario2");
		if(alquiler.getExtra() != null && !alquiler.getExtra().equals("")) {
			alquiler.setExtra("Extra: "+alquiler.getExtra()); 
		}
		mvc.getModelMap().addAttribute("alquiler", alquiler);
		return mvc;
	}
}
