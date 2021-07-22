package com.accenture.AcademiaSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.accenture.AcademiaSpringBoot.model.Curso;

public interface CursoRepository extends JpaRepository <Curso, Integer >{

}