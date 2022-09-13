package com.project.projectpet.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClienteMascota {

    @Id
    private int idClienteMascota;
    private String nombreMascota;
    private String correo;
    private String direccion;
    @Column(columnDefinition = "DATE")
    private Date fechaNacimientoMascota;
    private String nombreCliente;
    private byte[] imagenMascota;
    private int telefono;
    private String descripcion;

}