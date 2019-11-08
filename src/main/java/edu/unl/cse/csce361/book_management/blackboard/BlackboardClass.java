package edu.unl.cse.csce361.book_management.blackboard;

import java.util.Observable;
import java.util.Set;

    public class BlackboardClass extends Observable {
	static Librarian librarian = new Librarian();
    static Patron patron = new Patron();
/*   
Read the Author name, Summary of book,
amount of copies of book from user.
 */
    public void addBookAsLibrarian() {
        librarian.addBookAsLibrarian();
        setChanged();
        notifyObservers("A new book is added to catalog");

    }
    
    public static void searchBookbyAuthorOrTitle() {
      patron.searchBookbyAuthorOrTitle();

    }
    public  void removeBookAsLibrarian() {
      librarian.removeBookAsLibrarian();
      setChanged();

      notifyObservers("A book has been removed from the catelog");

    }
    
    public void addBookToCartAsPatron() {
      patron.addBookToCartAsPatron();
      setChanged();
      notifyObservers("A patron added a book to the cart");
    }
    
    public static void printCatalog() {
      librarian.printCatalog();
    }
    public void updateBookInfo() {
    	librarian.updateBookInfo();
    	setChanged();
    	notifyObservers("A book is updated with correct information");
    	
    }
}

