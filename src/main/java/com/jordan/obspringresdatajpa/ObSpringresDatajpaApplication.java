package com.jordan.obspringresdatajpa;

import com.jordan.obspringresdatajpa.Entities.Book;
import com.jordan.obspringresdatajpa.Repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class ObSpringresDatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObSpringresDatajpaApplication.class, args);


		/*
		Scanner read = new Scanner(System.in);

		System.out.println("Escoge una opción a realizar: \n1. Crear libro y Almacenar\n2. Recuperar todos los libros" +
				"\n3. Borrar un libro\n4. Borrar todos los libros");
		int option = read.nextInt();

		//CRUD (Crate, Replace, Update, Delete)

		switch (option){

			case 1:
				//Crear un libro
				Book book = new Book();
				System.out.println("Ingrese el título del libro: ");
				String title = read.next();
				book.setTitle(title);
				System.out.println("Ingrese el autor del libro: ");
				String author = read.next();
				book.setAuthor(author);
				System.out.println("Ingrese las páginas del libro: ");
				int pages = read.nextInt();
				book.setPages(pages);
				System.out.println("Ingrese el precio del libro: ");
				double price = read.nextDouble();
				book.setPrice(price);
				System.out.println("Ingrese la fecha de lanzamiento del libro: \n Tener en cuenta poner las fecha en número");
				System.out.println("Año: ");
				int year = read.nextInt();
				System.out.println("Mes: ");
				int moth = read.nextInt();
				System.out.println("Día: ");
				int day = read.nextInt();
				book.setReleaseDate(LocalDate.of(year,moth,day));
				System.out.println("Estado del libro: ");
				Boolean status = read.nextBoolean();
				book.setOnLine(status);

				//Almacenar un libro
				bookRepository.save(book);
				System.out.println("¡Registro almacenado exitosamente!");
				break;

			case 2:
				//Buscar todos los libros
				System.out.println("*********** Los registros guardados en la base de datos son ***********");
				for (Book data : bookRepository.findAll()){
					System.out.println(data);
				}

				break;

			case 3:
				//Borrar un libro
				System.out.println("Ingrese el ID del libro a borrar: ");
				Long id = read.nextLong();
				if (bookRepository.existsById(id)){
					bookRepository.deleteById(id);
					System.out.println("!Libro borrado existosamente¡");

				}else {
					System.out.println("El ID ingresado no existe");
				}

				break;

			case 4:
				//Borrar todos los libros almacenados
				System.out.println("¿Estas seguro de borrar todos los datos de la tabla libro? \n1. Si\n2. No");
				int op = read.nextInt();
				switch (op){
					case 1:
						bookRepository.deleteAll();
						System.out.println("Se han borrado todos los datos de la tabla");
						break;
					case 2:
						System.out.println("Acción declinada");
				}

				break;

			default:
				System.out.println("La opción digitada no es correcta, lee bien las opciones");


		}*/


	}

}
