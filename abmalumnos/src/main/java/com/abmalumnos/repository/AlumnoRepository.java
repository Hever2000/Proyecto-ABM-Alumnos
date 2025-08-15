package com.abmalumnos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.abmalumnos.dataStructures.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {
  
    Optional<Alumno> findBydni(String dni);
}