

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

        // Aquí puedes agregar la lógica para manejar el registro y login con JS o conectarlo a tu backend
        loginForm.onsubmit = function(e) {
            e.preventDefault();
            alert('Inicio de sesión simulado');
        };

        registerForm.onsubmit = function(e) {
            e.preventDefault();
            // Aquí puedes agregar la lógica para guardar el registro
            window.location.href = "perfil.html"; // Redirige a la página de perfil
        };