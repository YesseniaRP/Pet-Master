package com.project.projectpet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Null;

import java.sql.Date;
import java.time.LocalDateTime;

@Table(name = "cliente_mascota")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClienteMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClienteMascota;

    @Column(name = "nombre_mascota")
    private String nombreMascota;

    @Column(name = "correo")
    private String correo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_nacimiento_mascota")
    private Date fechaNacimientoMascota;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "imagen_mascota")
    @Nullable
    private byte[] imagenMascota;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_mascota")
    private String tipoMascota;
}