package com.accenture.AcademiaSpringBoot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.AcademiaSpringBoot.model.Curso;
import com.accenture.AcademiaSpringBoot.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@PostMapping("/create")
	public Curso createCurso(@Valid @RequestBody Curso curso) {
		return this.cursoRepository.save(curso);
	}

	@GetMapping("/view")
	public List<Curso> viewCurso() {
		return this.cursoRepository.findAll();
	}
}
