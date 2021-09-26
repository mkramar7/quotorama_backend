package hr.odysseydigital.quotorama.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.odysseydigital.quotorama.model.Quote;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;

@Service
public class QuotesService {
    private static final List<Quote> quotes = getQuotesList();

    private static List<Quote> getQuotesList() {
        try {
            ClassPathResource jsonFileResource = new ClassPathResource("static/quotes.json");
            return new ObjectMapper()
                    .readValue(jsonFileResource.getInputStream(), new TypeReference<List<Quote>>() {});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Quote findRandomQuote() {
        if (quotes == null) {
            return null;
        }

        return quotes.get(new Random().nextInt(quotes.size()));
    }
}
