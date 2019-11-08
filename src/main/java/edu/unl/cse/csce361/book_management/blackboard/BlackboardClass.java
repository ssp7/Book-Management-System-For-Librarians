package edu.unl.cse.csce361.book_management.blackboard;

import java.nio.file.attribute.AclEntry.Builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Scanner;

public class BlackboardClass extends Observable {
	static Librarian librarian = new Librarian();
    static Patron patron = new Patron();
/*   
Read the Author name, Summary of book,
amount of copies of book from user.
 */
    public void addBookAsLibrarian() {
        librarian.addBookAsLibrarian();
        notifyObservers(patron);
    }
    public static void searchBookbyAuthorOrTitle() {
      patron.searchBookbyAuthorOrTitle();

    }
    public  void removeBookAsLibrarian() {
      librarian.removeBookAsLibrarian();
      notifyObservers();
    }
    public void addBookToCartAsPatron() {
      patron.addBookToCartAsPatron();
      notifyObservers(librarian);
        
    }
    public static void printCatalog() {
      librarian.printCatalog();
    }

}

