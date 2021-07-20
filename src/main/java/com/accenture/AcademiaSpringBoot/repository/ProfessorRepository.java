package com.accenture.AcademiaSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.accenture.AcademiaSpringBoot.model.Professor;

public interface ProfessorRepository extends JpaRepository <Professor, String >{

}
