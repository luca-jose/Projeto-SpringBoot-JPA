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
	
	@GetMapping("/viewprofessor/{id}")
    public Optional<Professor> viewProfessor(@PathVariable("id") int id) {
		return this.professorRepository.findById(id);
    	}
    
	
	@DeleteMapping("/delete/{id}")
	public String deleteProfessor(@PathVariable("cpf") int id) {
		
		Optional<Professor> professorFind = this.professorRepository.findById(id);
		
		if (professorFind.isPresent()) {
			professorRepository.delete(professorFind.get());
			
			return "Professor excluido com sucesso! :D";
		}else {
			
			return "Professor não existe no nosso banco de dados :(";
		}
		
	}
	
	@PutMapping("/update/{id}")
	public String updateProfessor(@RequestBody Professor newProfessor, @PathVariable("id") int id) {
		
		Optional<Professor> oldProfessor = this.professorRepository.findById(id);
		if (oldProfessor.isPresent()) {
			professorRepository.delete(oldProfessor.get());
			Professor professor = oldProfessor.get();
			professor.setName(newProfessor.getName());
			professor.setSalario(newProfessor.getSalario());
			professor.setIdade(newProfessor.getIdade());
			professor.setCpf(newProfessor.getCpf());
			professorRepository.save(professor);
			
			return "Professor alterado com sucesso! :D";
		}else {
			return "Professor não existe no nosso banco de dados :(";
		}
	}
	
	
	
}