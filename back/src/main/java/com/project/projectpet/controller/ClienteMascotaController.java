package com.project.projectpet.controller;

import com.project.projectpet.entity.ClienteMascota;
import com.project.projectpet.repository.ClienteMascotaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "ClienteMascota", description = "Servicios para cliente mascota API")
@RestController
public class ClienteMascotaController {

    @Autowired
    private ClienteMascotaRepository clienteMascotaRepository;

    @Operation(summary = "Obtiene la lista de todos los clientes en base de datos", description = "Retorna un json con todos los clientes mascotas", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ClienteMascota.class))),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    @GetMapping("/allClientesMascotas")
    List<ClienteMascota> all() {
        return clienteMascotaRepository.findAll();
    }
}
