package com.javi.model.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
	private String p_aux;
	private int a_aux;
	
	public static EmpresaDTO convertToDTO(Empresa input) {
		return EmpresaDTO.builder().id(input.getId())
									.nombre(input.getNombre())
									.descripcion(input.getDescripcion())
									.build();
	}
	
	/*public static Empresa convertToEntity(EmpresaDTO input, Set<ClienteEmpresa> listaclientesempresa) {
		return Empresa.builder().id(input.getId())
									.nombre(input.getNombre())
									.descripcion(input.getDescripcion())
									.listaclientesempresa(listaclientesempresa)
									.build();
	}*/
	public static Empresa convertToEntity(EmpresaDTO input, List<ClienteEmpresa> listaclientesempresa) {
		return Empresa.builder().id(input.getId())
									.nombre(input.getNombre())
									.descripcion(input.getDescripcion())
									.listaclientesempresa(listaclientesempresa)
									.build();
	}
}
