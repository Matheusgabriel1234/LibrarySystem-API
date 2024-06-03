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
import tech.biblioteca.Biblioteca.entities.Author;
import tech.biblioteca.Biblioteca.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

private final AuthorService AuthorService;

public AuthorController(AuthorService AuthorService) {
this.AuthorService = AuthorService;
}




@PostMapping
public ResponseEntity<List<Author>> create(@RequestBody @Valid Author Author){
return ResponseEntity.status(HttpStatus.CREATED).body(AuthorService.create(Author));
}

@GetMapping
public List<Author> getAll(){
return AuthorService.getAll();
}

@GetMapping("/{id}")
public ResponseEntity<Author> getByid(@PathVariable Long id){
Author obj = AuthorService.getById(id);
return ResponseEntity.ok().body(obj);
}

}
