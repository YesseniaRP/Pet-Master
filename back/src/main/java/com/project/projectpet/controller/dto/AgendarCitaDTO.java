package com.project.projectpet.controller.dto;

import lombok.*;


import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AgendarCitaDTO implements Serializable {
    @Null
    Integer idAgenda;
    Integer idServicio;
    Integer idClienteMascota;
    Date fechaAgenda;
}
