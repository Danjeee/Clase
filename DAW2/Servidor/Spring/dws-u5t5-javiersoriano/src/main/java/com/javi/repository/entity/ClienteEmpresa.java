package com.javi.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clientesempresas")
public class ClienteEmpresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String puesto;
	private int anos_en_empresa;
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
}
