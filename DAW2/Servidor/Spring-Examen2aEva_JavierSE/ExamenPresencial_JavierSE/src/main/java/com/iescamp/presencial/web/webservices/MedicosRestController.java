package com.iescamp.presencial.web.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iescamp.presencial.model.dto.MedicoDTO;
import com.iescamp.presencial.service.MedicoService;

@RestController
@RequestMapping("/ws/medicos")
public class MedicosRestController {

	@Autowired
	MedicoService medicoService;

	@GetMapping("all")
	public ResponseEntity<List<MedicoDTO>> mostrarRest() { // Devuelve todos los medicos como JSON
		return new ResponseEntity<>(medicoService.findAll(), HttpStatus.OK);
	}

	@PostMapping("add")
	public ResponseEntity<String> addRest(@RequestBody MedicoDTO medicoDTO) { // Devuelve el medico creado despues de buscarlo en la bbdd para corroborar que se ha creado
		medicoService.save(medicoDTO);
		medicoDTO = medicoService.findAll().getLast();
		return new ResponseEntity<>("Guardado con exito el medico: " + medicoDTO, HttpStatus.OK);
	}

}
