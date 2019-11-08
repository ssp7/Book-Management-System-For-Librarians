package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.CLI;
import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class AddBookAsLibrarian implements Command {
	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		BlackboardClass.addBookAsLibrarian();
		
	}
	
	@Override
	public String toString() {
		return "Add a Book as Librarian";
		
	}
	
}
