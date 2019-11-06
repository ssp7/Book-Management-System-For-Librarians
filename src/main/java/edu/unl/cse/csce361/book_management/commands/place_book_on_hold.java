package edu.unl.cse.csce361.book_management.commands;
import edu.unl.cse.csce361.book_management.blackboard.*;
import edu.unl.cse.csce361.book_management.Observer.*;

import java.util.ArrayList;

public class place_book_on_hold implements Two_ParameterCommand {
    @Override
    public void execute(String PatronName,String BookName,ArrayList<Book> bookArrayList) {
        for (Book book:bookArrayList
        ) {

            if (book.getTitle().equals(BookName)){
                book.DeletepatronOnHoldArrayList("Are you a troll in league of legend?");
                book.AddpatronOnHoldArrayList(PatronName);
                System.out.println(book.getStringArrayList());

            }

        }

    }

    @Override
    public String toString(String string) {
        return "You is on the hold list";
    }

}
