package com.abmalumnos.repository;

import org.springframework.data.repository.CrudRepository;

import com.abmalumnos.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {
  
}