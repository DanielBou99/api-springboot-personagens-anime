package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.modelo.Personagem;
import com.example.demo.repo.PersonagemRepo;

@Service
public class PersonagemService {
	
	@Autowired
	private PersonagemRepo personagemRepo;
	
	public List<Personagem> listarTodosPersonagens() {
		return personagemRepo.findAll();
    }
	
	public Personagem encontrarPersonagem(Long id) {
		return personagemRepo.findPersonagemById(id)
				.orElseThrow(() -> new UserNotFoundException("Personagem id " + id + " não foi encontrado."));
	}

	public void salvarPersonagem(Personagem personagem) {
		personagemRepo.save(personagem);
	}
	
}
