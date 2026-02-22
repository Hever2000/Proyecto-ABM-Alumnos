
# 🎓 ABM de Alumnos

Sistema web para alta, baja y modificación de alumnos.

## 🛠️ Estructura del proyecto

- `front/`: frontend estático (`HTML`, `CSS`, `JS`).
- `abmalumnos/`: backend `Spring Boot` (API REST).
- `database/`: MySQL portable y configuración.
- `scripts/start.bat`: arranque rápido de todo el stack local.

## Requisitos

- Java 21+.
- Maven Wrapper (ya incluido en `abmalumnos/mvnw.cmd`).
- Python 3 (para servir `front/` con `http.server`).

## Correr en local

### Opción rápida

Desde la raíz del repo:

```bat
scripts\start.bat
```

Esto inicia:

- MySQL portable en `3306`.
- Backend en `http://localhost:8080`.
- Frontend en `http://localhost:5500/index.html`.







>>>>>>> 09dcbf301fbf3f112ab5daa0faaf404bae04d96f
