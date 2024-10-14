package com.example.test.pojos;

public class Alquiler {

	private String nombre;
	private int dias;
	private String edad;
	private String pago;
	private String extra;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
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
	public Alquiler() {
		super();
		this.extra = "";
	}
}
