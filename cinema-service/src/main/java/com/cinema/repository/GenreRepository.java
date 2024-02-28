package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
