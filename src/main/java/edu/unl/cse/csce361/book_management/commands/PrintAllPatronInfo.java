package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class PrintAllPatronInfo implements Command {
BlackboardClass blackboard = new BlackboardClass();
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		blackboard.PrintAllPatronsInfo();
	}
    @Override
    public String toString() {
    	return "As a librarian see every patron's information here";
    }
}
