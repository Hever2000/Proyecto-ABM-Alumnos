const loginForm = document.getElementById("loginForm");
const logoutBtn = document.getElementById("logoutBtn");

if (loginForm) {
    loginForm.onsubmit = (e) => {
        e.preventDefault();

        const legajo = document.getElementById("loginUser").value;
        const contra = document.getElementById("loginPass").value;

        fetch(getApiUrl("/usuarios/login"), {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ legajo, contra })
        })
            .then((response) => {
                if (response.status === 401) throw new Error("Credenciales inválidas");
                if (response.status === 404) throw new Error("Usuario no encontrado");
                if (!response.ok) throw new Error("Error en el servidor");
                return response.json();
            })
            .then((esAdmin) => {
                localStorage.setItem("legajo", legajo);
                localStorage.setItem("esAdmin", String(esAdmin));
                window.location.href = "inicio.html";
            })
            .catch((err) => alert("Error: " + err.message));
    };
}

if (logoutBtn) {
    logoutBtn.onclick = (e) => {
        e.preventDefault();
        localStorage.removeItem("legajo");
        localStorage.removeItem("esAdmin");
        window.location.href = "index.html";
    };
}
