package com.jordan.obspringresdatajpa.Repository;

import com.jordan.obspringresdatajpa.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
