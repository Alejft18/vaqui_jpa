$(document).ready(function(){
    $("#registrar").on('click',function() {
        let datos = {
            id: parseInt($('#id').val()),
            nombre: $('#nombre').val(),
            apellido: $('#apellido').val(),
            telefono: parseInt($('#telefono').val(),
            rol: $('#rol').val()
            // imagen: $('#seleccionar__imagen').val(),
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

          // Función para crear las filas de datos
    function crearFilas(datos) {
        let tbody = $('#tabla tbody');
        tbody.empty();

        for (let i = 0; i < datos.length; i++) {
        let fila = $('<tr>');
        fila.html('<td>' + datos[i].id + '</td>' +
                    '<td>' + datos[i].nombre + '</td>' +
                    '<td>' + datos[i].apellido + '</td>' +
                    '<td>' + datos[i].telefono + '</td>' +
                    '<td>' + datos[i].correo + '</td>' +
                    '<td>' + datos[i].contrasena + '</td>' +
                    '<td>' + datos[i].rol + '</td>' +
                    '<td>' + datos[i].area + '</td>');
        tbody.append(fila);
        }
    }

    // Realizar la petición AJAX para obtener todos los datos
    function obtenerDatos() {
        $.ajax({
        url: "http://localhost:8080/listarUsuario",
        type: "GET",
        dataType: "JSON",
        success: function(respuesta) {
            console.log(respuesta);
            crearFilas(respuesta); // Llamar a la función para crear las filas de datos
        }
        });
    }

  // Obtener todos los datos al cargar la página
  obtenerDatos();

        // Función para buscar por ID
        function buscarPorId() {
            let input = $('#search-input');
            let id = input.val().trim(); // Obtener el valor del input y eliminar espacios en blanco
        
            if (id === '') {
              alert('Por favor, ingrese un ID válido.'); // Validar si se ingresó un valor
              return;
            }
        
            let fila = $('#tabla tbody').find('tr').filter(function() {
              return $(this).find('td:first').text() === id; // Filtrar las filas que coinciden con el ID buscado
            });
        
            if (fila.length === 0) {
              alert('No se encontró ninguna fila con el ID proporcionado.'); // Validar si no se encontró ninguna fila
              return;
            }
        
            $('#tabla tbody tr').removeClass('highlight'); // Remover la clase 'highlight' de todas las filas
            $('html, body').animate({ scrollTop: fila.offset().top }, 500); // Hacer scroll hacia la fila encontrada
            fila.addClass('highlight'); // Agregar la clase 'highlight' a la fila encontrada
          }
        
          // Manejar el evento click del botón de búsqueda
          $('#search-button').click(function() {
            buscarPorId();
          });
        
          // Manejar el evento keyup del input de búsqueda
          $('#search-input').keyup(function(event) {
            if (event.keyCode === 13) {
              buscarPorId();
            }
          });

});


