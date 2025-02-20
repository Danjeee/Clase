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
@RequestMapping("/medicos")
public class MedicosRestController {
	
	@Autowired
	MedicoService ms;

	@GetMapping("all")
	public ResponseEntity<List<MedicoDTO>> mostrarRest() {
		return new ResponseEntity<>(ms.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addRest(@RequestBody MedicoDTO medicoDTO) {
		ms.save(medicoDTO);
		return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
	}
	
}
