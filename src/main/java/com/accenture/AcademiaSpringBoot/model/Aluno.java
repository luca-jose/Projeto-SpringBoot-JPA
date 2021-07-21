package com.accenture.AcademiaSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Length(min = 11, max = 11, message = "CPF deve conter no minimo 11 caracteres")
	private String cpf;	
	@NotBlank(message= "Campo não preenchido")
	private String name;
	private String curso;
	@Min(value = 16, message = "Idade abaixo do permitido")
	private int idade;
	
	
}
