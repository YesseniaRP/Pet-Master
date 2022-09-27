package com.project.projectpet.service;

import com.project.projectpet.entity.ClienteMascota;

import java.util.List;

// Servicio que maneja la logica de negocio
public interface  ClienteMascotaService {
    public List<ClienteMascota> findAll();
}
