package com.dao;

import java.util.List;

import com.beans.Book;

public interface BookDAO {
	boolean addBook(Book book);
	int updateBook (Book book,String ISBN);
	int deleteBook (String ISBN);
	Book findBookByISBN(String ISBN);
	List<Book>findBooksByName(String name);
	List<Book>findAllBooks();
	List<Book>findBooksByAuthor(String auth_name);
}
