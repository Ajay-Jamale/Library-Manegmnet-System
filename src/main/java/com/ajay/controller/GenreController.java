package com.ajay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ajay.model.Genre;
import com.ajay.payload.dto.GenreDTO;
import com.ajay.service.GenreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {

	private final GenreService genreService;

	

	@PostMapping("/create")
	public ResponseEntity<GenreDTO> createGenre( @RequestBody GenreDTO genreDTO) {
		GenreDTO createdGenre = genreService.createGenre(genreDTO);
		return ResponseEntity.ok(createdGenre);
	}

}
