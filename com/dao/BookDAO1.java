package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.connection.MyConnection;
import com.pojo.Employee;

public class BookDAO1 implements BookDAO {

	@Override
	public boolean addBook(Book book) {
		String INSERT_BOOK="insert into Book values(?,?,?,?)";
		Boolean flag=true;
		
		try {
			PreparedStatement ps= MyConnection.getMyConnection().prepareStatement(INSERT_BOOK);
			
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getName());
			ps.setString(3, book.getPublication());
			ps.setString(4, book.getAuthor());
			
			flag=ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		// TODO Auto-generated method stub
	}

	@Override
	public int updateBook(Book book, String ISBN) {
		int r=0;
		String UPDATE_BOOK="update Book set name=?,publication=?,author=? where isbn=?";
		
		try {
			PreparedStatement ps=MyConnection.getMyConnection().prepareStatement(UPDATE_BOOK);
			ps.setString(1, book.getName());
			ps.setString(2, book.getPublication());
			ps.setString(3, book.getAuthor());
			ps.setString(4,book.getIsbn());
			r=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public int deleteBook(String ISBN) {
		// TODO Auto-generated method stub
		int r=0;
		String DELETE_BOOK ="delete from Book where isbn=?";
		
		try {
			PreparedStatement ps=MyConnection.getMyConnection().prepareStatement(DELETE_BOOK);
			ps.setString(1, ISBN);
			r=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Book findBookByISBN(String ISBN) {
		// TODO Auto-generated method stub
		Book book=new Book();
		String FIND_BY_ID="select * from Book where isbn=?";
		
		try {
			PreparedStatement ps=MyConnection.getMyConnection().prepareStatement(FIND_BY_ID);
			ps.setString(1, ISBN);
			
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				book=new Book(ISBN,set.getString("name"),set.getString("publication"),set.getString("author"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> findBooksByName(String name) {
		// TODO Auto-generated method stub
		List<Book> books= new ArrayList<Book>();
		Book book=new Book();
		String FIND_BOOKS_BY_NAME="select * from Book where name=?";
		
		try {
			PreparedStatement ps=MyConnection.getMyConnection().prepareStatement(FIND_BOOKS_BY_NAME);
			ps.setString(1, name);
			
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				book=new Book(set.getString("isbn"),set.getString("name"),set.getString("publication"),set.getString("author"));
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}

	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books= new ArrayList<Book>();
		Book book=new Book();
		String FIND_BOOKS="select * from Book";
		
		try {
			PreparedStatement ps=MyConnection.getMyConnection().prepareStatement(FIND_BOOKS);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				book=new Book(set.getString("isbn"),set.getString("name"),set.getString("publication"),set.getString("author"));
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}

	@Override
	public List<Book> findBooksByAuthor(String auth_name) {
		// TODO Auto-generated method stub
		List<Book> books= new ArrayList<Book>();
		Book book=new Book();
		String FIND_BOOKS_BY_AUTHOR="select * from Book where author=?";
		
		try {
			PreparedStatement ps=MyConnection.getMyConnection().prepareStatement(FIND_BOOKS_BY_AUTHOR);
			ps.setString(1, auth_name);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				book=new Book(set.getString("isbn"),set.getString("name"),set.getString("publication"),set.getString("author"));
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}

}
