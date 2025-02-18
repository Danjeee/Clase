package com.javi.model.dto;

import java.util.Set;

import com.javi.repository.entity.ClienteDireccion;
import com.javi.repository.entity.ClienteServicio;
import com.javi.repository.entity.Direccion;
import com.javi.repository.entity.Servicio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Float precio_aux;

    public static ServicioDTO convertToDTO(Servicio servicio) {
        return new ServicioDTO(servicio.getId(), servicio.getNombre(), servicio.getDescripcion(), null);
    }

    public static Servicio convertToEntity(ServicioDTO servicioDTO, Set<ClienteServicio> listaClienteServicio) {
        return new Servicio(servicioDTO.getId(), servicioDTO.getNombre(), servicioDTO.getDescripcion(), listaClienteServicio);
    }
}
