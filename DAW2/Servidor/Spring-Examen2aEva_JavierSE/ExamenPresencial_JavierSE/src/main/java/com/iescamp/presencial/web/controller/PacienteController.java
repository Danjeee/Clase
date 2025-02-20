package com.iescamp.presencial.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iescamp.presencial.model.dto.PacienteDTO;
import com.iescamp.presencial.service.PacienteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
	private static final Logger log = LoggerFactory.getLogger(PacienteController.class);

	@Autowired
	PacienteService pacienteService;

	@GetMapping("")
	public ModelAndView pacientes(HttpSession http) { // Muestra todos los pacientes
		log.info("Mostramos todos los pacientes");
		ModelAndView mvc = new ModelAndView("pacientes");
		mvc.addObject("listaPacientesDTO", pacienteService.findAll());
		return LoginController.checkLogged(http, mvc);
	}

	@GetMapping("/add")
	public ModelAndView pacientesadd(HttpSession http) { // Formulario para añadir un nuevo paciente
		log.info("Añadimos un nuevo paciente");
		ModelAndView mvc = new ModelAndView("pacienteform");
		mvc.addObject("paciente", new PacienteDTO());
		mvc.addObject("editar", false);
		return LoginController.checkLogged(http, mvc);
	}

	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute PacienteDTO paciente) { // Metodo para guardar paciente
		pacienteService.save(paciente);
		log.info("Guardamos paciente: " + paciente);
		return new ModelAndView("redirect:/pacientes");
	}

	@GetMapping("/{idPaciente}/edit")
	public ModelAndView edit(HttpSession http, @PathVariable("idPaciente") Integer idPaciente) { // Formulario para editar paciente
		ModelAndView mvc = new ModelAndView("pacienteform");
		mvc.addObject("paciente", pacienteService.findById(idPaciente));
		mvc.addObject("editar", true);
		log.info("Editamos el paciente: " + pacienteService.findById(idPaciente));
		return LoginController.checkLogged(http, mvc);
	}

	@GetMapping("/{idPaciente}/delete")
	public ModelAndView delete(@PathVariable("idPaciente") Integer idPaciente) { // Metodo para borrar paciente
		log.info("Borramos el paciente: " + pacienteService.findById(idPaciente));
		pacienteService.deleteById(idPaciente);
		return new ModelAndView("redirect:/pacientes");
	}

}
