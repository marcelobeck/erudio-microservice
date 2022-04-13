package br.com.erudio.controller;

import br.com.erudio.model.Book;
import br.com.erudio.proxy.CambioProxy;
import br.com.erudio.repository.BookRepository;
import br.com.erudio.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy proxy;

    //http://localhost:8000/book-service/1/BRL
    @GetMapping(value = "/{id}/{currency}")
        public Book findBook(
                @PathVariable("id") Long id,
                @PathVariable("currency") String currency
    ){
        var book = bookRepository.getById(id);
        if (book == null) throw new RuntimeException("Book not Found");

       var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port + "FEIGN");
        book.setPrice(cambio.getConvertedValue());

        return book;
    }

    /*
    //http://localhost:8000/book-service/1/BRL
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ){
        var book = bookRepository.getById(id);
        if (book == null) throw new RuntimeException("Book not Found");

        HashMap<String, String> params = new HashMap<>();
        // Setar os parametros do book
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate() // Recuperando o Cambio
                .getForEntity("http://localhost:8000/cambio-service/"
                                + "{amount}/{from}/{to}",
                        Cambio.class,
                        params);

        var cambio = response.getBody();

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port);
        book.setPrice(cambio.getConvertedValue());

        return book;
    }
*/
}
