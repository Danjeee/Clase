package com.javi.model.dto;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Cuenta;
import com.javi.repository.entity.Recomendacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    private String nif;

    private String nombre;

    private String apellidos;

    private String claveSeguridad;

    private String email;

    @DateTimeFormat(iso = ISO.DATE)
    private Date fechaNacimiento;

    private RecomendacionDTO recomendacionDTO;

    public static ClienteDTO convertToDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNif(), cliente.getNombre(), cliente.getApellidos(),
                cliente.getClaveSeguridad(), cliente.getEmail(), cliente.getFechaNacimiento(),
                RecomendacionDTO.convertToDTO(cliente.getRecomendacion()));
    }

    public static Cliente convertToEntity(ClienteDTO clienteDTO, Set<Cuenta> cuentas) {
        Cliente cliente = new Cliente(clienteDTO.getId(), clienteDTO.getNif(), clienteDTO.getNombre(),
                clienteDTO.getApellidos(), clienteDTO.getClaveSeguridad(), clienteDTO.getEmail(),
                clienteDTO.getFechaNacimiento(), null, null, null );

        Recomendacion recomendacion = RecomendacionDTO.convertToEntity(clienteDTO.getRecomendacionDTO(), cliente);
        cliente.setRecomendacion(recomendacion);

        cliente.setCuentas(cuentas);

        return cliente;
    }
}
