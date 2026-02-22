<<<<<<< HEAD
# ABM de Alumnos

Sistema web para alta, baja y modificación de alumnos.

## Estructura del proyecto

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

### Opción manual

1. Iniciar MySQL portable:

```bat
cd database
mysql\mysql-8.4.6-winx64\bin\mysqld.exe --defaults-file=my.ini --console
```

2. Iniciar backend:

```bat
cd abmalumnos
mvnw.cmd spring-boot:run
```

3. Iniciar frontend:

```bat
cd front
python -m http.server 5500
```

4. Abrir:

`http://localhost:5500/index.html`

## Configurar URL de API en frontend

El frontend usa `front/config.js`.

- En local (`localhost`), por defecto usa `http://localhost:8080/api`.
- En otros hosts (ej. GitHub Pages), debes definir la API en `localStorage`:

```js
localStorage.setItem("apiBaseUrl", "https://TU-BACKEND/api");
```

## Subir frontend a GitHub Pages

1. Subir el repositorio a GitHub.
2. Ir a `Settings > Pages`.
3. En `Build and deployment`, seleccionar:
- `Source`: `Deploy from a branch`
- `Branch`: `main` (o la que uses)
- `Folder`: `/front` (si GitHub permite seleccionar carpeta) o `/ (root)` moviendo/copiendo frontend a raíz.
4. Guardar y esperar publicación.
5. URL final típica:
`https://<usuario>.github.io/<repo>/`

## Importante sobre GitHub Pages + backend

GitHub Pages solo sirve archivos estáticos.  
No ejecuta Java ni MySQL.

Para que funcione completo:

- Desplegar `abmalumnos` en un host backend (Render, Railway, Fly.io, etc.).
- Tener una base MySQL accesible desde ese backend.
- Configurar en el frontend:

```js
localStorage.setItem("apiBaseUrl", "https://TU-BACKEND/api");
```

## Validación técnica rápida

Backend tests:

```bat
cd abmalumnos
mvnw.cmd test
```

Backend build:

```bat
cd abmalumnos
mvnw.cmd -DskipTests package
```
=======
#🎓 ABM de Alumnos - Sistema de Gestión Estudiantil
Un sistema web moderno para gestionar el Alta, Baja y Modificación de registros estudiantiles

#🔗 Demo en vivo: 
https://hever2000.github.io/Proyecto-ABM-Alumnos/

-Interfaz moderna y responsive que funciona en cualquier dispositivo
-Validación de formularios en tiempo real
-Búsqueda instantánea de alumnos

#🛠️ Tecnologías Utilizadas
#Frontend:

JS Vanilla

#Backend:

JAVA - SPRING-BOOT


#⚙️ Instalación Local
Clona el repositorio:

bash
git clone https://github.com/hever2000/Proyecto-ABM-Alumnos.git
Abre el archivo index.html en tu navegador

o tambien podes hacerlos desde visual studio en "clonar repositorio"



>>>>>>> 09dcbf301fbf3f112ab5daa0faaf404bae04d96f
