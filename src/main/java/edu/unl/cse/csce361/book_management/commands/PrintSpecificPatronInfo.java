package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class PrintSpecificPatronInfo implements Command {
BlackboardClass blackboard = new BlackboardClass();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		blackboard.PrintSpecificPatronInfo();
	}

	@Override
	public String toString() {
		return "As Librarian see any patron's info by entering their name";
	}
}
