package com.example.springbootcrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.example.springbootcrudexample.model.*;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByMovie(Movie m);
}
