const HOST_LOCAL = "http://localhost:8080/v1/clientemascota/";
const HOST = "https://petmaster1.herokuapp.com/";

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



    Swal.fire({
        title: 'Está seguro que quiere enviar y confirmar la cita?',
        showDenyButton: true,
        confirmButtonText: 'Continuar',
        denyButtonText: `Cancelar`,
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            fetch(HOST+'crear-cliente-mascota', {
                method: "POST",
                body: JSON.stringify(dataCrearClienteMascota),
                headers: { "Content-type": "application/json", "Access-Control-Allow-Origin": "*"  }
            })
                .then(responseClienteMascota => responseClienteMascota.json())
                .then(jsonClienteMascota => {
                    Swal.showLoading();
                    console.log(jsonClienteMascota.data);
                    consumirServicioCrearServicio(jsonClienteMascota);
                })
                .catch(err3 => {
                    Swal.hideLoading();
                    Swal.fire('Error en el servicio!', '', 'error')});
            
          
        } else if (result.isDenied) {
          Swal.fire('Solicitud cancelada', '', 'info')
        }
      })


}


function consumirServicioCrearServicio(jsonClienteMascota) {
    var crearServicio = {
        "idClienteMascota": jsonClienteMascota.idClienteMascota,
        "tipoServicio": tipoServicio
    };
    fetch(HOST+'crear-servicio', {
        method: "POST",
        body: JSON.stringify(crearServicio),
        headers: { "Content-type": "application/json", "Access-Control-Allow-Origin": "*"  }
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
    fetch(HOST+'agendar-cita', {
        method: "POST",
        body: JSON.stringify(dataAgendarCita),
        headers: { "Content-type": "application/json", "Access-Control-Allow-Origin": "*"  }
    })
        .then(responseAgendarCita => responseAgendarCita.json())
        .then(jsonAgendarCita => {
            console.log(jsonAgendarCita)
            if(jsonAgendarCita.status === 400 && jsonAgendarCita.status === 500 ){
                Swal.hideLoading();
                Swal.fire('Error en el servicio!', '', 'error')
            }else{
                Swal.hideLoading();
                Swal.fire('Solicitud Enviada', '', 'success')
            }
        })
        .catch(err1 => {
            Swal.hideLoading();
            Swal.fire('Error en el servicio!', '', 'error')});
}