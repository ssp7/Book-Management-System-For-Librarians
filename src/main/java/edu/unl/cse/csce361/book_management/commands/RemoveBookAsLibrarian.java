package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class RemoveBookAsLibrarian implements Command{
    BlackboardClass blackboard = new BlackboardClass();
    
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		blackboard.removeBookAsLibrarian();
	}
    @Override 
    public String toString() {
    	return "Remove a book as a Librarian";
    }
}
