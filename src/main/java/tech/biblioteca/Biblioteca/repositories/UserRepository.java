package tech.biblioteca.Biblioteca.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.biblioteca.Biblioteca.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

public Optional<List<User>> findByFirstName(String firstName); 
}
