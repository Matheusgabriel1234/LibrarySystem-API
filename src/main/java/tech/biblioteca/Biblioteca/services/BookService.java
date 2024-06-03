package tech.biblioteca.Biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tech.biblioteca.Biblioteca.entities.Book;
import tech.biblioteca.Biblioteca.repositories.BookRepository;

@Service
public class BookService {

private BookRepository BookRepository;

public BookService(BookRepository BookRepository) {
this.BookRepository = BookRepository;
}

public List<Book> getAll(){
return BookRepository.findAll();	
}

public Book getById(Long Id) {
Optional<Book> obj = BookRepository.findById(Id);
return obj.orElse(null);	
}


public List<Book> create(Book Book){
BookRepository.save(Book);
return getAll();
}

public List<Book> update(Book Book){
BookRepository.save(Book);
return getAll();
}

public List<Book> delete(Long id){
BookRepository.deleteById(id);
return getAll();
}


}
