package com.iescamp.presencial.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="medicos")
public class Medico {
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Id
	private int id;
	private String nombre;
	private String apellidos;
	private String matricula;
	private String telefono;
	private String contrasenya;
	private boolean administrador;
	
	@ManyToOne
	@JoinColumn(name= "idespecialidad")
	private Especialidad especialidad;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medico")
    @ToString.Exclude
	private List<Cita> citas;
}
