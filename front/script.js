

const loginTab = document.getElementById('loginTab');
        const loginForm = document.getElementById('loginForm');


        // Aca podemos agregar la lógica para manejar el registro y login con JS o conectarlo a tu backend
        loginForm.onsubmit = function(e) {
            e.preventDefault();
            fetch ('http://localhost:8080/api/usuarios/login', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    legajo: document.getElementById('loginUser').value,
                    contra: document.getElementById('loginPass').value
                })
            })
            .then(res => res.json())
            .then(data => {
                localStorage.setItem('legajo', document.getElementById('loginUser').value);
                window.location.href = "inicio.html"; // Redirige a la página de perfil
            })
            .catch(err => {
                alert('Error al iniciar sesión: ' + err);
            });
            
        };


