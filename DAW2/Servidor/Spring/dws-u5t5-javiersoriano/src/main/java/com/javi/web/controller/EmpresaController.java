package com.javi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javi.model.dto.ClientesEmpresaDTO;
import com.javi.model.dto.EmpresaDTO;
import com.javi.repository.entity.ClienteEmpresa;
import com.javi.service.ClienteService;
import com.javi.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaservice; 
	
	@Autowired
	ClienteService cs;
	
	@GetMapping("/clientes/{idCliente}/empresas")
	public ModelAndView showAllByUser(@PathVariable Long idCliente) {
		ModelAndView mvc = new ModelAndView("empresas")
									.addObject("listaEmpresasDTO", empresaservice.findAllByCliente(idCliente))
									.addObject("clienteDTO", cs.findById(idCliente) );
		
		return mvc;
	}
	
	@GetMapping("/clientes/{idCliente}/empresas/{idEmpresa}")
	public ModelAndView show(@PathVariable Long idCliente, @PathVariable Long idEmpresa) {
		ModelAndView mvc = new ModelAndView("empresashow")
									.addObject("empresaDTO", empresaservice.findById(idEmpresa))
									.addObject("idCliente", idCliente );
		
		return mvc;
	}
	@GetMapping("/clientes/{idCliente}/empresas/update")
    public ModelAndView addServicioExistente(@PathVariable Long idCliente,
                    @ModelAttribute EmpresaDTO empresaDTO) {
            
			String p_aux= empresaDTO.getP_aux();
		
			int a_aux= empresaDTO.getA_aux();

            empresaDTO = this.empresaservice.findById(empresaDTO.getId());
            
            empresaDTO.setP_aux(p_aux);
            
            empresaDTO.setA_aux(a_aux);

            this.empresaservice.addExistente(empresaDTO, idCliente);

            return new ModelAndView("redirect:/clientes/" + idCliente + "/empresas");
    }

    @PostMapping("/clientes/{idCliente}/empresas/save")
    public ModelAndView save(@PathVariable Long idCliente, @ModelAttribute EmpresaDTO empresaDTO) {
    		
            if (empresaDTO.getId() != null) {
            	empresaservice.addExistente(empresaDTO, idCliente);
            } else if (empresaservice.findByParams(empresaDTO) != null){
            	empresaservice.addToExistent(empresaDTO, idCliente);
            } else {
            	empresaservice.save(empresaDTO, idCliente);
            }

            return new ModelAndView("redirect:/clientes/" + idCliente + "/empresas");
    }

    @GetMapping("/clientes/{idCliente}/empresas/add")
    public ModelAndView add(@PathVariable Long idCliente) {
            return new ModelAndView("empresaform")
                            .addObject("empresaDTO", new EmpresaDTO())
                            .addObject("clienteDTO", this.cs.findById(idCliente))
                            .addObject("add", true);
    }

    @GetMapping("/clientes/{idCliente}/empresas/update/{id}")
    public ModelAndView update(@PathVariable Long idCliente, @PathVariable Long id) {
    		ClientesEmpresaDTO ceDTO = empresaservice.findbyClienteAndEmpresa(idCliente, id);
    
    		EmpresaDTO eDTO = this.empresaservice.findById(id);
    		eDTO.setA_aux(ceDTO.getAnos_en_empresa());
    		eDTO.setP_aux(ceDTO.getPuesto());
    		String[] data = {ceDTO.getPuesto(), String.valueOf(ceDTO.getAnos_en_empresa())};
            return new ModelAndView("empresaform")
                            .addObject("empresaDTO", eDTO)
                            .addObject("clienteDTO", this.cs.findById(idCliente))
                            .addObject("add", false);
    }
    @GetMapping("/clientes/{idCliente}/empresas/delete/{id}")
    public ModelAndView delete(@PathVariable Long idCliente, @PathVariable Long id) {
    	empresaservice.remove(id, idCliente);
    	return new ModelAndView("redirect:/clientes/"+idCliente+"/empresas");
    }
}
