package com.javi.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.javi.entities.Alumno;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AlumnoController {
	private static final Logger log = LoggerFactory.getLogger(AlumnoController.class);
	private ArrayList<Alumno> alumnos = new ArrayList<>();
	@PostConstruct
	private void init() {
		Alumno a1 = new Alumno();
		Alumno a2 = new Alumno();
		Alumno a3 = new Alumno();
		a1.setAlumno("Juan", "AlumnoNum", "Uno", "123");
		a2.setAlumno("Pepe", "AlumnoNum", "Dos", "234");
		a3.setAlumno("Rigoberto", "AlumnoNum", "Tres", "345");
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);

		
	}
	private Alumno findByDNI(String dni) {
		for (Alumno a : alumnos) {
			if(a.getDNI().equals(dni)) {
				return a;
			}
		}
		return null;
	}
	@GetMapping("/")
	public ModelAndView comprobarDNI() {
		ModelAndView mvc = new ModelAndView("comprobarDNI");
		mvc.addObject("alumno", new Alumno());
		return mvc;
	}
	@PostMapping("/muestraDatosAlumno")
	public ModelAndView muestraDatosAlumno(@ModelAttribute Alumno alum) {
		log.info(alum.getDNI());
		ModelAndView mvc = new ModelAndView("muestraDatosAlumno");
		Alumno alumno = findByDNI(alum.getDNI());
		mvc.getModelMap().addAttribute("alumno", alumno);
		return mvc;
	}
	
	
}
