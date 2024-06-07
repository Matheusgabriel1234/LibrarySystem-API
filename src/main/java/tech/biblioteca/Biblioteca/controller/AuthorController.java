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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.biblioteca.Biblioteca.entities.Author;
import tech.biblioteca.Biblioteca.exceptions.ObjectNotFound;
import tech.biblioteca.Biblioteca.services.AuthorService;


@RestController 
@RequestMapping("/authors")
public class AuthorController {

private final AuthorService authorService;

public AuthorController(AuthorService authorService) {
this.authorService = authorService;
}




@PostMapping
public ResponseEntity<List<Author>> create(@RequestBody @Valid Author Author){
return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(Author));
}

@GetMapping
public List<Author> getAll(){
return authorService.getAll();
}

@GetMapping("/{id}")
public ResponseEntity<Author> getByid(@PathVariable Long id){
Author obj = authorService.getById(id);
if(obj == null) {
	throw new ObjectNotFound("User not find with the id: " + id);
}
return ResponseEntity.ok().body(obj);
}

@DeleteMapping("/{id}")
public List<Author> delete(@PathVariable Long id){
List<Author> obj = authorService.delete(id);
if(obj == null) {
	throw new ObjectNotFound("User not find with the id: " + id);
}
return obj;
}

@PutMapping
public List<Author> update(@RequestBody Author Author){
return authorService.update(Author);	
}

}
