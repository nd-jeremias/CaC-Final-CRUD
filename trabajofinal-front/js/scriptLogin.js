const userName = "admin"
const userPass = "pass"
const loginBtn = document.getElementById("loginbtn")

loginBtn.addEventListener('click', () => {
    loginForm();
});

function loginForm() {
    Swal.fire({
        title: 'Ingresar',
        html: `
            <input type="text" id="loginUsername" class="swal2-input" placeholder="Usuario">
            <input type="password" id="loginPassword" class="swal2-input" placeholder="Contraseña">
        `,
        confirmButtonText: 'Entrar',
        focusConfirm: false,
        didOpen: () => {
            const popup = Swal.getPopup();
            const usernameInput = popup.querySelector('#loginUsername');
            const passwordInput = popup.querySelector('#loginPassword');
            usernameInput.focus();
        },
        preConfirm: () => {
            const loginUsername = document.getElementById('loginUsername').value;
            const loginPassword = document.getElementById('loginPassword').value;
            if (loginUsername != userName || loginPassword != userPass) {
            //if (!loginUsername || !loginPassword) {
                Swal.showValidationMessage('Por favor ingresa usuario y contraseña correctos');
                return false;
            }
            return { loginUsername, loginPassword };
        }
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                icon: 'success',
                title: 'Bienvenido!',
                showConfirmButton: false,
                timer: 1500
            })
            setTimeout(() => {
                // Redirigir a otra página o realizar alguna acción
                window.location.href = "./admin.html"; // Reemplaza con la URL de destino
            }, 1800);
        }
        
    });
}