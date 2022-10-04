package com.project.projectpet.controller.dto;

import lombok.*;
import reactor.util.annotation.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InformacionFormularioDTO {

    @Nullable
    private Integer idClienteMascota;
    private String nombreMascota;
    private String correo;
    private String direccion;
    private Date fechaNacimientoMascota;
    private String nombreCliente;
    @Nullable
    private byte[] imagenMascota;
    private String telefono;
    private String descripcion;
    private String tipoMascota;
}
