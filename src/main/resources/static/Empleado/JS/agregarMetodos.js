$(document).ready(function(){

    // Agregar BOVINO GENERAL
$("#agregar").on('click', function() {
    let datos = {
        raza: $('#raza').val(),
        genero: $('#genero').val(),
        fecha_nacimiento: $('#fechaNacimiento').val(),
        procedencia: $('#procedencia').val(),
        imagen: $('#imagen').val()
    };

    console.log(datos);
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);

    $.ajax({
        url: "http://localhost:8080/agregarGeneral",
        type: "POST",
        data: datosEnvio,
        contentType: "application/JSON",
        dataType: "text",
        success: function(resultado) {
            try {
                let resultadoJSON = JSON.parse(resultado);
                alert("Resultado de la API: " + resultadoJSON);
            } catch (error) {
                alert("Mensaje satisfactorio: " + resultado);
                window.location.href = "./Seleccionar categoria.html";
            }
        },
        error: function(xhr, status, error) {
            alert("Error al llamar a la API: " + error);
        }
    });
});





    // Agregar USUARIO
        $("#registrar").on('click',function(){
            let datos = {
                id: parseInt($('#id').val()),
                nombre: $('#nombre').val(),
                apellido: $('#apellido').val(),
                telefono: parseInt($('#telefono').val()),
                correo: $('#correo').val(),
                contrasena: $('#contraseña').val(),
                rol: $('#rol').val(),
                area: $('#area').val(),
                imagen: $('#seleccionar__imagen').val(),
            }

            console.log(datos);
            let datosEnvio = JSON.stringify(datos);
            console.log(datosEnvio);

            $.ajax({
                url: "http://localhost:8080/agregarUsuario",
                type: "POST",
                data: datosEnvio,
                contentType: "application/JSON",
                dataType: "JSON",
               success: function(xhr) {
                  alert("El usuario se agregó exitosamente." + xhr.responseText); // Muestra un mensaje de éxito
               },
               error: function(response) {
                  alert("Error al agregar el usuario: "); // Muestra un mensaje de error con el detalle del error
               }
           });
        });


        $.ajax({
            url: 'http://localhost:8080/ultimoIdGeneral',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                $('#id').val(data.id);
            },
            error: function(error) {
                console.error(error);
            }
        });

});
