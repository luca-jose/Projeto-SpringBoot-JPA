package com.accenture.AcademiaSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity

public class Aluno {
	
	@Id
	private String cpf;	
	private String name;
	private String curso;
	private int idade;
	
	
}
