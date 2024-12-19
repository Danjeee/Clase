package com.javi.repository.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="direcciones")
public class Direccion {

		@Id
		private int id;
		@Column
		private String desc;
		@Column
		private String pais;
		@Column
		private String cp;
		@ToString.Exclude
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "direcciones")
		private List<Cliente> listaclientes;
		
	
}
