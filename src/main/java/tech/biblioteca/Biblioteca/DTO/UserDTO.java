package tech.biblioteca.Biblioteca.DTO;

public class UserDTO {

	
public Long id;
public String firstName;
public String lastName;
public String document;
public String email;

public UserDTO(){
	
}







public UserDTO(Long id, String firstName, String lastName, String document, String email) {
	
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.document = document;
	this.email = email;
}







public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}







public void setLastName(String lastName) {
	this.lastName = lastName;
}







public String getDocument() {
	return document;
}
public void setDocument(String document) {
	this.document = document;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


	
	
	
	
	
	
	
	
	
}
