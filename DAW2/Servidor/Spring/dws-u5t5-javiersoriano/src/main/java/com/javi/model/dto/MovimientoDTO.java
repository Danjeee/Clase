package com.javi.model.dto;

import java.util.Date;

import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Movimiento;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movimientos")
public class MovimientoDTO {

    private Long id;
    private String tipo;
    private Date fechaOperacion;
    private String descripcion;
    private Float importe;

    public static MovimientoDTO convertToDTO(Movimiento movimiento) {
        return new MovimientoDTO(movimiento.getId(), movimiento.getTipo(), movimiento.getFechaOperacion(),
                movimiento.getDescripcion(), movimiento.getImporte());
    }

    public static Movimiento convertToEntity(MovimientoDTO movimientoDTO, Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        return new Movimiento(movimientoDTO.getId(), movimientoDTO.getTipo(), movimientoDTO.getFechaOperacion(),
                movimientoDTO.getDescripcion(), movimientoDTO.getImporte(), cuentaOrigen, cuentaDestino);
    }
}
