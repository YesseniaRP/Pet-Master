package com.project.projectpet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.projectpet.controller.dto.CrearServicioDTO;
import com.project.projectpet.entity.Servicio;
import com.project.projectpet.repository.ServicioRepository;
import com.project.projectpet.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    ServicioRepository repository;

    @Override
    public CrearServicioDTO save(CrearServicioDTO servicioDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Servicio servicio = mapper.convertValue(servicioDTO, Servicio.class);
        return mapper.convertValue(repository.save(servicio), CrearServicioDTO.class);
    }
}
