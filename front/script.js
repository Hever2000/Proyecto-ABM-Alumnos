

const loginTab = document.getElementById('loginTab');
        const loginForm = document.getElementById('loginForm');


        // Cambiar el método a POST y manejar errores correctamente
        loginForm.onsubmit = function(e) {
            e.preventDefault();
            const legajo = document.getElementById('loginUser').value;
            const contra = document.getElementById('loginPass').value;
            
            fetch('http://localhost:8080/api/usuarios/login', {
                method: 'POST',  // Cambiado a POST
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ legajo, contra })
            })
            .then(response => {
                if (response.status === 401) throw new Error('Credenciales inválidas');
                if (response.status === 404) throw new Error('Usuario no encontrado');
                return response.json();
            })
            .then(data => {
                localStorage.setItem('legajo', legajo);
                window.location.href = "inicio.html";
            })
            .catch(err => alert('Error: ' + err.message));
        };


// Lógica para el modal de cierre de sesión
    const logoutBtn = document.getElementById("logoutBtn");
    
    // Modificar el logout para limpiar solo lo necesario
    logoutBtn.onclick = () => {
        localStorage.removeItem('legajo');
        window.location.href = "index.html";
    };


