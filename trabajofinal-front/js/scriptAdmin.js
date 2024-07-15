const btnList = document.getElementById("btnList");
const container = document.getElementById("listado");
const url = "http://localhost:8080/trabajofinal";

window.onload=getAllUsers(); // Carga la lista de usuarios al ingresar a la pagina

function getUser() {
  fetch(url + "/findusercontroller")
    .then((resp) => resp.json()) //Convierto la respuesta en JSON
    .then((data) => {
      console.log(data); // Muestro la informacion que tengo en consola
      container.classList = "container text-center pt-2 col-6 cartel";
      let userFile = userList(data);
      container.innerHTML = userFile;
    })
    .catch((err) => console.log("Solicitud fallida", err)); // Capturar errores
}

function getAllUsers() {
  fetch(url + "/findalluserscontroller")
    .then((resp) => resp.json()) // Convierte la respuesta en JSON
    .then((data) => {
      container.innerHTML = ""; // Blanqueamos el container donde se van a insertar los datos
      for (let i = 0; i < data.length; i++) {
        let userList = allUsersList(data, i);
        container.appendChild(userList);
      }
    })
    .catch((err) => console.log("Solicitud fallida", err)); // Capturar errores
}

function deleteUser(id) {
  Swal.fire({
    title: "Estas seguro?",
    text: "Se borrara el usuario de la base de datos!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Si, borrar!",
  }).then(async (result) => {
    await fetch(url + `/deleteusercontroller?id=${id}`, {
      method: "delete",
    });
    getAllUsers()
    if (result.isConfirmed) {
      Swal.fire({
        title: "Excelente!",
        text: "El usuario fue borrado.",
        icon: "success",
      });
    }
  });
}

function userList(data) {
  return `
    <div class="container col-lg-6">
      <div class="p-0"></div>
      <div class="row col-lg p-2"><div class="form-control" id="usuario">${data.user}</div></div>
      <div class="row col-lg p-2"><div class="form-control" id="nombre">${data.nombre}</div></div>
      <div class="row col-lg p-2"><div class="form-control" id="apellido">${data.apellido}</div></div>
      <div class="row col-lg p-2"><div class="form-control" id="telefono">${data.telefono}</div></div>
      <div class="row col-lg p-2"><div class="form-control" id="email">${data.email}</div></div>
      <div class="row justify-content-center p-2">
        <button value="${data.id}" type="button" class="btn btn-dark col-4 text-light" id="borrar">Borrar</button>
      </div>
    </div>`;
}

function allUsersList(usuario, i) {
  // Crear un div contenedor para el usuario
  let userDiv = document.createElement("div");
  userDiv.classList.add("row", "m-1", "cartel");

  // Agregar el HTML dentro del div contenedor
  userDiv.innerHTML = `
    <div class="col-sm-1 p-2"><div class="form-control bg-success text-white" id="usuario">${usuario[i].id}</div></div>
    <div class="col-sm-2 p-2"><div class="form-control bg-success text-white" id="usuario">${usuario[i].user}</div></div>
    <div class="col-sm-2 p-2"><div class="form-control bg-success text-white" id="nombre">${usuario[i].nombre}</div></div>
    <div class="col-sm-2 p-2"><div class="form-control bg-success text-white" id="apellido">${usuario[i].apellido}</div></div>
    <div class="col-sm-2 p-2"><div class="form-control bg-success text-white" id="telefono">${usuario[i].telefono}</div></div>
    <div class="col-sm-2 p-2"><div class="form-control bg-success text-white" id="email">${usuario[i].email}</div></div>
    <button onclick="deleteUser(${usuario[i].id})" type="button" class="btn btn-dark col-sm-1 text-light" id="borrar">Borrar</button>
  `;

  return userDiv;
}
