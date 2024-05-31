package tech.biblioteca.Biblioteca.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_users")
public class User implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank
private String firstName;
@NotBlank
private String lastName;
@NotBlank
@Column(unique = true)
private String document;
@NotBlank
@Column(unique = true)
private String email;

public User() {
	
}



public User(Long id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String document,
		@NotBlank String email) {
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



@Override
public int hashCode() {
	return Objects.hash(id);
}




@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(id, other.id);
}







}
