$(document).ready(function(){
  
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
                    '<td>' + datos[i].area + '</td>' +
                    '<td><button class="btn-actualizar" data-id="' + datos[i].id + '">Actualizar</button></td>');
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



        // Obtén los datos del formulario
        let idElement = document.getElementById('id');
        let nombreElement = document.getElementById('nombre');
        let apellidoElement = document.getElementById('apellido');
        let telefonoElement = document.getElementById('telefono');
        let correoElement = document.getElementById('correo');
        let contrasenaElement = document.getElementById('contraseña');
        let rolElement = document.getElementById('rol');
        let areaElement = document.getElementById('area');

        // Verifica que los elementos del formulario existan y tengan un valor
        if (idElement && nombreElement && apellidoElement && telefonoElement && correoElement && contrasenaElement && rolElement && areaElement) {
          let id = idElement.value;
          let nombre = nombreElement.value;
          let apellido = apellidoElement.value;
          let telefono = telefonoElement.value;
          let correo = correoElement.value;
          let contrasena = contrasenaElement.value;
          let rol = rolElement.value;
          let area = areaElement.value;

          // Crea un objeto con los datos del usuario
          let usuario = {
            id: id,
            nombre: nombre,
            apellido: apellido,
            telefono: telefono,
            correo: correo,
            contrasena: contrasena,
            rol: rol,
            area: area
          };

          // Realiza la llamada Ajax para actualizar el usuario
          $.ajax({
            url: 'http://localhost:8080/actualizarUsuario',
            type: 'PUT',
            data: JSON.stringify(usuario),
            contentType: 'application/json',
            success: function(response) {
              // Maneja la respuesta del servidor
              alert(response); // Muestra la respuesta en un cuadro de diálogo (puedes cambiar esto según tus necesidades)
            },
            error: function(error) {
              // Maneja el error en caso de que ocurra
              console.log(error); // Muestra el error en la consola (puedes cambiar esto según tus necesidades)
            }
          });
        } else {
          console.log('Error: No se encontraron elementos del formulario o faltan valores.'); // Muestra un mensaje de error en la consola
        }


        // Función para redirigir al formulario de actualizar con los datos del empleado seleccionado
        function redireccionarActualizar(id) {
          window.location.href = '../Gestion ingresar empleado.html' + id;
        }

        // Manejar el evento click del botón "Actualizar" en cada fila
        $('#tabla tbody').on('click', 'tr', function() {
          let id = $(this).find('td:first').text(); // Obtener el ID del empleado de la fila seleccionada
          redireccionarActualizar(id); // Redireccionar al formulario de actualizar con el ID como parámetro
        });



});


