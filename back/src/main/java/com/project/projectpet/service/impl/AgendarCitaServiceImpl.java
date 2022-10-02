package com.project.projectpet.service.impl;

import com.project.projectpet.controller.dto.AgendarCitaDTO;
import com.project.projectpet.entity.Agenda;
import com.project.projectpet.repository.AgendaRepository;
import com.project.projectpet.service.AgendarCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AgendarCitaServiceImpl implements AgendarCitaService {
    @Autowired
    private AgendaRepository agendaRepository;


    @Override
    public void save(AgendarCitaDTO agendarCita) {
        Agenda agenda = Agenda.builder()
                .fechaAgenda(agendarCita.getFechaAgenda())
                .idServicio(agendarCita.getIdServicio())
                .idClienteMascota(agendarCita.getIdClienteMascota())
                .build();
        agendaRepository.save(agenda);
    }
}
