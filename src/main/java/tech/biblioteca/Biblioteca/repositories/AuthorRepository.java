package tech.biblioteca.Biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.biblioteca.Biblioteca.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
