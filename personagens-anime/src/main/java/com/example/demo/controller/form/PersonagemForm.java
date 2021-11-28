package com.example.demo.controller.form;

import com.example.demo.modelo.Personagem;
import com.example.demo.modelo.Serie;

public class PersonagemForm {
	
	private String nome;
	private Long idSerie;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(Long idSerie) {
		this.idSerie = idSerie;
	}
	
	public Personagem converterParaPersonagem(Serie serie) {
		Personagem personagem = new Personagem();
		personagem.setNome(this.nome);
		personagem.setSerie(serie);
		return personagem;
	}
}
