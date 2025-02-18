package com.javi.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.javi.repository.entity.ClienteServicio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteServicioDTO {

    private Long id;
    private ClienteDTO clienteDTO;
    private ServicioDTO ServicioDTO;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date fechaAlta;
    private float precio;

    public static ClienteServicioDTO convertToDTO(ClienteServicio clienteServicio, ClienteDTO clienteDTO,
            ServicioDTO ServicioDTO) {
        return ClienteServicioDTO.builder()
                .id(clienteServicio.getId())
                .clienteDTO(clienteDTO)
                .ServicioDTO(ServicioDTO)
                .fechaAlta(clienteServicio.getFechaAlta())
                .precio(clienteServicio.getPrecio())
                .build();
    }

}