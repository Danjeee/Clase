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
	CitaService citaService;
	@Autowired
	PacienteService pacienteService;
	@Autowired
	MedicoService medicoService;

	@GetMapping("")
	public ModelAndView showall(HttpSession http) { //Mostrar todos
		ModelAndView mvc = new ModelAndView("citas");
		if (((MedicoDTO) http.getAttribute("usuario")).isAdministrador()) {
			log.info("Mostramos todas las citas");
			mvc.addObject("listaCitasDTO", citaService.findAll());
		} else {
			log.info("Mostramos todas las citas del medico " + http.getAttribute("usuario"));
			mvc.addObject("listaCitasDTO",
					citaService.findAllByMedico(((MedicoDTO) http.getAttribute("usuario")).getId()));
		}
		return LoginController.checkLogged(http, mvc);
	}

	@GetMapping("/medicos/{idMed}")
	public ModelAndView showByMed(@PathVariable("idMed") Integer idMed, HttpSession http) { //Mostrar por id de medico
		ModelAndView mvc = new ModelAndView("citas");
		if (idMed != ((MedicoDTO) http.getAttribute("usuario")).getId()
				&& !((MedicoDTO) http.getAttribute("usuario")).isAdministrador()) {

			return new ModelAndView("redirect:/citas/medicos/" + ((MedicoDTO) http.getAttribute("usuario")).getId());
		}
		log.info("Mostramos las citas del medico " + medicoService.findById(idMed));
		mvc.addObject("listaCitasDTO", citaService.findAllByMedico(idMed));

		return LoginController.checkLogged(http, mvc);
	}

	@GetMapping("/{idPaciente}")
	public ModelAndView show(@PathVariable("idPaciente") Integer idPaciente, HttpSession http) { // Mostrar por id de paciente
		log.info("Mostramos las citas del paciente: " + pacienteService.findById(idPaciente));
		ModelAndView mvc = new ModelAndView("citas");
		mvc.addObject("listaCitasDTO", citaService.findAllByPaciente(idPaciente));
		return LoginController.checkLogged(http, mvc);
	}

	@GetMapping("add/{idPaciente}")
	public ModelAndView add(@PathVariable("idPaciente") Integer idPaciente, HttpSession http) { // Añadir a paciente
		log.info("Añadimos una nueva cita al paciente: " + pacienteService.findById(idPaciente));
		ModelAndView mvc = new ModelAndView("citaform");
		CitaDTO cita = new CitaDTO();
		cita.setMedicoDTO((MedicoDTO) http.getAttribute("usuario")); // Se añade el médico logeado
		cita.setPacienteDTO(pacienteService.findById(idPaciente));
		mvc.addObject("cita", cita);
		mvc.addObject("editar", false);
		return LoginController.checkLogged(http, mvc);
	}

	@GetMapping("{idCita}/edit")
	public ModelAndView edit(@PathVariable("idCita") Integer idCita, HttpSession http) { // Editar

		ModelAndView mvc = new ModelAndView("citaform");
		CitaDTO cita = citaService.findById(idCita);
		log.info("Editamos la cita: " + cita);
		cita.setMedicoDTO(cita.getMedicoDTO()); // Se añade el médico que previamente tenía la cita
		cita.setPacienteDTO(cita.getPacienteDTO());
		mvc.addObject("cita", cita);
		mvc.addObject("editar", true);
		return LoginController.checkLogged(http, mvc);
	}

	@PostMapping("/save/{idPaciente}")
	public ModelAndView postMethodName(HttpSession http, @ModelAttribute CitaDTO cita,
			@PathVariable("idPaciente") Integer idPaciente) { // Guardar
		cita.setPacienteDTO(pacienteService.findById(idPaciente));
		if (cita.getId() == 0) {
			cita.setMedicoDTO((MedicoDTO) http.getAttribute("usuario")); // Si la cita es nueva (id=0), se le añade como medico el que esté logeado
		} else {
			cita.setMedicoDTO(medicoService.findById(cita.getMedicoDTO().getId())); // Si la cita no es nueva (id!=0), se conserva el medico
		}

		log.info("Guardamos cita: " + cita);
		citaService.save(cita);
		return new ModelAndView("redirect:/pacientes");
	}

	@GetMapping("/{idCita}/delete")
	public ModelAndView getMethodName(@PathVariable("idCita") Integer idCita) { // Borrar cita
		CitaDTO aux = citaService.findById(idCita); // Cargo la cita solo para el log
		log.info("Borramos la cita: " + aux);
		citaService.deleteById(idCita);
		return new ModelAndView("redirect:/citas/" + aux.getPacienteDTO().getId());
	}

}
