package com.jordan.obspringresdatajpa.Controller;

import com.jordan.obspringresdatajpa.Entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate; //Es un cliente HTTP y sincrono para permitir conexiones HTTP y acceso HTTP
    @Autowired //Con esto le indicamos que nos inyecte el ResTemplateBuilder
    private RestTemplateBuilder restTemplateBuilder;   //Nos permite construir el anterior (TestRestTemplate)
    @LocalServerPort //Le indicamos que nos inyecte el puerto.
    private int port;
    //Esto nos indica que se ejecuta antes de cad método
    @BeforeEach
    void setUp() {
        this.restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        this.testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    void findAll() {

        //Configuración
       ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/books", Book[].class);

       //Vamos a validar si el resultado es OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //Convirtiendo de un Array a un ArrayList
        List<Book> book = Arrays.asList(response.getBody());
        System.out.println(book.size());
        assertTrue(book.size() > 0);

    }

    @Test
    void findOneById() {

        ResponseEntity<Book> response = testRestTemplate.getForEntity("/api/books/5", Book.class);

        //Comprobación en caso que encuentre el libro
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //Comprobación en caso que no encuentre el libro
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @Test
    void create() {

        //Cabeceras =
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "Libro Creado desde Spring Test",
                    "author": "Bichos",
                    "pages": 188,
                    "price": 201567.0,
                    "releaseDate": "2019-10-22",
                    "onLine": true
                }
                """;

        //le vamos a pasar los headers y el json que hemos creado
        HttpEntity<String> stringHttpEntity = new HttpEntity<>(json, headers);
        ResponseEntity<Book> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, stringHttpEntity, Book.class);

        Book result = response.getBody();

        assertEquals(7L, result.getId()); //Comprobamos si el ID es el correcto, pero es cuando conocemos el ID
        assertEquals("Libro Creado desde Spring Test", result.getTitle()); //Comprobamos si el libro creado es igual al que escribimos


    }
}