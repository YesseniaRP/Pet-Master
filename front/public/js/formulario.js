var nombreMascota;
var correo;
var direccion;
var fechaNacimientoMascota;
var nombreCliente;
var telefono;
var tipoMascota;

var tipoServicio;

var fechaAgenda;
var horaAgenda;
var fechaConHora;

function enviarFormulario() {

    nombreMascota = document.getElementById('nombreMascota').value;
    correo = document.getElementById('correo').value;
    direccion = document.getElementById('direccion').value;
    fechaNacimientoMascota = document.getElementById('fechaNacimientoMascota').value;
    nombreCliente = document.getElementById('nombreCliente').value;
    telefono = document.getElementById('telefono').value;
    tipoMascota = document.getElementById('tipoMascota').value;

    tipoServicio = document.getElementById('tipoServicio').value;

    fechaAgenda = document.getElementById('fechaAgenda').value;
    horaAgenda = document.getElementById('horaAgenda').value;
    fechaConHora = fechaAgenda + "T" + horaAgenda;

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
            consumirServicioCrearServicio(jsonClienteMascota)
        })
        .catch(err3 => console.log(err3));
}

function consumirServicioCrearServicio(jsonClienteMascota) {
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
            consumirServicioAgenda(jsonServicio);
        })
        .catch(err2 => console.log(err2));
}

function consumirServicioAgenda(jsonServicio) {
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
}