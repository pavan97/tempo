package com.beans;

public class Book {
	
	String isbn,name,publication,author;
	
	public Book () {
		isbn="";
		name="";
		publication="";
		author="";
	}

	public Book(String isbn, String name, String publication, String author) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.publication = publication;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
		
	}
}
