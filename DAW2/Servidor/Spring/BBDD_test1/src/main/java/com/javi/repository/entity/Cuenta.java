package com.javi.repository.entity;

import java.util.ArrayList;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="cuentas")
public class Cuenta {
	@Column(name="id")
	private int id;
	@Column(name="banco")
	private String banco;
	@Column(name="sucursal")
	private String sucursal;
	@Column(name="dc")
	private String dc;
	@Column(name="numerocuenta")
	private String numerocuenta;
	@Column(name="saldoactual")
	private float saldo;
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	//private ArrayList<Movimiento> movimientos = new ArrayList<>();


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Cuenta(){
		super();
		this.cliente = new Cliente();
	}

	private void setCuenta(int id, String banco, String sucursal, String dc, String numerocuenta, float saldo, Cliente cliente) {
		this.id = id;
		this.banco = banco;
		this.sucursal = sucursal;
		this.dc = dc;
		this.numerocuenta = numerocuenta;
		this.saldo = saldo;
		this.cliente = cliente;
	}
}
