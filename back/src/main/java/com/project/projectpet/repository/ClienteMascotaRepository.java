package com.project.projectpet.repository;

import com.project.projectpet.entity.ClienteMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteMascotaRepository extends JpaRepository<ClienteMascota, Integer> {

}
