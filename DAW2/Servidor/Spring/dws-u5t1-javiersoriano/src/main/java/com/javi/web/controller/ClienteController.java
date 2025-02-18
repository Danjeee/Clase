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

import com.javi.model.dto.ClienteDTO;
import com.javi.service.ClienteService;


@Controller
public class ClienteController {

    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView findAll() {
        log.info(this.getClass().getSimpleName() + " devolvemos todos los clientes");

        return new ModelAndView("clientes").addObject("listaClientesDTO", this.clienteService.findAll());
    }

    @GetMapping("/clientes/{id}")
    public ModelAndView findById(@PathVariable Long id) {
        log.info(this.getClass().getSimpleName() + " devolvemos el cliente con id: " + id);

        return new ModelAndView("clienteview").addObject("clienteDTO", this.clienteService.findById(id));
    }

    @PostMapping("clientes/save")
    public ModelAndView save(@ModelAttribute ClienteDTO clienteDTO) {
        log.info(this.getClass().getSimpleName() + " guardamos el cliente: " + clienteDTO);

        this.clienteService.save(clienteDTO);

        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("clientes/add")
    public ModelAndView add() {
        log.info(this.getClass().getSimpleName() + " redirigimos a nuevo cliente");

        return new ModelAndView("clienteform").addObject("clienteDTO", new ClienteDTO()).addObject("add", true);
    }

    @GetMapping("clientes/update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        log.info(this.getClass().getSimpleName() + " redirigimos actualizar cliente con id: " + id);

        return new ModelAndView("clienteform").addObject("clienteDTO", this.clienteService.findById(id))
                .addObject("add", false);
    }

    @GetMapping("clientes/delete/{id}")
    public ModelAndView deleteById(@PathVariable Long id) {
        log.info(this.getClass().getSimpleName() + " borramos cliente con id: " + id);

        this.clienteService.deleteById(id);

        return new ModelAndView("redirect:/clientes");
    }
}
