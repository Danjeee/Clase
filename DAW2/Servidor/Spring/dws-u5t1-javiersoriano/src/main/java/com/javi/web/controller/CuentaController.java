package com.javi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javi.model.dto.CuentaDTO;
import com.javi.service.ClienteService;
import com.javi.service.CuentaService;


@Controller
public class CuentaController {

    private static final Logger log = LoggerFactory.getLogger(CuentaController.class);

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/{idCliente}/cuentas")
    public ModelAndView findAllByCliente(@PathVariable Long idCliente) {
        log.info(this.getClass().getSimpleName()
                + " devolvemos todas las cuentas del cliente con id: " + idCliente);

        return new ModelAndView("cuentas").addObject("listaCuentasDTO", this.cuentaService.findAllByCliente(idCliente))
                .addObject("clienteDTO", this.clienteService.findById(idCliente));
    }

    @GetMapping("/clientes/{idCliente}/cuentas/{id}")
    public ModelAndView findById(@PathVariable Long idCliente, @PathVariable Long id) {
        log.info(this.getClass().getSimpleName()
                + " devolvemos la cuenta con id: "+id+"; asociada al cliente con id: " + idCliente);

        return new ModelAndView("cuentaview").addObject("cuentaDTO", this.cuentaService.findById(id))
                .addObject("clienteDTO", this.clienteService.findById(idCliente));
    }

    @PostMapping("/clientes/{idCliente}/cuentas/save")
    public ModelAndView save(@PathVariable Long idCliente, @ModelAttribute CuentaDTO cuentaDTO) {
        log.info(
                this.getClass().getSimpleName() + " cuenta con datos: "+ cuentaDTO +"; asociada al cliente con id: "+ idCliente);

        this.cuentaService.save(cuentaDTO, idCliente);

        return new ModelAndView("redirect:/clientes/" + idCliente + "/cuentas");
    }

    @GetMapping("/clientes/{idCliente}/cuentas/add")
    public ModelAndView add(@PathVariable Long idCliente) {
        log.info(this.getClass().getSimpleName() + " redirigimos a nueva cuenta para cliente con id: " + idCliente);

        return new ModelAndView("cuentaform").addObject("cuentaDTO", new CuentaDTO()).addObject("clienteDTO",
                this.clienteService.findById(idCliente)).addObject("add", true);
    }

    @GetMapping("/clientes/{idCliente}/cuentas/update/{id}")
    public ModelAndView update(@PathVariable Long idCliente, @PathVariable Long id) {
        log.info(this.getClass().getSimpleName()
                + " actualizamos cuenta con id: "+ id +"; del cliente con id: " + idCliente);

        return new ModelAndView("cuentaform").addObject("cuentaDTO", this.cuentaService.findById(id))
                .addObject("clienteDTO",
                        this.clienteService.findById(idCliente))
                .addObject("add", false);
    }

    @GetMapping("/clientes/{idCliente}/cuentas/delete/{id}")
    public ModelAndView deleteById(@PathVariable Long idCliente, @PathVariable Long id) {
        log.info(this.getClass().getSimpleName()
                + " borramos cuenta con id: "+id+"; asociada al cliente con id: "+ idCliente);

        this.cuentaService.deleteById(id);

        return new ModelAndView("redirect:/clientes/" + idCliente + "/cuentas");
    }
}
