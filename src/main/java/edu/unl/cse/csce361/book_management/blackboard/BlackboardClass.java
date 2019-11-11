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
        notifyObservers(patron);
    }
    public static void searchBookbyAuthorOrTitle() {
        patron.searchBookbyAuthorOrTitle();
    }
    public  void removeBookAsLibrarian() {
        librarian.removeBookAsLibrarian();
        setChanged();
        notifyObservers();
    }
    public void addBookToCartAsPatron() {
        patron.addBookToCartAsPatron();
        setChanged();
        notifyObservers(librarian);

    }
    public static void printCatalog() {
        librarian.printCatalog();
    }
    public void updateBookInfo() {
        librarian.updateBookInfo();
        setChanged();
        notifyObservers(patron);
    }
    public void PlaceBooksOnHoldAsPatron() {
    	patron.PlaceBookOnHoldAsPatron();
    	setChanged();
    	notifyObservers(librarian);
    }
    public void ViewHoldList(){
        librarian.ViewHoldList();
        setChanged();
        notifyObservers(librarian);
    }
    public void manipulateHoldList(){
        librarian.manipulateHoldList();
        setChanged();
        notifyObservers(librarian);
    }
    public void PrintBooksFromCart() {
    	patron.printBooksInCart();
    }
    public void PrintPatronInfo() {
    	patron.PrintPatronInfo();
    }
    
    public void PrintAllPatronsInfo() {
    	librarian.printPatrons();
    }
    public void PrintSpecificPatronInfo() {
    	librarian.printSpecificPatronInfo();
    }
  
}

