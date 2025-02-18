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
import com.javi.model.dto.ClienteServicioDTO;
import com.javi.model.dto.ServicioDTO;
import com.javi.service.ClienteService;
import com.javi.service.ServicioService;


@Controller
public class ServicioController {

        private static final Logger log = LoggerFactory.getLogger(ServicioController.class);

        @Autowired
        private ServicioService servicioService;

        @Autowired
        private ClienteService clienteService;

        @GetMapping("/clientes/{idCliente}/servicios")
        public ModelAndView findAllByCliente(@PathVariable Long idCliente) {
                log.info(this.getClass().getSimpleName()
                                + " findAllByCliente: devolver todas las servicios asociadas al cliente con id: {}",
                                idCliente);

                return new ModelAndView("servicios")
                                .addObject("listaServiciosDTO", this.servicioService.findAllByCliente(idCliente))
                                .addObject("clienteDTO", this.clienteService.findById(idCliente));
        }

        @GetMapping("/clientes/{idCliente}/servicios/update")
        public ModelAndView addServicioExistente(@PathVariable Long idCliente,
                        @ModelAttribute ServicioDTO servicioDTO) {
                log.info(this.getClass().getSimpleName()
                                + " addServicioExistente: guardar servicio existente: {} para el cliente con id: {}",
                                servicioDTO, idCliente);
                
                float precio_aux = servicioDTO.getPrecio_aux();

                servicioDTO = this.servicioService.findById(servicioDTO.getId());
                
                servicioDTO.setPrecio_aux(precio_aux);

                this.servicioService.addExistente(servicioDTO, idCliente);

                return new ModelAndView("redirect:/clientes/" + idCliente + "/servicios");
        }

        @GetMapping("/clientes/{idCliente}/servicios/{id}")
        public ModelAndView findById(@PathVariable Long idCliente, @PathVariable Long id) {
                log.info(this.getClass().getSimpleName() + " findById: devolver servicio con id: {}", id);

                return new ModelAndView("serviciosshow")
                                .addObject("servicioDTO", this.servicioService.findById(id))
                                .addObject("clienteDTO", this.clienteService.findById(idCliente));
        }

        @PostMapping("/clientes/{idCliente}/servicios/save")
        public ModelAndView save(@PathVariable Long idCliente, @ModelAttribute ServicioDTO servicioDTO) {
                log.info(this.getClass().getSimpleName() + " save: guardar servicio con datos: {}", servicioDTO);

                if (servicioService.findByParams(servicioDTO) != null) {
                	System.out.println("Test");
                	this.servicioService.addExistente(servicioDTO, idCliente);
                } else {
                	this.servicioService.save(servicioDTO, idCliente);
                }

                return new ModelAndView("redirect:/clientes/" + idCliente + "/servicios");
        }

        @GetMapping("/clientes/{idCliente}/servicios/add")
        public ModelAndView add(@PathVariable Long idCliente) {
                log.info(this.getClass().getSimpleName() + " add: redigir a vista nueva servicio");

                return new ModelAndView("serviciosform")
                                .addObject("servicioDTO", new ServicioDTO())
                                .addObject("clienteDTO", this.clienteService.findById(idCliente))
                                .addObject("add", true);
        }

        @GetMapping("/clientes/{idCliente}/servicios/update/{id}")
        public ModelAndView update(@PathVariable Long idCliente, @PathVariable Long id) {
                log.info(this.getClass().getSimpleName() + " update: redigir a vista actualizar servicio con id: {}",
                                id);

                return new ModelAndView("serviciosform")
                                .addObject("servicioDTO", this.servicioService.findById(id))
                                .addObject("clienteDTO", this.clienteService.findById(idCliente))
                                .addObject("add", false);
        }
        @GetMapping("/clientes/{idCliente}/servicios/delete/{id}")
        public ModelAndView delete(@PathVariable Long idCliente, @PathVariable Long id) {
        	servicioService.remove(id, idCliente);
        	return new ModelAndView("redirect:/clientes/"+idCliente+"/servicios");
        }
}
