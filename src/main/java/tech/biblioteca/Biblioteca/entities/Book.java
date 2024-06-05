package tech.biblioteca.Biblioteca.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
@ManyToOne
@JoinColumn(name = "author_id")
@JsonIgnore
private Author author;
private LocalDate realeaseDate;
private String categorie;

public Book() {
	
}



public Book(Long id, String name, Author author, LocalDate realeaseDate, String categorie) {
this.id = id;
this.name = name;
this.author = author;
this.realeaseDate = realeaseDate;
this.categorie = categorie;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Author getAuthor() {
	return author;
}

public void setAuthor(Author author) {
	this.author = author;
}


public LocalDate getRealeaseDate() {
	return realeaseDate;
}



public void setRealeaseDate(LocalDate realeaseDate) {
	this.realeaseDate = realeaseDate;
}



public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}


}
