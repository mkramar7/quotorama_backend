package hr.odysseydigital.quotorama.controller;

import hr.odysseydigital.quotorama.model.Quote;
import hr.odysseydigital.quotorama.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuotesService quotesService;

    @GetMapping("/random")
    public ResponseEntity<Quote> getRandomQuote() {
        return new ResponseEntity<>(quotesService.findRandomQuote(), HttpStatus.OK);
    }
}
