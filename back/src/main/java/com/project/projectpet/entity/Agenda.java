package com.project.projectpet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgenda;
    @Column(name = "id_servicio")
    private int idServicio;
    @Column(name="id_cliente_mascota")
    private int idClienteMascota;
    @Column(name="fecha_agenda")
    private Date fechaAgenda;

}