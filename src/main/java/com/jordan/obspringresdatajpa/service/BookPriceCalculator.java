package com.jordan.obspringresdatajpa.service;

import com.jordan.obspringresdatajpa.Entities.Book;

public class BookPriceCalculator {

    //DECLARACIÓN DE CONSTANTES
    private static final double PAGES_BOOK = 80;
    private static final double PRICE_BOOK = 8000;

    //Método que me calcula el precio del libro según sus páginas si son payor a 80 paginas, le suma 8000 pesos
    public double price(Book book){
        double price = book.getPrice();

            if(book.getPages() > PAGES_BOOK){

            price = price + PRICE_BOOK;
        }
            //Costo del envio si queremos sobrarlo
        price += 15000;

        return price;

    }
}
