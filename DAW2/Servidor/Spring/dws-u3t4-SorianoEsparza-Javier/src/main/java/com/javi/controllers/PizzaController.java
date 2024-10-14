package com.javi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javi.entities.Pedido;



@Controller
public class PizzaController {
	private static final Logger log = LoggerFactory.getLogger(PizzaController.class);
	@GetMapping("/pedidopizza")
	public ModelAndView pedidopizza() {
		ModelAndView mvc = new ModelAndView("pedidopizza");
		mvc.addObject("pedido", new Pedido());
		return mvc;
	}
	@PostMapping("/pedidofinalizado")
	public ModelAndView pedidofinalizado(@ModelAttribute Pedido pedido) {
		ModelAndView mvc = new ModelAndView("pedidofinalizado");
		mvc.getModelMap().addAttribute("pedido", pedido);
		log.info(pedido.toString());
		return mvc;
	}
	
	
}
