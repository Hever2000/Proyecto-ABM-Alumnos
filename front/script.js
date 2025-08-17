
const loginForm = document.getElementById('loginForm');
const logoutBtn = document.getElementById('logoutBtn');

// Login
loginForm.onsubmit = function(e) {
    e.preventDefault();
    const legajo = document.getElementById('loginUser').value;
    const contra = document.getElementById('loginPass').value;
    
    fetch('http://localhost:8080/api/usuarios/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ legajo, contra })
    })
    .then(response => {
        if (response.status === 401) throw new Error('Credenciales inválidas');
        if (response.status === 404) throw new Error('Usuario no encontrado');
        if (!response.ok) throw new Error('Error en el servidor');
    })
    .then(data => {
        localStorage.setItem('legajo', legajo);
        window.location.href = "inicio.html";
    })
    .catch(err => alert('Error: ' + err.message));
};

// Logout
if (logoutBtn) {
    logoutBtn.onclick = () => {
        localStorage.removeItem('legajo');
        window.location.href = "index.html";
    };
}