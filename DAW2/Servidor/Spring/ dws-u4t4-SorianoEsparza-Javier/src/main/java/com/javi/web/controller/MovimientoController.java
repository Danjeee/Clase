
package com.javi.web.controller;

import java.util.ArrayList;

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
import com.javi.model.dto.MovimientoDTO;
import com.javi.model.dto.RecomendacionDTO;
import com.javi.service.CuentaService;
import com.javi.service.MovimientoService;
import com.javi.service.clienteService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MovimientoController {

	@Autowired
	private MovimientoService ms;
	@Autowired
	private CuentaService cs;
	@Autowired
	private clienteService clis;

	@Value("${aplicacion.nombreAlumno}")
	private String nombreAlumno;
	@Value("${aplicacion.nombre}")
	private String aplicacion;

	@Value("${asignatura}")
	private String nombreAsignatura;
	
	@GetMapping("/clientes/{idCliente}/cuentas/{idCuenta}/movimientos")
	public ModelAndView mostrarMovimientos(@PathVariable("idCliente") int idCliente, @PathVariable("idCuenta") int idCuenta) {
		CuentaDTO cu = new CuentaDTO();
		cu.setId(idCuenta);
		ClienteDTO cli = new ClienteDTO();
		cli.setId(idCliente);
		RecomendacionDTO rm = new RecomendacionDTO();
		cli.setRecomendacionDTO(rm);
		cli = clis.findById(cli);
		cu.setClienteDTO(cli);
		cu = cs.findById(cu);
		ArrayList<MovimientoDTO> mdtos = new ArrayList<>();
		mdtos = ms.findByAccount(cu);
		ModelAndView mvc = new ModelAndView("movimientos");
		mvc.addObject("movimientos", mdtos);
		mvc.addObject("cuenta", cu);
		return mvc;
	}
	@GetMapping("/clientes/{idCliente}/cuentas/{idCuenta}/movimientos/new")
	public ModelAndView nuevoMovimiento(@PathVariable("idCuenta") int idCuenta, @PathVariable("idCliente") int idCliente) {
		ClienteDTO cli = new ClienteDTO();
		cli.setId(idCliente);
		cli.setRecomendacionDTO(new RecomendacionDTO());
		cli = clis.findById(cli);
		CuentaDTO cu = new CuentaDTO();
		cu.setId(idCuenta);
		cu.setClienteDTO(cli);
		cu = cs.findById(cu);
		MovimientoDTO mov = new MovimientoDTO();
		mov.setIdEmisor(idCuenta);
		ModelAndView mvc = new ModelAndView("newmovimiento");
		mvc.addObject("cliente", cli);
		mvc.addObject("cuenta", cu);
		mvc.addObject("movimiento", mov);
		return mvc;
	}
	
	@PostMapping("/clientes/{idCliente}/cuentas/{idCuenta}/movimientos/save")
	public ModelAndView movSave(@ModelAttribute("movimiento") MovimientoDTO mdto, @PathVariable("idCuenta") int idCuenta,  @PathVariable("idCliente") int idCliente) {
		ClienteDTO cli = new ClienteDTO();
		cli.setId(idCliente);
		cli.setRecomendacionDTO(new RecomendacionDTO());
		cli = clis.findById(cli);
		CuentaDTO cu = new CuentaDTO();
		cu.setId(mdto.getIdReceptor());
		cu.setClienteDTO(cli);
		try {
			cs.findById(cu);
		} catch (Exception e) {
			ModelAndView mvc = new ModelAndView("redirect:/clientes/error/404");
			return mvc;
		}
		cu.setId(idCuenta);
		cu = cs.findById(cu);
		if (cu.getSaldo()<mdto.getCant()) {
			ModelAndView mvc = new ModelAndView("redirect:/clientes/error/saldoInsuficiente");
			return mvc;
		}
		ms.save(mdto);
		ModelAndView mvc = new ModelAndView("redirect:/clientes/"+idCliente+"/cuentas/"+idCuenta+"/movimientos");
		return mvc;
	}
	@GetMapping("/clientes/error/saldoInsuficiente")
	public ModelAndView saldoInsuficiente() {
		return new ModelAndView("saldoinsuficiente");
	}
	
}
