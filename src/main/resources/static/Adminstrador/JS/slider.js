(function(){
    const sliders = [...document.querySelectorAll('.slider__body')];
    const arrowNext = document.querySelector('#next');
    const arrowBefore = document.querySelector('#before');
    let value; 

    arrowNext.addEventListener('click', ()=>changePosition(1)); 

    arrowBefore.addEventListener('click', ()=>changePosition(-1));

    function changePosition(change){
        const currentElement = Number(document.querySelector('.slider__body--show').
        dataset.id);

        value = currentElement; 
        value+= change; 

        if(value === 0 || value == sliders.length+1){
            value = value === 0 ? sliders.length : 1; 
        }

        sliders[currentElement-1].classList.toggle('slider__body--show'); 
        sliders[value-1].classList.toggle('slider__body--show'); 

    }
})() 

function toggleMenu() {
    var menu = document.getElementById("menu");
    menu.classList.toggle("active");
  }


$(document).ready(function(){

$('#registrar').on('click', function() {
    let datos = {
        id: parseInt($('#id').val()),
        nombre: $('#nombre').val(),
        apellido: $('#apellido').val(),
        telefono: parseInt($('#telefono').val()),
        rol: $('#rol').val(),
        imagen: $('#seleccionar__imagen').val(),
    }
    
    console.log(datos);
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);

    $.ajax({
        url: "http://localhost:8080/agregarEmpleado",
        type: "POST",
        data: datosEnvio,
        contentType: "application/JSON",
        dataType: "JSON",
        success: function(respuesta) {
            alert(respuesta);
        }
    });
    });
});