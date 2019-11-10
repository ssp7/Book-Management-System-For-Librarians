package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class PrintBooksFromCart implements Command{
	BlackboardClass blackboard = new BlackboardClass();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
	
		blackboard.printBooksInCart();
	}
 
	@Override
	public String toString() {
		return "See all your books in cart";
	}
}
