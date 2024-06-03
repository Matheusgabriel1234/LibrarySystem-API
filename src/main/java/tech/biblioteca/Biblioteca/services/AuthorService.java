package tech.biblioteca.Biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tech.biblioteca.Biblioteca.entities.Author;
import tech.biblioteca.Biblioteca.repositories.AuthorRepository;

@Service
public class AuthorService {

private AuthorRepository AuthorRepository;

public AuthorService(AuthorRepository AuthorRepository) {
this.AuthorRepository = AuthorRepository;
}

public List<Author> getAll(){
return AuthorRepository.findAll();	
}

public Author getById(Long Id) {
Optional<Author> obj = AuthorRepository.findById(Id);
return obj.orElse(null);	
}


public List<Author> create(Author Author){
AuthorRepository.save(Author);
return getAll();
}

public List<Author> update(Author Author){
AuthorRepository.save(Author);
return getAll();
}

public List<Author> delete(Long id){
AuthorRepository.deleteById(id);
return getAll();
}


}
