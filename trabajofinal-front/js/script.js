const submitform = document.getElementById('submitform');

function crearUsuario() {
    
    const user = document.getElementById("usuario").value;
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const telefono = document.getElementById("telefono").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    let jsonRequest = {
        user,
        nombre,
        apellido,
        telefono,
        email,
        password
    }

    fetch("http://localhost:8080/trabajofinal/createusercontroller", {
        method: 'POST',
        body: JSON.stringify(jsonRequest),
        headers: new Headers({
            'Content-Type': 'application/json'
        })
    })
    .then(() => {
        Swal.fire({
            icon: 'success',
            title: 'Creacion del usuario correcta',
            showConfirmButton: false,
            timer: 1500
        })
        cleanForm()
    })
    .catch(err => console.log('Solicitud fallida', err)); // Capturar errores
    
};

submitform.addEventListener('click', (form) => {
    
    let array = form.target.form

    for(let i = 0; i < array.length-1; i++) {
        if(!array[i].value)
        {
            Swal.fire({
              icon: "error",
              title: "Oops...",
              text: "Tienes que completar todos los datos!",
            });
            return false;
        }
    }
    crearUsuario();
    return true;
});

function cleanForm() {
    document.getElementById("usuario").value = ""
    document.getElementById("nombre").value = ""
    document.getElementById("apellido").value = ""
    document.getElementById("telefono").value = ""
    document.getElementById("email").value = ""
    document.getElementById("password").value = ""
}