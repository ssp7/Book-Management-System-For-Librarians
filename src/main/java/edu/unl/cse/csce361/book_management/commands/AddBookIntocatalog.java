package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.Book;

import java.util.ArrayList;

public class AddBookIntocatalog implements OneParameter_Command {

    @Override
    public void execute(Book book, ArrayList<Book> bookArrayList) {
        bookArrayList.add(book);
    }

    @Override
    public String toString(String string) {
        return "Add Book Into Catalog";
    }
}
