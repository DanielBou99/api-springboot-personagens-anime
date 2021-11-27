package com.example.demo.controller.form;

import com.example.demo.modelo.Personagem;

public class PersonagemForm {
	
	private String nome;
	private String serie;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public Personagem converterParaPersonagem() {
		Personagem personagem = new Personagem();
		personagem.setNome(this.nome);
		personagem.setSerie(this.serie);
		
		return personagem;
	}
}
