package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.controller.form.SerieForm;
import com.example.demo.modelo.Personagem;
import com.example.demo.modelo.Serie;
import com.example.demo.service.SerieService;

@Controller
@RequestMapping("/serie")
public class SerieController {
	
	@Autowired
	private SerieService serieService;

	@GetMapping("/todos")
    public ResponseEntity<List<Serie>> listarTodasSeries(){
        List<Serie> series = serieService.listarTodasSeries();
        return new ResponseEntity<>(series, HttpStatus.OK);
    }
	
	@GetMapping("/encontrar/{id}")
    public ResponseEntity<Serie> encontrarSeriePeloId( @PathVariable("id") Long id){
        Serie serie = serieService.encontrarSerie(id);
        return new ResponseEntity<>(serie, HttpStatus.OK); 
    }
	
	@PostMapping
	@Transactional
	public ResponseEntity<Serie> cadastrar(@RequestBody SerieForm form, UriComponentsBuilder uriBuilder) {
		Serie serie = form.converterParaSerie();
		serieService.salvarSerie(serie);
		
		return new ResponseEntity<>(serie, HttpStatus.OK);
	}
}
