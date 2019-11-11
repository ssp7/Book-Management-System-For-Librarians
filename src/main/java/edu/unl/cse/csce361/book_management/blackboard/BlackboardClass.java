package edu.unl.cse.csce361.book_management.blackboard;

import java.util.Observable;

public class BlackboardClass extends Observable {
    static Librarian librarian = new Librarian();
    static Patron patron = new Patron();
    /*
    Read the Author name, Summary of book,
    amount of copies of book from user.
     */
    public void addBookAsLibrarian() {
        Librarian.addBookAsLibrarian();
        setChanged();
        notifyObservers(patron);
    }
    public static void searchBookbyAuthorOrTitle() {
        Patron.searchBookbyAuthorOrTitle();
    }
    public  void removeBookAsLibrarian() {
        Librarian.removeBookAsLibrarian();
        setChanged();
        notifyObservers();
    }
    public void addBookToCartAsPatron() {
        Patron.addBookToCartAsPatron();
        setChanged();
        notifyObservers(librarian);

    }
    public static void printCatalog() {
        Librarian.printCatalog();
    }
    public void updateBookInfo() {
        Librarian.updateBookInfo();
        setChanged();
        notifyObservers(patron);
    }
    public void PlaceBooksOnHoldAsPatron() {
    	Patron.PlaceBookOnHoldAsPatron();
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
    	Patron.printBooksInCart();
    }
    public void PrintPatronInfo() {
    	Patron.PrintPatronInfo();
    }
    
    public void PrintAllPatronsInfo() {
    	librarian.printPatrons();
    }
    public void PrintSpecificPatronInfo() {
    	librarian.printSpecificPatronInfo();
    }
  
}

