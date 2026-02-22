@echo off
setlocal
set ROOT_DIR=%~dp0..
set DB_DIR=%ROOT_DIR%\database
set BACK_DIR=%ROOT_DIR%\abmalumnos
set FRONT_DIR=%ROOT_DIR%\front
set MYSQL_BIN=%DB_DIR%\mysql\mysql-8.4.6-winx64\bin\mysqld.exe

echo Iniciando MySQL portable...
start "MySQL" cmd /k "cd /d ""%DB_DIR%"" && ""%MYSQL_BIN%"" --defaults-file=my.ini --console"

echo Iniciando backend (Spring Boot)...
start "Backend" cmd /k "cd /d ""%BACK_DIR%"" && mvnw.cmd spring-boot:run"

echo Iniciando frontend estatico en puerto 5500...
start "Frontend" cmd /k "cd /d ""%FRONT_DIR%"" && python -m http.server 5500"

timeout /t 8 >nul
start "" "http://localhost:5500/index.html"

