package com.project.projectpet.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "servicio")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Servicio {


    @Id
    private int idServicio;
    private int idClienteMascota;
    private String tipoServicio;

}