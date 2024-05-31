package tech.biblioteca.Biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tech.biblioteca.Biblioteca.entities.User;
import tech.biblioteca.Biblioteca.repositories.UserRepository;

@Service
public class UserService {

private UserRepository userRepository;

public UserService(UserRepository userRepository) {
this.userRepository = userRepository;
}

public List<User> getAll(){
return userRepository.findAll();	
}

public User getById(Long Id) {
Optional<User> obj = userRepository.findById(Id);
return obj.orElse(null);	
}

public List<User> getByFirstName(String fistName){
Optional<List<User>> obj = userRepository.findByFirstName(fistName);
return obj.orElse(null);
}

public List<User> create(User user){
userRepository.save(user);
return getAll();
}

public List<User> update(User user){
userRepository.save(user);
return getAll();
}

public List<User> delete(Long id){
userRepository.deleteById(id);
return getAll();
}


}
