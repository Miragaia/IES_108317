package com.example.springbootcrudexample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "quote")
public class Quote {

    private String avaliacao;
    private long id;
    private Movie order;

    public Quote() {}

    public Quote(String quote, Movie movieById) {
        this.avaliacao=quote;
        this.order= movieById;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "avaliacao", nullable = false)
    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    public Movie getOrder() {
        return order;
    }
    public void setOrder(Movie order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Quote: id" + id + ", quote " + avaliacao + ", Movie " + order;
    }


}