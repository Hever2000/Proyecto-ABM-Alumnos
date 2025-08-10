

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

document.addEventListener("DOMContentLoaded", () => {
  // --- Lógica para el modal de cierre de sesión ---
  // Esta lógica se aplicará a todas las páginas que incluyan este script
  // y tengan el botón de logout y el modal.

  const logoutBtn = document.querySelector(".logout-btn");
  const modal = document.getElementById("confirmModal");

  // Si no encontramos el botón o el modal en la página, no hacemos nada.
  if (!logoutBtn || !modal) {
    return;
  }

  const confirmBtn = document.getElementById("confirmBtn");
  const cancelBtn = document.getElementById("cancelBtn");

  logoutBtn.addEventListener("click", function (e) {
    e.preventDefault(); // Prevenir la navegación inmediata
    modal.style.display = "flex";
  });

  cancelBtn.addEventListener("click", function () {
    modal.style.display = "none";
  });

  confirmBtn.addEventListener("click", function () {
    localStorage.removeItem("usuario"); // Limpiar sesión
    window.location.href = "index.html"; // Redirigir al login
  });

  // Cerrar el modal si se hace clic fuera de él
  window.addEventListener("click", function (e) {
    if (e.target == modal) {
      modal.style.display = "none";
    }
  });
});