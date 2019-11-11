package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class AddBookToCartAsPatron implements Command {
   BlackboardClass blackboard = new BlackboardClass();
   
	@Override
	public void execute() {
		blackboard.addBookToCartAsPatron();
	}
	@Override
	public String toString() {
		return "Enter Book To your cart as a Patron";
	}

}
