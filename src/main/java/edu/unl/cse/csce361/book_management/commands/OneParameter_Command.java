package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.Book;

import java.util.ArrayList;

public interface OneParameter_Command  {
    void execute(Book book, ArrayList<Book> bookArrayList);
    String toString(String string);
}
