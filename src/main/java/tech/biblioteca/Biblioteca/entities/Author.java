package tech.biblioteca.Biblioteca.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_author")
public class Author implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;


@OneToMany(mappedBy = "author",cascade = CascadeType.ALL,orphanRemoval = true)
private List<Book> books;

public Author() {
	
}


public Author(Long id, String name, List<Book> books) {
	
	this.id = id;
	this.name = name;
	this.books = books;
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

public List<Book> getBooks() {
	return books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}





}
