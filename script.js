

const loginTab = document.getElementById('loginTab');
        const registerTab = document.getElementById('registerTab');
        const loginForm = document.getElementById('loginForm');
        const registerForm = document.getElementById('registerForm');

        loginTab.onclick = () => {
            loginTab.classList.add('active');
            registerTab.classList.remove('active');
            loginForm.classList.add('active');
            registerForm.classList.remove('active');
        };
        registerTab.onclick = () => {
            registerTab.classList.add('active');
            loginTab.classList.remove('active');
            registerForm.classList.add('active');
            loginForm.classList.remove('active');
        };

        // Aca podemos agregar la lógica para manejar el registro y login con JS o conectarlo a tu backend
        loginForm.onsubmit = function(e) {
            e.preventDefault();
            alert('Inicio de sesión simulado');
        };

        registerForm.onsubmit = function(e) {
            e.preventDefault();
            window.location.href = "perfil.html"; // Redirige a la página de perfil
        };

        fetch('http://localhost:8080/api/alumnos/', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({ id: "1", nombre: "Santiago" })
})
.then(res => res.text())
.then(data => console.log("POST:", data));

// Obtener el alumno con ID 1
fetch('http://localhost:8080/api/alumnos/1')
  .then(res => res.text())
  .then(data => console.log("GET:", data));