package com.example.springbootcrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.example.springbootcrudexample.model.*;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
}