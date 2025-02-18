package com.javi.model.dto;

import java.util.Set;

import com.javi.repository.entity.ClienteEmpresa;
import com.javi.repository.entity.Empresa;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
	private Long id;
	private String nombre;
	private String descripcion;
	
	public static EmpresaDTO convertToDTO(Empresa input) {
		return EmpresaDTO.builder().id(input.getId())
									.nombre(input.getNombre())
									.descripcion(input.getDescripcion())
									.build();
	}
	
	public static Empresa convertToEntity(EmpresaDTO input, Set<ClienteEmpresa> listaclientesempresa) {
		return Empresa.builder().id(input.getId())
									.nombre(input.getNombre())
									.descripcion(input.getDescripcion())
									.listaclientesempresa(listaclientesempresa)
									.build();
	}
}
