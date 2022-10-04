package com.project.projectpet.service;

import com.project.projectpet.controller.dto.InformacionFormularioDTO;
import com.project.projectpet.entity.ClienteMascota;

import java.util.List;
import java.util.Optional;

// Servicio que maneja la logica de negocio
public interface  ClienteMascotaService {
    InformacionFormularioDTO save(InformacionFormularioDTO dto);
    public List<ClienteMascota> findAll();
    void delete(Integer id);
    ClienteMascota create(ClienteMascota clienteMascota);
    Optional<ClienteMascota> findById(int idClienteMascota);

}
