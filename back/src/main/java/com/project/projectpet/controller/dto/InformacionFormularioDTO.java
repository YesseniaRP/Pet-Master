package com.project.projectpet.controller.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InformacionFormularioDTO {

    @NotNull
    @Size(min = 2, max = 15)
    private String nombrePersona;
    private String emailPersona;
    private String telefonoPersona;
    private String nombreMascota;
    private String tipoMAscota;
    private String tipoServicio;
    private String fechaServicio;
    private String hora;
    private String mensaje;
}
