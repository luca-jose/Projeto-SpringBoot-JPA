package com.accenture.AcademiaSpringBoot.controller;

import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.AcademiaSpringBoot.model.Aluno;
import com.accenture.AcademiaSpringBoot.model.Curso;
import com.accenture.AcademiaSpringBoot.repository.AlunoRepository;
import com.accenture.AcademiaSpringBoot.repository.CursoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@PostMapping("/create/{id}")
	public Aluno createAluno(@PathVariable("id") int id, @Valid @RequestBody Aluno aluno) {
		Optional<Curso> cursoteste = this.cursoRepository.findById(id);
		if(cursoteste.isPresent()) {
			Curso curso = cursoteste.get();
			aluno.setCurso(curso);
		}
		return this.alunoRepository.save(aluno);

	}
	
	@GetMapping("/view")
	public List<Aluno> viewAluno() {
		return this.alunoRepository.findAll();
	}
	
	@GetMapping("/viewaluno/{id}")
    public Optional<Aluno> viewAluno(@PathVariable("id") int id) {
		return this.alunoRepository.findById(id);
    	}
    
	
	@DeleteMapping("/delete/{id}")
	public  String deleteAluno(@PathVariable("id") int id) {
		
		Optional<Aluno> alunoFind = this.alunoRepository.findById(id);
		
		if (alunoFind.isPresent()) {
			alunoRepository.delete(alunoFind.get());
			
			return "Aluno excluido com sucesso! :D";
		}else {
			
			return "Aluno não existe no nosso banco de dados :(";
		}
		
	}
	
	@PutMapping("/update/{id}")
	public String updateAluno (@RequestBody Aluno newAluno, @PathVariable("id") int id) {
		
		Optional<Aluno> oldAluno = this.alunoRepository.findById(id);
		if (oldAluno.isPresent()) {
			alunoRepository.delete(oldAluno.get());
			Aluno aluno = oldAluno.get();
			aluno.setName(newAluno.getName());
			aluno.setCurso(newAluno.getCurso());
			aluno.setIdade(newAluno.getIdade());
			aluno.setCpf(newAluno.getCpf());
			alunoRepository.save(aluno);
			
			return "Aluno alterado com sucesso! :D";
		}else {
			return "Aluno não existe no nosso banco de dados :(";
		}
	}
	
	
	
}