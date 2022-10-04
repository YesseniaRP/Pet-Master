package com.project.projectpet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.projectpet.controller.dto.AgendarCitaDTO;
import com.project.projectpet.entity.Agenda;
import com.project.projectpet.repository.AgendaRepository;
import com.project.projectpet.service.AgendarCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

@Service
public class AgendarCitaServiceImpl implements AgendarCitaService {
    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public AgendarCitaDTO save(AgendarCitaDTO agendarCita) {
        ObjectMapper mapper = new ObjectMapper();
        Agenda agenda = mapper.convertValue(agendarCita, Agenda.class);
        return mapper.convertValue(agendaRepository.save(agenda), AgendarCitaDTO.class);
    }
}
