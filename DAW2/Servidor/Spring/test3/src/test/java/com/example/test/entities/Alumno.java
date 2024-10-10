package com.example.test.entities;

public class Alumno {
	private String nombre;
	private String edad;
	private String apellidos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Alumno [nombre="+nombre+", apellidos="+apellidos+", edad="+edad+"]";
	}
}