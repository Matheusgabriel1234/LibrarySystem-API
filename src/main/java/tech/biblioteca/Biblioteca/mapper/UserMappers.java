package tech.biblioteca.Biblioteca.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import tech.biblioteca.Biblioteca.DTO.UserCreateDTO;
import tech.biblioteca.Biblioteca.DTO.UserDTO;
import tech.biblioteca.Biblioteca.entities.User;

@Mapper
public interface UserMappers {
UserMappers instance = Mappers.getMapper(UserMappers.class);

UserDTO UserToDto(User user);
User dtoToUser(UserDTO userDto);
User userCreateDTOtoUser(UserCreateDTO userCreateDto);

}
