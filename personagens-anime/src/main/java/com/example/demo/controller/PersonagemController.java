package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Personagem;
import com.example.demo.service.PersonagemService;

@Controller
@RequestMapping("/personagem")
public class PersonagemController {
	
	@Autowired
	private PersonagemService personagemService;

	@GetMapping("/todos")
    public ResponseEntity<List<Personagem>> listarTodosPersonagens(){
        List<Personagem> personagens = personagemService.listarTodosPersonagens();
        return new ResponseEntity<>(personagens, HttpStatus.OK);
    }

	@GetMapping("/encontrar/{id}")
    public ResponseEntity<Personagem> encontrarPersonagemPeloId(@PathVariable("id") Long id){
        Personagem personagem = personagemService.encontrarPersonagem(id);
        return new ResponseEntity<>(personagem, HttpStatus.OK); 
    }
}
