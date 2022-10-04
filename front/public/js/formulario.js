function enviarFormulario() {
    var nombreMascota = document.getElementById('nombreMascota').value;
    var correo = document.getElementById('correo').value;
    var direccion = document.getElementById('direccion').value;
    var fechaNacimientoMascota = document.getElementById('fechaNacimientoMascota').value;
    var nombreCliente = document.getElementById('nombreCliente').value;
    var telefono = document.getElementById('telefono').value;
    var tipoMascota = document.getElementById('tipoMascota').value;

    var tipoServicio = document.getElementById('tipoServicio').value;

    var fechaAgenda = document.getElementById('fechaAgenda').value;
    var horaAgenda = document.getElementById('horaAgenda').value;
    var fechaConHora = fechaAgenda + "T" + horaAgenda;

    var dataCrearClienteMascota = {
        nombreMascota: nombreMascota,
        correo: correo,
        direccion: direccion,
        fechaNacimientoMascota: fechaNacimientoMascota,
        nombreCliente: nombreCliente,
        telefono: telefono,
        tipoMascota: tipoMascota
    };

    fetch('http://localhost:8080/v1/clientemascota/crear-cliente-mascota', {
        method: "POST",
        body: JSON.stringify(dataCrearClienteMascota),
        headers: { "Content-type": "application/json; charset=UTF-8" }
    })
        .then(responseClienteMascota => responseClienteMascota.json())
        .then(jsonClienteMascota => {
            //
            var crearServicio = {
                "idClienteMascota": jsonClienteMascota.idClienteMascota,
                "tipoServicio": tipoServicio
            };
            fetch('http://localhost:8080/v1/clientemascota/crear-servicio', {
                method: "POST",
                body: JSON.stringify(crearServicio),
                headers: { "Content-type": "application/json; charset=UTF-8" }
            })
                .then(responseServicio => responseServicio.json())
                .then(jsonServicio => {
                    ///
                    var dataAgendarCita = {
                        "idServicio": jsonServicio.idServicio,
                        "idClienteMascota": jsonServicio.idClienteMascota,
                        "fechaAgenda": fechaConHora
                    };
                    fetch('http://localhost:8080/v1/clientemascota/agendar-cita', {
                        method: "POST",
                        body: JSON.stringify(dataAgendarCita),
                        headers: { "Content-type": "application/json; charset=UTF-8" }
                    })
                        .then(responseAgendarCita => responseAgendarCita.json())
                        .then(jsonAgendarCita => {
                            console.log(jsonAgendarCita)
                        })
                        .catch(err1 => console.log(err1));
                    ///
                    console.log(jsonServicio)
                })
                .catch(err2 => console.log(err2));
            //
        })
        .catch(err3 => console.log(err3));
}