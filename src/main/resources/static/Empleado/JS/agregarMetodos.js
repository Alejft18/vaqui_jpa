$(document).ready(function(){

    // Agregar BOVINO GENERAL
  $("#agregar").on('click',function(){
      let datos = {
          raza: $('#raza').val(),
          genero: $('#genero').val(),
          fecha_nacimiento: $('#fechaNacimiento').val(),
          procedencia: $('#procedencia').val(),
          imagen: $('#imagen').val()
      }

      console.log(datos);
      let datosEnvio = JSON.stringify(datos);
      console.log(datosEnvio);

      $.ajax({
          url: "http://localhost:8080/agregarGeneral",
          type: "POST",
          data: datosEnvio,
          contentType: "application/JSON",
          dataType: "JSON",
        success: function(response) {
            alert("El elemento se agregó exitosamente."); // Muestra un mensaje de éxito
            window.location.href = "./Seleccionar categoria.html"; // Redirecciona al nuevo HTML
        },
        error: function(xhr, status, error) {
            alert("Error al agregar el elemento: " + xhr.responseText); // Muestra un mensaje de error con el detalle del error
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
                imagen: $('#seleccionar__imagen').val()
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
               success: function(response) {
                  alert("El usuario se agregó exitosamente."); // Muestra un mensaje de éxito
               },
               error: function(xhr, status, error) {
                  alert("Error al agregar el usuario: " + xhr.responseText); // Muestra un mensaje de error con el detalle del error
               }
           });
        });
});
