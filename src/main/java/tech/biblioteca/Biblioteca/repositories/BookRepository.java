package tech.biblioteca.Biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.biblioteca.Biblioteca.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
