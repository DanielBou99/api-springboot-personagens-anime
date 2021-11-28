package com.example.demo.controller.form;

import com.example.demo.modelo.Serie;

public class SerieForm {
	
	private String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Serie converterParaSerie() {
		Serie serie = new Serie();
		serie.setNome(this.nome);
		serie.setPersonagens(null);
		return serie;
	}

}
