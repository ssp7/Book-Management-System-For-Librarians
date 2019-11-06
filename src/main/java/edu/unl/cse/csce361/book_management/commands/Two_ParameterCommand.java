package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.Book;

import java.util.ArrayList;

public interface Two_ParameterCommand {
            void execute(String string, String s, ArrayList<Book> bookArrayList);
            String toString(String string);

}
