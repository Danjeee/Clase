package com.javi.model.dto;


import com.javi.repository.entity.ClienteEmpresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientesEmpresaDTO {
	private Long id;
	private String puesto;
	private int anos_en_empresa;
	private EmpresaDTO empresaDTO;
	private ClienteDTO clienteDTO;
	
	public ClientesEmpresaDTO convertToDTO(ClienteEmpresa ce, ClienteDTO cli, EmpresaDTO e) {
		return ClientesEmpresaDTO.builder()
				.id(ce.getId())
				.puesto(ce.getPuesto())
				.anos_en_empresa(ce.getAnos_en_empresa())
				.clienteDTO(cli)
				.empresaDTO(e)
				.build();
		
	}
}
