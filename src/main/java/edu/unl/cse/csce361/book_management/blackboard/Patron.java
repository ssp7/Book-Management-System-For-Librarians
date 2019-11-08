package edu.unl.cse.csce361.book_management.blackboard;

import java.util.ArrayList;
import java.util.Date;

public class Patron {

	public String name;
	public Book bookInCart;
	public Book getBookInCart() {
		return bookInCart;
	}
	public void setBookInCart(Book bookInCart) {
		this.bookInCart = bookInCart;
	    booksInCart.add(this.bookInCart);
	}
	public ArrayList<Book> booksInCart;
	public ArrayList<Book> booksCheckedOut;
	public int date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Book> getBooksInCart() {
		return booksInCart;
	}
	public void setBooksInCart(ArrayList<Book> booksInCart) {
		this.booksInCart = booksInCart;
	}
	public ArrayList<Book> getBooksCheckedOut() {
		return booksCheckedOut;
	}
	public void setBooksCheckedOut(ArrayList<Book> booksCheckedOut) {
		this.booksCheckedOut = booksCheckedOut;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
  
}
