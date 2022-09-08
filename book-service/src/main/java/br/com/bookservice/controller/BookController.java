package br.com.bookservice.controller;

import br.com.bookservice.model.Book;
import br.com.bookservice.proxyes.CambioProxy;
import br.com.bookservice.resopitory.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("book-service")
@RequiredArgsConstructor
public class BookController {

    private final CambioProxy cambioProxy;

    private final BookRepository bookRepository;

    private final Environment environment;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){


        var book = bookRepository.getById(id);
        if(book == null){
            throw new RuntimeException("Book not found");
        }

       var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnviorment(port);
        book.setPrice(cambio.getConvertedValue().doubleValue());
        return book;

    }
}
