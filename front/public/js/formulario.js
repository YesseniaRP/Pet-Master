function enviarFormulario() {
    var nombreMascota = document.getElementById('nombreMascota').value;
    var correo = document.getElementById('correo').value;
    var direccion = document.getElementById('direccion').value;
    var fechaNacimientoMascota = document.getElementById('fechaNacimientoMascota').value;
    var nombreCliente = document.getElementById('nombreCliente').value;
    var telefono = document.getElementById('telefono').value;
    var tipoMascota = document.getElementById('tipoMascota').value;
    
    var data = {
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
        body: JSON.stringify(data),
        headers: { "Content-type": "application/json; charset=UTF-8" }
    })
        .then(response => response.json())
        .then(json => console.log(json))
        .catch(err => console.log(err));
}