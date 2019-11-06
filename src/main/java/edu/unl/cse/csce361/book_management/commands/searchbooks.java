package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.Book;

import java.util.ArrayList;

public class searchbooks implements Two_ParameterCommand {
    @Override
    public void execute(String author, String title,ArrayList<Book> bookArrayList) {
        for (Book book:bookArrayList
        ) {

            if (book.getAuthor().equals(author)||book.getTitle().equals(title)){
               if (book.getStatus().equals("Shelved")){
                   System.out.println("This book is available");
               }else if (book.getStatus().equals("Checked Out")){
                   System.out.println("The On Hold List is"+book.getStringArrayList());
                   System.out.println("CallNumber "+book.getCallNumber());
               }


            }

        }
    }

    @Override
    public String toString(String string) {
        return null;
    }
}
