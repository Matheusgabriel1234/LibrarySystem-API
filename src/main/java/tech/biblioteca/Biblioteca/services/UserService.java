package tech.biblioteca.Biblioteca.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import tech.biblioteca.Biblioteca.DTO.UserCreateDTO;
import tech.biblioteca.Biblioteca.DTO.UserDTO;
import tech.biblioteca.Biblioteca.entities.User;
import tech.biblioteca.Biblioteca.mapper.UserMappers;
import tech.biblioteca.Biblioteca.repositories.UserRepository;

@Service
public class UserService {

private UserRepository userRepository;

public UserService(UserRepository userRepository) {
this.userRepository = userRepository;
}

public List<UserDTO> getAll(){
return userRepository.findAll().stream().map(UserMappers.instance::UserToDto).collect(Collectors.toList());
}

public UserDTO getById(Long Id) {
return userRepository.findById(Id).map(UserMappers.instance::UserToDto).orElse(null);
}

public List<UserDTO> getByFirstName(String fistName){
List<User> user = userRepository.findByFirstName(fistName);
return user.stream().map(UserMappers.instance::UserToDto).collect(Collectors.toList());
}

public UserDTO create(UserCreateDTO userdto){
User user = UserMappers.instance.userCreateDTOtoUser(userdto);
User savdedUser = userRepository.save(user);
return UserMappers.instance.UserToDto(savdedUser);


}

public UserDTO update(Long id,UserCreateDTO userDto){
Optional<User> existingUser = userRepository.findById(id);
if(existingUser.isPresent()) {
User user = UserMappers.instance.userCreateDTOtoUser(userDto);
user.setId(id);
User updateUser = userRepository.save(user);
return UserMappers.instance.UserToDto(updateUser);
}else {
	return null;
}
}

public List<UserDTO> delete(Long id){
userRepository.deleteById(id);
return getAll();
}


}
