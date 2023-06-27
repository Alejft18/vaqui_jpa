$(document).ready(function(){
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
});
