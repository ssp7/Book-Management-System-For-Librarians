package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.CLI;
import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class AddBookAsLibrarian implements Command {
	BlackboardClass blackboard = new BlackboardClass();
	 
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		blackboard.addBookAsLibrarian();
	    
	}
	
	@Override
	public String toString() {
		return "Add a Book as Librarian";
		
	}

	
}
