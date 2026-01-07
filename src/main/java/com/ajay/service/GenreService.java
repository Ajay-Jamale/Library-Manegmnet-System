package com.ajay.service;

import com.ajay.model.Genre;
import com.ajay.payload.dto.GenreDTO;

public interface GenreService {
	GenreDTO createGenre(GenreDTO genre);
}
