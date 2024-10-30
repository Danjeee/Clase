package com.javi.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javi.model.dto.ClienteDTO;
import com.javi.model.dto.CuentaDTO;
import com.javi.model.dto.RecomendacionDTO;
import com.javi.service.clienteService;
import com.javi.service.clienteServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ClienteController {
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	@Autowired
	private clienteService cs;
	
	@Value("${aplicacion.nombreAlumno}")
	private String nombreAlumno;
	@Value("${aplicacion.nombre}")
	private String aplicacion;
	@Value("${asignatura}")
	private String nombreAsignatura;
	
	@GetMapping("/clientes")
	public ModelAndView findAll() {
	log.info("clientes");	
	ModelAndView mvc = new ModelAndView("clientes");
	List<ClienteDTO> listaclientesDTO = cs.findAll();
	mvc.addObject("lista", listaclientesDTO);
	log.info(listaclientesDTO.toString());
	mvc.addObject("nA", nombreAlumno);
	mvc.addObject("n", aplicacion);
	mvc.addObject("a", nombreAsignatura);
	return mvc;
	}
	
	@GetMapping("/clientes/add")
	public ModelAndView add() {
		ModelAndView mvc = new ModelAndView("clienteform");
		mvc.addObject("clienteDTO", new ClienteDTO());
		mvc.addObject("add", true);
		return mvc;
	}
	@PostMapping("/clientes/save")
	public ModelAndView save(@ModelAttribute("clienteDTO") ClienteDTO cdto) {
		log.info("Salvando " +cdto);
		cdto.getRecomendacionDTO().setClienteDTO(cdto);
		cs.save(cdto);
		ModelAndView mvc = new ModelAndView("redirect:/clientes");
		return mvc;
	}
	
	@GetMapping("/clientes/delete/{idCliente}")
	public ModelAndView delete(@PathVariable("idCliente") int idCliente) {
		log.info("Borrando el cliente " +idCliente);
		ClienteDTO cdto = new ClienteDTO();
		cdto.setId(idCliente);
		RecomendacionDTO r = new RecomendacionDTO();
		r.setClienteDTO(cdto);
		cdto.setRecomendacionDTO(r);
		cs.delete(cdto);
		ModelAndView mvc = new ModelAndView("redirect:/clientes");
		return mvc;
	}
	@GetMapping("/clientes/update/{idCliente}")
	public ModelAndView update(@PathVariable("idCliente") int idCliente) {
		log.info("Actualizando el cliente " +idCliente);
		ClienteDTO cdto = new ClienteDTO();
		cdto.setId(idCliente);
		RecomendacionDTO r = new RecomendacionDTO();
		r.setClienteDTO(cdto);
		cdto.setRecomendacionDTO(r);
		ModelAndView mvc = new ModelAndView("clienteform");
		mvc.addObject("clienteDTO", cs.findById(cdto));
		mvc.addObject("add", false);
		return mvc;
	}
	@GetMapping("/clientes/{idCliente}")
	public ModelAndView view(@PathVariable("idCliente") int idCliente) {
		ClienteDTO cdto = new ClienteDTO();
		cdto.setId(idCliente);
		RecomendacionDTO r = new RecomendacionDTO();
		r.setClienteDTO(cdto);
		cdto.setRecomendacionDTO(r);
		ModelAndView mvc = new ModelAndView("clienteview");
		mvc.addObject("cliente", cs.findById(cdto));
		return mvc;
	}
	@GetMapping("/clientes/{idCliente}/cuentas")
	public ModelAndView verCuentas(@PathVariable("idCliente") int idCliente) {
		ClienteDTO cdto = new ClienteDTO();
		cdto.setId(idCliente);
		RecomendacionDTO r = new RecomendacionDTO();
		r.setClienteDTO(cdto);
		cdto.setRecomendacionDTO(r);
		ModelAndView mvc = new ModelAndView("cuentas");
		mvc.addObject("cliente", cs.findById(cdto));
		return mvc;
	}
	
	@GetMapping("/clientes/{idCliente}/cuentas/add")
	public ModelAndView addCuenta(@PathVariable("idCliente") int idCliente) {
		ClienteDTO cdto = new ClienteDTO();
		cdto.setId(idCliente);
		RecomendacionDTO r = new RecomendacionDTO();
		r.setClienteDTO(cdto);
		cdto.setRecomendacionDTO(r);
		cdto = cs.findById(cdto);
		ModelAndView mvc = new ModelAndView("cuentaform");
		CuentaDTO cu = new CuentaDTO();
		cu.setId(Integer.parseInt("1" + String.valueOf(idCliente) +""+ String.valueOf(cdto.getCuentasDTO().size())));
		mvc.addObject("cuenta", cu);
		log.info(String.valueOf(idCliente) +""+ String.valueOf(cdto.getCuentasDTO().size()));
		mvc.addObject("cliente", cs.findById(cdto));
		mvc.addObject("add", true);
		return mvc;
	}
	@PostMapping("/clientes/{idCliente}/cuentas/save")
	public ModelAndView saveAcc(@ModelAttribute("cuenta") CuentaDTO cdto, @PathVariable("idCliente") int idCliente) {
		ClienteDTO cli = new ClienteDTO();
		cli.setId(idCliente);
		cli.setRecomendacionDTO(new RecomendacionDTO());
		cli = cs.findById(cli);
		if(cli.isANewAcc(cdto)) {
			cdto.setClienteDTO(cli);
			log.info(String.valueOf(cdto.getId()));
			cli.getCuentasDTO().add(cdto);
			
		} else {
			cli.getCuentasDTO().set(cli.getCuentasDTO().indexOf(cdto), cdto);
		}
		cs.save(cli);
		ModelAndView mvc = new ModelAndView("redirect:/clientes/"+idCliente);
		return mvc;
	}
	
	
}
