package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.modelo.Personagem;
import com.example.demo.modelo.Serie;
import com.example.demo.repo.SerieRepo;

@Service
public class SerieService {
	
	@Autowired
	private SerieRepo serieRepo;
	
	public List<Serie> listarTodasSeries() {
		return serieRepo.findAll();
    }
	
	public Serie encontrarSerie(Long id) {
		return serieRepo.findSerieById(id)
				.orElseThrow(() -> new UserNotFoundException("Serie id " + id + " não foi encontrada."));
	}

	public void salvarSerie(Serie serie) {
		serieRepo.save(serie);
	}
	
	public void deletarSerie(Long id) {
		serieRepo.deleteById(id);
	}
}
