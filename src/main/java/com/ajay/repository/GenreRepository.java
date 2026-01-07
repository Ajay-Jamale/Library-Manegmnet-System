package com.ajay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
