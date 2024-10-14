package com.javi.entities;

import java.util.ArrayList;

public class Pedido {
	private String nombre;
	private String direccion;
	private ArrayList<String> ingredientes;
	private String tam;
	private String pago;
	private String extra;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getTam() {
		return tam;
	}
	public void setTam(String tam) {
		this.tam = tam;
	}
	public String getPago() {
		return pago;
	}
	public void setPago(String pago) {
		this.pago = pago;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public void addIngredient(String a) {
		this.ingredientes.add(a);
	}
	@Override
	public String toString() {
		return nombre + direccion + ingredientes + pago + tam;
	}
	public Pedido() {
		super();
		this.extra = "";
	}
}
