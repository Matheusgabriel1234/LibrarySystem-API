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
import tech.biblioteca.Biblioteca.entities.User;
import tech.biblioteca.Biblioteca.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

private final UserService userService;

public UserController(UserService userService) {
this.userService = userService;
}




@PostMapping
public ResponseEntity<List<User>> create(@RequestBody @Valid User user){
return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
}

@GetMapping
public List<User> getAll(){
return userService.getAll();
}

@GetMapping("/{id}")
public ResponseEntity<User> getByid(@PathVariable Long id){
User obj = userService.getById(id);
return ResponseEntity.ok().body(obj);
}

@DeleteMapping("/{id}")
public List<User> deleteById(@PathVariable Long id){
	List<User> obj = userService.delete(id);
	return obj;
}

@PutMapping
public List<User> update(@RequestBody User user){
	return userService.update(user);
}

}
