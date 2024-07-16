document.querySelector('.link-underline-primary').addEventListener('click', function(event) {
  event.preventDefault(); // Evita que el enlace abra la página directamente
  $('#modalCrearCuenta').modal('show'); // Muestra el segundo modal
});
