package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Serie;

public interface SerieRepo extends JpaRepository<Serie, Long> {
	
	Optional<Serie> findSerieById(Long id);
}
