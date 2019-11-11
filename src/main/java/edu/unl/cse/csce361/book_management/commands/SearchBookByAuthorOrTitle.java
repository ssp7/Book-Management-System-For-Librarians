package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class SearchBookByAuthorOrTitle implements Command{
 BlackboardClass blackboard = new BlackboardClass();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		BlackboardClass.searchBookbyAuthorOrTitle();
	}
   
	@Override
	public String toString() {
		
	return "As a patron search book by author or a title";
	}
}
