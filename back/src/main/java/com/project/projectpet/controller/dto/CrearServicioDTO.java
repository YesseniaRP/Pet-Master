package com.project.projectpet.controller.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Column;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CrearServicioDTO {

    @Nullable
    private Integer idServicio;
    private Integer idClienteMascota;
    private String tipoServicio;
}
