package com.project.projectpet.controller.dto;

import lombok.*;


import javax.validation.constraints.Null;
import java.io.Serializable;
import java.sql.Date;


@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AgendarCitaDTO implements Serializable {

    Integer idServicio;
    Integer idClienteMascota;
    Date fechaAgenda;
}
