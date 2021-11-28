package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.controller.form.PersonagemForm;
import com.example.demo.modelo.Personagem;
import com.example.demo.modelo.Serie;
import com.example.demo.repo.PersonagemRepo;
import com.example.demo.service.PersonagemService;
import com.example.demo.service.SerieService;

@Controller
@RequestMapping("/personagem")
public class PersonagemController {

	@Autowired
	private PersonagemService personagemService;
	
	@Autowired
	private SerieService serieService;

	@GetMapping("/todos")
    public ResponseEntity<List<Personagem>> listarTodosPersonagens(){
        List<Personagem> personagens = personagemService.listarTodosPersonagens();
        return new ResponseEntity<>(personagens, HttpStatus.OK);
    }

	@GetMapping("/encontrar/{id}")
    public ResponseEntity<Personagem> encontrarPersonagemPeloId( @PathVariable("id") Long id){
        Personagem personagem = personagemService.encontrarPersonagem(id);
        return new ResponseEntity<>(personagem, HttpStatus.OK);
    }
	
	@PostMapping
	@Transactional
	public ResponseEntity<Personagem> cadastrar(@RequestBody PersonagemForm form, UriComponentsBuilder uriBuilder) {
		
		Serie serie = serieService.encontrarSerie(form.getIdSerie());
		Personagem personagem = form.converterParaPersonagem(serie);
		personagemService.salvarPersonagem(personagem);

		return new ResponseEntity<>(personagem, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		try {
			Personagem personagem = personagemService.encontrarPersonagem(id);
			personagemService.deletarPersonagem(id);			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
