package com.accenture.AcademiaSpringBoot.controller;

import java.util.List;
import java.util.Optional;
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
	
	@GetMapping("/viewcurso/{id}")
    public Optional<Curso> viewCurso(@PathVariable("id") int id) {
		return this.cursoRepository.findById(id);
    	}
	
	@DeleteMapping("/delete/{id}")
	public  String deleteCurso(@PathVariable("id") int id) {
		
		Optional<Curso> cursoFind = this.cursoRepository.findById(id);
		
		if (cursoFind.isPresent()) {
			cursoRepository.delete(cursoFind.get());
			
			return "Curso excluido com sucesso! :D";
		}else {
			
			return "Curso não existe no nosso banco de dados :(";
		}
		}
	
	@PutMapping("/update/{id}")
	public String updateCurso (@RequestBody Curso newCurso, @PathVariable("id") int id) {
		
		Optional<Curso> oldCurso = this.cursoRepository.findById(id);
		if (oldCurso.isPresent()) {
			cursoRepository.delete(oldCurso.get());
			Curso curso = oldCurso.get();
			curso.setId(newCurso.getId());
			curso.setName(newCurso.getName());
			cursoRepository.save(curso);
			
			return "Curso alterado com sucesso! :D";
		}else {
			return "Curso não existe no nosso banco de dados :(";
		}
}
}
