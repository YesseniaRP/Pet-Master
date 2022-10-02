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
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ClienteMascotaServiceImpl implements ClienteMascotaService {

    @Autowired
    private ClienteMascotaRepository clienteMascotaRepository;

    @Override
    public List<ClienteMascota> findAll(){
        try{
            return clienteMascotaRepository.findAll();
        } catch (Exception ex){

            throw new ClienteMascotaException("400",ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void delete(Integer id){
        try{
            clienteMascotaRepository.deleteById(id);
        } catch (Exception ex){
            throw new ClienteMascotaException("400",ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ClienteMascota create(ClienteMascota clienteMascota) {
        return clienteMascotaRepository.save(clienteMascota);
        }
    @Override
    public Optional<ClienteMascota> findById(int idClienteMascota) {
        return clienteMascotaRepository.findById(idClienteMascota);
    }



}
