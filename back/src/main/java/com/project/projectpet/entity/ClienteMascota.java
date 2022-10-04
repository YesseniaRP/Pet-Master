package com.project.projectpet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "cliente_mascota")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClienteMascota {

    @Id
    private int idClienteMascota;
    @Column
    private String nombreMascota;
    @Column
    private String correo;
    @Column
    private String direccion;
    @Column(columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaNacimientoMascota;
    @Column
    private String nombreCliente;
    @Column
    private byte[] imagenMascota;
    @Column
    private int telefono;
    @Column
    private String descripcion;

}