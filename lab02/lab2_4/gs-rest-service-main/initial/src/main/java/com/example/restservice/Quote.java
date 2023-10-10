package com.example.restservice;

public class Quote {
    private final int id;
    private final String show;
    private final String quote;


    public Quote(int id, String show, String quote) {
            this.id = id;
            this.show = show;
            this.quote = quote;
    }

    public int getId() {
            return id;
    }

    public String getShow() {
            return show;
    }

    public String getQuote() {
            return quote;
    }
}

