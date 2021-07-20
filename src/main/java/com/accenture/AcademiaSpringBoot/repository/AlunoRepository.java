package com.accenture.AcademiaSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.AcademiaSpringBoot.model.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, String >{

}
