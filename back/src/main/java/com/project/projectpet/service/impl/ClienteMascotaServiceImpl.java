package com.project.projectpet.service.impl;

import com.project.projectpet.entity.ClienteMascota;
import com.project.projectpet.exceptions.ClienteMascotaException;
import com.project.projectpet.repository.ClienteMascotaRepository;
import com.project.projectpet.service.ClienteMascotaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ClienteMascotaServiceImpl implements ClienteMascotaService {

    @Autowired
    private ClienteMascotaRepository clienteMascotaRepository;

    @Autowired
    public List<ClienteMascota> findAll(){
        try{
            return clienteMascotaRepository.findAll();
        } catch (Exception ex){

            throw new ClienteMascotaException("400",ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
