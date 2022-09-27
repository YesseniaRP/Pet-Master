package com.project.projectpet.controller;

import com.project.projectpet.controller.dto.InformacionFormularioDTO;
import com.project.projectpet.entity.ClienteMascota;
import com.project.projectpet.service.ClienteMascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/v1/clientemascota")
public class ClienteMascotaController {

    @Autowired
    private ClienteMascotaService clienteMascotaService;

    @Operation(summary = "Obtiene todos los datos de la tabla ClienteMascota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontro los datos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteMascota.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno",
                    content = @Content) })
    @GetMapping("/allClientesMascotas")
    ResponseEntity<List<ClienteMascota>> all() {
        return new ResponseEntity<List<ClienteMascota>>(clienteMascotaService.findAll(),null, HttpStatus.OK);
    }

    @Operation(summary = "Recibe la informacion del formulario de asignacion de citas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asigno la cita",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InformacionFormularioDTO.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno",
                    content = @Content) })
    @PostMapping("/asignarCitas")
    ResponseEntity<InformacionFormularioDTO> asignarCitas(@Valid @RequestBody InformacionFormularioDTO infoFormulario) {

        return new ResponseEntity<InformacionFormularioDTO>(infoFormulario,null, HttpStatus.OK);
    }
}
