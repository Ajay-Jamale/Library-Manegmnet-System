package com.ajay.service.impl;

import org.springframework.stereotype.Service;

import com.ajay.model.Genre;
import com.ajay.payload.dto.GenreDTO;
import com.ajay.repository.GenreRepository;
import com.ajay.service.GenreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {

        Genre genre = Genre.builder()
                .code(genreDTO.getCode())
                .name(genreDTO.getName())
                .description(genreDTO.getDescription())
                .displayOrder(genreDTO.getDisplayOrder())
                .active(true)
                .build();

        // Set parent genre if provided
        if (genreDTO.getParentGenreId() != null) {
            Genre parentGenre = genreRepository.findById(genreDTO.getParentGenreId())
                    .orElseThrow(() -> new RuntimeException("Parent Genre not found"));
            genre.setParentGenra(parentGenre); 
        }

        Genre savedGenre = genreRepository.save(genre);

        return mapToDTO(savedGenre);
    }

    private GenreDTO mapToDTO(Genre genre) {

        GenreDTO dto = GenreDTO.builder()
                .id(genre.getId())
                .code(genre.getCode())
                .name(genre.getName())
                .description(genre.getDescription())
                .displayOrder(genre.getDisplayOrder())
                .active(genre.getActive())
                .createdAt(genre.getCreatedAt())
                .updatedAt(genre.getUpdatedAt())
                .build();

        if (genre.getParentGenra() != null) {
            dto.setParentGenreId(genre.getParentGenra().getId());
            dto.setParentGenreName(genre.getParentGenra().getName());
        }

        return dto;
    }
}
