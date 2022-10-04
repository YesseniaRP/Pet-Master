package com.project.projectpet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name= "agenda")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "agenda")
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