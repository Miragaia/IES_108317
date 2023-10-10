package com.example.restservice;

import javax.ws.rs.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteResource {

    // Simulated static data (replace with a real database later).
    private static final List<Quote> quotes = new ArrayList<>();

    static {
        quotes.add(new Quote(1, "Breaking Bad", "I am the one who knocks!"));
        quotes.add(new Quote(2, "Game of Thrones", "Winter is coming."));
        quotes.add(new Quote(3, "The Matrix", "There is no spoon."));
        quotes.add(new Quote(4, "The Lord of the Rings", "You shall not pass!"));
        quotes.add(new Quote(5, "The Dark Knight", "Why so serious?"));
        quotes.add(new Quote(6, "The Godfather", "I'm gonna make him an offer he can't refuse."));
        quotes.add(new Quote(7, "Forrest Gump", "My momma always said, \"Life was like a box of chocolates. You never know what you're gonna get.\""));
        quotes.add(new Quote(8, "The Shawshank Redemption", "Get busy living, or get busy dying."));
        quotes.add(new Quote(9, "The Shining", "Here's Johnny!"));
        quotes.add(new Quote(10, "The Terminator", "I'll be back."));
        quotes.add(new Quote(11, "The Big Lebowski", "That rug really tied the room together."));
        quotes.add(new Quote(12, "The Silence of the Lambs", "I ate his liver with some fava beans and a nice chianti."));
        quotes.add(new Quote(13, "The Sixth Sense", "I see dead people."));
        quotes.add(new Quote(14, "The Usual Suspects", "The greatest trick the devil ever pulled was convincing the world he didn't exist."));
        quotes.add(new Quote(15, "The Wizard of Oz", "Toto, I've got a feeling we're not in Kansas anymore."));
    }

    @GetMapping("/api/quote")
    public Quote getRandomQuote() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }

    @GetMapping("/api/shows")
    public List<String> getAllShows() {
        List<String> showList = new ArrayList<>();
        for (Quote quote : quotes) {
            if (!showList.contains(quote.getShow())) {
                showList.add(quote.getShow());
            }
        }
        return showList;
    }

    @GetMapping("/api/quotes")
    public List<Quote> getQuotesByShow(@RequestParam(name = "show") long showId) {
        List<Quote> showQuotes = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.getId() == showId) {
                showQuotes.add(quote);
            }
        }
        return showQuotes;
    }
}
