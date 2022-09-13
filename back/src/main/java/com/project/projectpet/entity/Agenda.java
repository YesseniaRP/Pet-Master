package com.project.projectpet.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Agenda {

    @Id
    private int idAgenda;
    private int idServicio;
    private int idClienteMascota;
    @Column(columnDefinition = "DATE")
    private Date fechaAgenda;

}