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

import com.iescamp.presencial.model.dto.CitaDTO;
import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.service.CitaService;
import com.iescamp.presencial.service.MedicoService;
import com.iescamp.presencial.service.PacienteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/citas")
public class CitaController {
	private static final Logger log = LoggerFactory.getLogger(CitaController.class);
	@Autowired
	CitaService cs;
	@Autowired
	PacienteService ps;
	@Autowired
	MedicoService ms;
	
	@GetMapping("")
	public ModelAndView showall(HttpSession http) {
		ModelAndView mvc = new ModelAndView("citas");
		if (((MedicoDTO)http.getAttribute("usuario")).isAdministrador()) {
			log.info("Mostramos todas las citas");
			mvc.addObject("listaCitasDTO", cs.findAll());
		} else {
			log.info("Mostramos todas las citas del medico "+http.getAttribute("usuario"));
			mvc.addObject("listaCitasDTO", cs.findAllByMedico(((MedicoDTO)http.getAttribute("usuario")).getId()));
		}
		return LoginController.checkLogged(http, mvc);
	}
	
	@GetMapping("/medicos/{idMed}")
	public ModelAndView showByMed(@PathVariable("idMed")Integer idMed,HttpSession http) {
		ModelAndView mvc = new ModelAndView("citas");
		if (idMed != ((MedicoDTO)http.getAttribute("usuario")).getId() && !((MedicoDTO)http.getAttribute("usuario")).isAdministrador()){
			
			return new ModelAndView("redirect:/citas/medicos/"+((MedicoDTO)http.getAttribute("usuario")).getId());
		}
		log.info("Mostramos las citas del medico "+ms.findById(idMed));
			mvc.addObject("listaCitasDTO", cs.findAllByMedico(idMed));

		return LoginController.checkLogged(http, mvc);
	}
	
	@GetMapping("/{idPaciente}")
	public ModelAndView show(@PathVariable("idPaciente") Integer idPaciente, HttpSession http) {
		log.info("Mostramos las citas del paciente: "+ps.findById(idPaciente));
		ModelAndView mvc = new ModelAndView("citas");
		mvc.addObject("listaCitasDTO", cs.findAllByPaciente(idPaciente));
		return LoginController.checkLogged(http, mvc);
	}
	
	@GetMapping("add/{idPaciente}")
	public ModelAndView add(@PathVariable("idPaciente") Integer idPaciente, HttpSession http) {
		log.info("Añadimos una nueva cita al paciente: "+ps.findById(idPaciente));
		ModelAndView mvc = new ModelAndView("citaform");
		CitaDTO cita = new CitaDTO();
		cita.setMedicoDTO((MedicoDTO)http.getAttribute("usuario"));
		cita.setPacienteDTO(ps.findById(idPaciente));
		mvc.addObject("cita", cita);
		mvc.addObject("editar", false);
		return LoginController.checkLogged(http, mvc);
	}
	
	@GetMapping("{idCita}/edit")
	public ModelAndView edit(@PathVariable("idCita") Integer idCita, HttpSession http) {
		
		ModelAndView mvc = new ModelAndView("citaform");
		CitaDTO cita = cs.findById(idCita);
		log.info("Editamos la cita: "+cita);
		cita.setMedicoDTO(cita.getMedicoDTO());
		cita.setPacienteDTO(cita.getPacienteDTO());
		mvc.addObject("cita", cita);
		mvc.addObject("editar", true);
		return LoginController.checkLogged(http, mvc);
	}
	
	@PostMapping("/save/{idPaciente}")
	public ModelAndView postMethodName(HttpSession http, @ModelAttribute CitaDTO cita, @PathVariable("idPaciente") Integer idPaciente) {
		cita.setPacienteDTO(ps.findById(idPaciente));
		if (cita.getId() == 0) {
			cita.setMedicoDTO((MedicoDTO)http.getAttribute("usuario"));
		} else {
			cita.setMedicoDTO(ms.findById(cita.getMedicoDTO().getId()));
		}
		
		log.info("Guardamos cita: "+cita);
		cs.save(cita);
		return new ModelAndView("redirect:/pacientes");
	}
	@GetMapping("/{idCita}/delete")
	public ModelAndView getMethodName(@PathVariable("idCita") Integer idCita) {
		CitaDTO aux = cs.findById(idCita);
		log.info("Borramos la cita: "+aux);
		cs.deleteById(idCita);
		return new ModelAndView("redirect:/citas/"+aux.getPacienteDTO().getId());
	}
	
	
	
}
