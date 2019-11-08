package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class UpdateBookInfoAsLibrarian implements Command
{
  BlackboardClass blackboard = new BlackboardClass();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		blackboard.updateBookInfo();
	}
	@Override
	public String toString() {
		return "Correct the book information as Librarian to replace author,title or call number";
	}

}
