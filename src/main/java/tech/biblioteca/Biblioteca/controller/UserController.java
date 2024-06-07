package tech.biblioteca.Biblioteca.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.hibernate.ObjectNotFoundException;
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
import tech.biblioteca.Biblioteca.DTO.UserCreateDTO;
import tech.biblioteca.Biblioteca.DTO.UserDTO;
import tech.biblioteca.Biblioteca.entities.User;
import tech.biblioteca.Biblioteca.exceptions.ObjectNotFound;
import tech.biblioteca.Biblioteca.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

private final UserService userService;

public UserController(UserService userService) {
this.userService = userService;
}




@PostMapping
public ResponseEntity<UserDTO> create(@RequestBody @Valid UserCreateDTO user){
return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
}

@GetMapping
public ResponseEntity<List<UserDTO>> getAll(){
	List<UserDTO> user = userService.getAll();
	return new ResponseEntity<>(user,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<UserDTO> getByid(@PathVariable Long id){
UserDTO obj = userService.getById(id);
if(obj == null) {
	throw new ObjectNotFound("User not find with the id " + id);
}
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@DeleteMapping("/{id}")
public List<UserDTO> deleteById(@PathVariable Long id){
	List<UserDTO> obj = userService.delete(id);
	if(obj == null) {
		throw new ObjectNotFound("User not find with the id: " + id);
	}
	return obj;
}

@PutMapping("/{id}")
public ResponseEntity<UserDTO> update(@PathVariable Long id,@RequestBody UserCreateDTO user){
UserDTO newUser = userService.update(id,user);
if(newUser == null) {
	throw new ObjectNotFound("User not find with the id: " + id);
}
return new ResponseEntity<>(newUser,HttpStatus.CREATED) ;
}

@GetMapping("/firstname/{firstName}")
public ResponseEntity<List<UserDTO>> getUserbyfirstName(@PathVariable String firstName){
List<UserDTO> obj = userService.getByFirstName(firstName.toLowerCase());
if(obj.isEmpty()) {
	throw new ObjectNotFound("Firstname Not Found: " + firstName);
}
return new ResponseEntity<>(obj,HttpStatus.OK);
}

}
