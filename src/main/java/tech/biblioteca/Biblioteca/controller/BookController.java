package tech.biblioteca.Biblioteca.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.biblioteca.Biblioteca.entities.Book;
import tech.biblioteca.Biblioteca.entities.User;

import tech.biblioteca.Biblioteca.services.BookService;
import tech.biblioteca.Biblioteca.services.UserService;

@RestController
@RequestMapping("/books")
public class BookController {

private final BookService bookService;

public BookController(BookService bookService) {
this.bookService = bookService;
}




@PostMapping
public ResponseEntity<List<Book>> create(@RequestBody @Valid Book Book){
return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(Book));
}

@GetMapping
public List<Book> getAll(){
return bookService.getAll();
}

@GetMapping("/{id}")
public ResponseEntity<Book> getByid(@PathVariable Long id){
Book obj = bookService.getById(id);
return ResponseEntity.ok().body(obj);
}

@DeleteMapping("/{id}")
public List<Book> delete(@PathVariable Long id){
List<Book> obj = bookService.delete(id);
return obj;
}

@PutMapping
public List<Book> update(@RequestBody Book book){
return bookService.update(book);	
}


}
