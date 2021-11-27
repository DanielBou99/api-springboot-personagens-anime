package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Personagem;

public interface PersonagemRepo extends JpaRepository<Personagem, Long> {
	
	Optional<Personagem> findPersonagemById(Long id);
}
