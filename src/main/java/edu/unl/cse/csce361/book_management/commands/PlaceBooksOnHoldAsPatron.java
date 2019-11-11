package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class PlaceBooksOnHoldAsPatron implements Command{
   BlackboardClass blackboard = new BlackboardClass();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		blackboard.PlaceBooksOnHoldAsPatron();
	}
	
	@Override
	public String toString() {
		return "Place any book on hold as a Patron";
		
	}

}
