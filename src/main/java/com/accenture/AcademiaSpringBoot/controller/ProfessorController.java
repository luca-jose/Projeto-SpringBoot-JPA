package com.accenture.AcademiaSpringBoot.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.AcademiaSpringBoot.model.Professor;
import com.accenture.AcademiaSpringBoot.repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;

	
	@PostMapping("/create")
	public Professor createProfessor(@RequestBody Professor professor) {
		
		return this.professorRepository.save(professor);

	}
	
	@GetMapping("/view")
	public List<Professor> viewProfessor() {
		return this.professorRepository.findAll();
	}
	
	@GetMapping("/viewprofessor/{cpf}")
    public Optional<Professor> viewProfessor(@PathVariable("cpf") String cpf) {
		return this.professorRepository.findById(cpf);
    	}
    
	
	@DeleteMapping("/delete/{cpf}")
	public  String deleteProfessor(@PathVariable("cpf") String cpf) {
		
		Optional<Professor> professorFind = this.professorRepository.findById(cpf);
		
		if (professorFind.isPresent()) {
			professorRepository.delete(professorFind.get());
			
			return "Professor excluido com sucesso :D";
		}else {
			
			return "Professor não existe no nosso banco de dados :(";
		}
		
	}
	
	@PutMapping("/update/{cpf}")
	public String updateProfessor(@RequestBody Professor newProfessor, @PathVariable("cpf") String cpf) {
		
		Optional<Professor> oldProfessor = this.professorRepository.findById(cpf);
		if (oldProfessor.isPresent()) {
			professorRepository.delete(oldProfessor.get());
			Professor professor = oldProfessor.get();
			professor.setName(newProfessor.getName());
			professor.setSalario(newProfessor.getSalario());
			professor.setIdade(newProfessor.getIdade());
			professorRepository.save(professor);
			
			return "Professor alterado com sucesso :D";
		}else {
			return "Professor não existe no nosso banco de dados :(";
		}
	}
	
	
	
}