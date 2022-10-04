package com.project.projectpet.controller;

import com.project.projectpet.controller.dto.AgendarCitaDTO;
import com.project.projectpet.controller.dto.CrearServicioDTO;
import com.project.projectpet.controller.dto.InformacionFormularioDTO;
import com.project.projectpet.entity.Agenda;
import com.project.projectpet.entity.ClienteMascota;
import com.project.projectpet.service.AgendarCitaService;
import com.project.projectpet.service.ClienteMascotaService;
import com.project.projectpet.service.ServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Component
@RequestMapping("/v1/clientemascota")
@CrossOrigin(origins="*")
public class ClienteMascotaController {

    @Autowired
    private ClienteMascotaService clienteMascotaService;
    @Autowired
    private AgendarCitaService agendarCitaService;
    @Autowired
    private ServicioService servicioService;

    @Operation(summary = "Obtiene todos los datos de la tabla ClienteMascota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontro los datos",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteMascota.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno",
                    content = @Content)})
    @GetMapping("/allClientesMascotas")
    ResponseEntity<List<ClienteMascota>> all() {
        return new ResponseEntity<List<ClienteMascota>>(clienteMascotaService.findAll(), null, HttpStatus.OK);
    }

    @Operation(summary = "Recibe la informacion del formulario de asignacion de citas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asigno la cita",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InformacionFormularioDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno",
                    content = @Content)})
    @PostMapping("/asignarCitas")
    ResponseEntity<InformacionFormularioDTO> asignarCitas(@Valid @RequestBody InformacionFormularioDTO infoFormulario) {

        return new ResponseEntity<InformacionFormularioDTO>(infoFormulario, null, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        clienteMascotaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/Crear")
    public ClienteMascota guardar(@RequestBody @Valid ClienteMascota clienteMascota) {

        return clienteMascotaService.create(clienteMascota);

    }

    @GetMapping(value = "/(id)")
    private ResponseEntity<Optional<ClienteMascota>> listarclientes(@PathVariable("id") long id) {
        return ResponseEntity.ok(clienteMascotaService.findById((int) id));
    }

    @PostMapping(value = "/agendar-cita")
    private ResponseEntity<AgendarCitaDTO> agendarCita(@Valid @RequestBody AgendarCitaDTO data) {
        AgendarCitaDTO result = agendarCitaService.save(data);

        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/crear-cliente-mascota")
    private ResponseEntity<InformacionFormularioDTO> crearClienteMascota(@Valid @RequestBody InformacionFormularioDTO data) {
            InformacionFormularioDTO result = clienteMascotaService.save(data);

        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/crear-servicio")
    private ResponseEntity<CrearServicioDTO> crearServicio(@Valid @RequestBody CrearServicioDTO data) {
        CrearServicioDTO result = servicioService.save(data);

        return ResponseEntity.ok(result);
    }
}
