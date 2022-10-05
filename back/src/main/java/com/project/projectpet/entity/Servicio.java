package com.project.projectpet.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "servicio")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Servicio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @Column(name = "id_cliente_mascota")
    private Integer idClienteMascota;

    @Column(name = "tipo_servicio")
    private String tipoServicio;

}