package com.jordan.obspringresdatajpa.Controller;

import com.jordan.obspringresdatajpa.Entities.Book;
import com.jordan.obspringresdatajpa.Repository.BookRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.jfr.Description;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@Api(description = "CRUD", tags = "Books")
public class BookController {

    //Este log nos permite mostrar los errores más descrito e incluso nos muestra la hora
   // private final Logger log = (Logger) LoggerFactory.getLogger(BookController.class);

    //Atributos
    private BookRepository bookRepository;

    //Constructores

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;

    }


    //Metodos

                    //CRUD(Create, Replace, Update, Delete) sobre la entidad Book

    //
    @Value("${app.message}")
    String message;

    /**
     * Buscar todos los libros en la db
     * http://localhost:4580/api/books
     * @return
     */
    @GetMapping("/api/books")
    @ApiOperation(value = "Buscar todos los Libros (FindAll)")
    public List<Book> findAll(){
        System.out.println(message);
        //Recuperar y devolver los libros de la db
       return bookRepository.findAll();

    }

    //

    /**
     * Buscar un solo libro en la db según su ID
     * Request = Petición
     * Response = Respuesta
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){ //El ResponseEntity<Book> me sirve para
        // devolver codigo de estado http.

        //Este optional me valida si el ID pasado existe o no existe.
        Optional<Book> optional = bookRepository.findById(id);

        //FORMA CORTA
        //return optional.orElse(null); //Comprobar si hay libros y si hay me muestra el valor o  si no hay ne retorna nulo.
        //FORMA LARGA
       if (optional.isPresent()){ //Comprobar si hay libros o no
           return ResponseEntity.ok(optional.get());
       } else {
           return ResponseEntity.notFound().build();

       }

       //FORMA CORTA UTILIZANDO EL ResponseEntity<Book>
       // return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crear un nuevo libro en la db
     * Metodo POST
     * @param book
     * @param headers
     * @return
     */
    @PostMapping("/api/books")
    public ResponseEntity<Book>  create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent")); //Esto es para saber quien es el que nos envia datos
        if (book.getId() != null){ //quiere decir que existe el id y por tanto no es una creación
            return ResponseEntity.badRequest().build();
        }
        //Guardar el libro recibido al parametro
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar un libro
     * @param book
     * @return
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        Optional<Book> opt = bookRepository.findById(book.getId());
        if (opt.isPresent()){
            Book result = bookRepository.save(book);
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    //Borrar un libro en db

    /**
     * Eliminar un libro
     * @param id
     * @return
     */
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        Optional<Book> op = bookRepository.findById(id); // Me valida si el id pasado esta o no
        if (op.isPresent()){
           bookRepository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todos los libros
     * @return
     */
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        Long resultAll = bookRepository.count();
        if (resultAll > 0 ){
            bookRepository.deleteAll();
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    /*
    //Estas son pruebas para saber si funcionaba.
    @GetMapping("/saludo")
    public String saludo(){
        return "Hola, desde el controlador de Book....";
    }*/

    /*
    @GetMapping("/boostrap")
    public String bootstrap(){
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Bootstrap demo</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
                  </head>
                  <body>
                    <h1>Hola Mundo desde Spring Boot!</h1>
                    <a class="btn btn-primary" href="https://www.google.es"> Google </a>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
                  </body>
                </html>
                """;
    }*/


}
