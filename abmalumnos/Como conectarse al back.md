# Como conectarse al backend
por Joaquin Pla Cardenas


## Estructuras de datos
Todas las estrucuras de datos pueden ser obtenidas mandando un mensaje a `http://[urlPagina]/api/test/XXX` donde `XXX` es la estructura que se quiere obtener

`/XXX` disponibles:
+ `/alumno`     - Devuelve un JSON con la estructura de un alumno
+ `/carrera`    - Devuelve un JSON con la estructura de una carrera
+ `/materia`    - Devuelve un JSON con la estructura de una materia
+ `/usuario`    - Devuelve un JSON con la estructura de un usuario
+ `/array`      - Devuelve un JSON con un array vacio
+ `/logindata`  - Devuelve un JSON con la estructura usada para hacer login
+ `/passchange` - Devuelve un JSON con la estructura usada para cambiar la contraseña de un usuario
+ `/register`   - Devuelve un JSON con la estructura usada para registrar a un nuevo alumno

### Esto es lo que devuelven actualmente
+ `/alumno`     - `{"legajo":null,"nombre":null,"dni":null,"fechaNacimiento":null,"direccion":null,"contacto":null,"correoUni":null,"carreras":null,"materiasAprobadas":null,"materiasCursa":null}`
+ `/carrera`    - `{"codigoCarrera":null,"nombreCarrera":null}`
+ `/materia`    - `{"codigoMateria":null,"nombreMateria":null}`
+ `/usuario`    - `{"legajo":null,"esAdmin":false}`
+ `/array`      - `[null, null]`
+ `/logindata`  - `{"legajo":null,"contra":null}`
+ `/passchange` - `{"loginData":{"legajo":null,"contra":null},"nuevaContra":null}`
+ `/register`   - `{"alumno":{"legajo":null,"nombre":null,"dni":null,"fechaNacimiento":null,"direccion":null,"contacto":null,"correoUni":null,"carreras":null,"materiasAprobadas":null,"materiasCursa":null},"contra":null}`

Notas:
- El legajo es inmutable y no puede ser cambiado
- Notar que PassChange y Register son estructuras compuestas, y se deben mandar de la misma manera que se muestra aca
- Pass change requiere el login actual, y una contraseña nueva


## Usuarios
Las acciones relevantes a los usuarios se encuentran en `http://[urlPagina]/api/usuarios/XXX` donde `XXX` es la accion a realizar

  `/XXX`                - Metodo    - [formato requerido](#estructuras-de-datos)                 - notas
+ `/register`           - POST      - Requiere la estructura Register   - Registra a un usuario nuevo
  - Retorna 400 [BAD REQUEST] si ya existe
+ `/changePass`         - PUT       - Requiere la estructura PassChange - Cambia la contraseña de un usuario
  - Retorna 401 [UNAUTHORIZED] si la contraseña vieja no es correcta
  - Retorna 404 [NOT FOUND] si no existe tal usuario;
+ `/login`              - GET       - Requiere la estructura LoginData  - Inicio de sesion
  - Retorna 401 [UNAUTHORIZED] si la contraseña no es correcta
  - Retrona 404 [NOT FOUND] si no existe tal usuario
+ `/delete`             - DELETE    - Requiere la estructura LoginData  - Elimina al usuario logeado
  - Retorna 401 [UNAUTHORIZED] si la contraseña no es correcta
  - Retrona 404 [NOT FOUND] si no existe tal usuario
+ `/delete/{legajo}`    - DELETE    - Requiere la estructura LoginData  - Elimina al usuario indicado si sos admin
  - Retorna 401 [UNAUTHORIZED] si la contraseña no es correcta o el usuario no es admin
  - Retrona 404 [NOT FOUND] si no existe tal admin o usuario
