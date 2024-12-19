package com.javi.model.dto;

import java.util.ArrayList;
import java.util.Objects;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;

import lombok.Data;
import lombok.ToString;

@Data
public class CuentaDTO {
	private int id;
	private String sucursal;
	private String dc;
	private String numerocuenta;
	private float saldo;
	@ToString.Exclude
	private ClienteDTO clienteDTO;
	private ArrayList<MovimientoDTO> movimientos = new ArrayList<>();
	private String banco;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaDTO other = (CuentaDTO) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setCuenta(int id, String nombre, float saldo) {
		this.id = id;
		this.saldo = saldo;
	}

	private void set(Cuenta c) {
		this.id = c.getId();
		this.banco = c.getBanco();
		this.sucursal = c.getSucursal();
		this.dc = c.getDc();
		this.numerocuenta = c.getNumerocuenta();
		this.saldo = c.getSaldo();
		ClienteDTO caux = new ClienteDTO();
		caux.setId(c.getCliente().getId());
		this.clienteDTO = caux;
		/*for (Movimiento m : c.getMovimientos()) {
			this.movimientos.add(MovimientoDTO.convertToDTO(m));
		}*/
	}

	public static CuentaDTO convertToDTO(Cuenta cuenta) {
		CuentaDTO c = new CuentaDTO();
		c.set(cuenta);
		return c;
	}

	public static Cuenta convertToEntity(CuentaDTO cdto) {
		Cuenta c = new Cuenta();
		c.setId(cdto.getId());
		c.setSaldo(cdto.getSaldo());
		c.setCliente(ClienteDTO.convertToEntity(cdto.getClienteDTO()));
		c.setBanco(cdto.getBanco());
		return c;
	}
	
	public String toString() {
		return this.id+ " " + this.clienteDTO.getNombre();
	}

	public CuentaDTO() {
		
		super();
		this.clienteDTO = new ClienteDTO();
		this.id = -1;
	}
	
}
