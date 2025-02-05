package com.javi.model.dto;

import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Recomendacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecomendacionDTO {

    private Long id;

    private String observaciones;

    public static RecomendacionDTO convertToDTO(Recomendacion recomendacion) {
        return new RecomendacionDTO(recomendacion.getId(), recomendacion.getObservaciones());
    }

    public static Recomendacion convertToEntity(RecomendacionDTO recomendacionDTO, Cliente cliente) {
        return new Recomendacion(recomendacionDTO.getId(), recomendacionDTO.getObservaciones(), cliente);
    }
}
