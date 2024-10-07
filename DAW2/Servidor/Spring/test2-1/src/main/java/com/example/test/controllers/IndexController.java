package com.example.test.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
		@GetMapping("/")
		@ResponseBody
		public String helloworld() {
			return "Hello world!";
		}
		@GetMapping("/bye")
		@ResponseBody
		public String adiosmundo() {
			return "Bye cruel world!";
		}
		//@GetMapping("/holaconparametro")
		@RequestMapping(method = RequestMethod.GET, value = "/holaconparametro")
		@ResponseBody
		public String holaconparametro(@RequestParam(required = false) String name) {
			if (name == null) {
				log.info("No tiene parametro");
				return "Holis sin nombre";
			} else {
				log.info("Tiene parametro: "+name);
				return "Holis "+name+ " c:";
				
			}
		}
		@PostMapping("/holaconmultiplesparametros")
		@ResponseBody
		public String holaconmultiplesparametros(@RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "0") int edad) {
			return "El nombre es "+name +" y la edad es "+edad;
		}
		
		@PostMapping("/holainf")
		@ResponseBody
		public String holaconinfinitosparametros(@RequestParam(required = false) String[] params) {
			String msg = "";
			int i = 0;
			if (params == null) {
				msg = "El array esta vacio";
			} else {
				for (String e : params) {
					msg += "Parametro ["+i+"] "+e+"\n";
					i++;
				}
			}
			return msg;
		}
		
	}

