package tech.biblioteca.Biblioteca.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.biblioteca.Biblioteca.entities.Book;
import tech.biblioteca.Biblioteca.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

private final BookService BookService;

public BookController(BookService BookService) {
this.BookService = BookService;
}




@PostMapping
public ResponseEntity<List<Book>> create(@RequestBody @Valid Book Book){
return ResponseEntity.status(HttpStatus.CREATED).body(BookService.create(Book));
}

@GetMapping
public List<Book> getAll(){
return BookService.getAll();
}

@GetMapping("/{id}")
public ResponseEntity<Book> getByid(@PathVariable Long id){
Book obj = BookService.getById(id);
return ResponseEntity.ok().body(obj);
}

}
