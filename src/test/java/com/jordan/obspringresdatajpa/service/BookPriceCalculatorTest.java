package com.jordan.obspringresdatajpa.service;

import com.jordan.obspringresdatajpa.Entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void priceTest() {
        //Instancia de mi clase Book
        Book book = new Book(9L,
                "El señor de los anillos",
                "Roberto Carlos",
                340,
                255450d,
                LocalDate.of(2012, 02, 25),
                true);
        //Instancio mi clase BookPriceCalculator
        BookPriceCalculator calculator = new BookPriceCalculator();
        //Ejecutamos el testing
        double resultPrice = calculator.price(book);
        System.out.println(resultPrice);
        //Comprobación de que todo esta bien (Aserciones)
        assertTrue(resultPrice > 0); //Evalución de si es verdadera o no
        assertEquals(278450.0d, resultPrice); //Colocamos el valor del resultado que se espera
                                                      // y validamos si es el mismo y si lo es, es TRUE

    }
}