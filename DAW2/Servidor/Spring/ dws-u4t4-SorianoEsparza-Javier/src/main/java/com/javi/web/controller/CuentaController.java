package com.javi.web.controller;

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
import com.javi.service.CuentaService;
import com.javi.service.clienteService;

@Controller
public class CuentaController {
	@Autowired
	private clienteService cs;
	@Autowired
	private CuentaService cus;
	
	@Value("${aplicacion.nombreAlumno}")
	private String nombreAlumno;
	@Value("${aplicacion.nombre}")
	private String aplicacion;
	@Value("${asignatura}")
	private String nombreAsignatura;
	
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
		mvc.addObject("cuenta", cu);
		mvc.addObject("cliente", cs.findById(cdto));
		mvc.addObject("add", true);
		return mvc;
	}
	@PostMapping("/clientes/{idCliente}/cuentas/save")
	public ModelAndView saveAcc(@ModelAttribute("cuenta") CuentaDTO cdto, @PathVariable("idCliente") int idCliente) {
		cus.save(cdto);
		ModelAndView mvc = new ModelAndView("redirect:/clientes/"+idCliente + "/cuentas");
		return mvc;
	}
	@GetMapping("/clientes/{idCliente}/cuentas/update/{idCuenta}")
	public ModelAndView updAcc(@PathVariable("idCuenta") int idCuenta , @PathVariable("idCliente") int idCliente) {
		ClienteDTO cli = new ClienteDTO();
		cli.setId(idCliente);
		cli.setRecomendacionDTO(new RecomendacionDTO());
		cli = cs.findById(cli);
		CuentaDTO c = new CuentaDTO();
		c.setId(idCuenta);
		c = cli.findAccount(c);
		ModelAndView mvc = new ModelAndView("cuentaform");
		mvc.addObject("cuenta", c);
		mvc.addObject("cliente", cs.findById(cli));
		mvc.addObject("add", false);
		return mvc;
	}
	@GetMapping("/clientes/{idCliente}/cuentas/delete/{idCuenta}")
	public ModelAndView deleteAcc(@PathVariable("idCuenta") int idCuenta , @PathVariable("idCliente") int idCliente) {
		CuentaDTO c = new CuentaDTO();
		c.setId(idCuenta);
		cus.delete(c);
		ModelAndView mvc = new ModelAndView("redirect:/clientes/"+idCliente +"/cuentas");
		return mvc;
	}
	@GetMapping("/clientes/{idCliente}/cuentas/{idCuenta}")
	public ModelAndView viewAcc(@PathVariable("idCuenta") int idCuenta , @PathVariable("idCliente") int idCliente) {
		
		ClienteDTO cli = new ClienteDTO();
		cli.setId(idCliente);
		cli.setRecomendacionDTO(new RecomendacionDTO());
		cli = cs.findById(cli);
		CuentaDTO c = new CuentaDTO();
		c.setId(idCuenta);
		c = cus.findById(c);
		ModelAndView mvc = new ModelAndView("cuentaview");
		mvc.addObject("cuenta", c);
		mvc.addObject("cliente", cs.findById(cli));
		return mvc;
	}
}
