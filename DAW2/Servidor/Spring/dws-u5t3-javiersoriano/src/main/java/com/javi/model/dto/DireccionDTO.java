package com.javi.model.dto;

import java.util.Set;

import com.javi.repository.entity.ClienteDireccion;
import com.javi.repository.entity.Direccion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {

    private Long id;
    private String descripcion;
    private String pais;
    private String cp;

    public static DireccionDTO convertToDTO(Direccion direccion) {
        return new DireccionDTO(direccion.getId(), direccion.getDescripcion(), direccion.getPais(), direccion.getCp());
    }

    public static Direccion convertToEntity(DireccionDTO direccionDTO, Set<ClienteDireccion> listaClienteDirecciones) {
        return new Direccion(direccionDTO.getId(), direccionDTO.getDescripcion(), direccionDTO.getPais(),
                direccionDTO.getCp(), listaClienteDirecciones);
    }
}
