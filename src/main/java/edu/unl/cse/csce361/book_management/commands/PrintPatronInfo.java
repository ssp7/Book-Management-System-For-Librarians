package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class PrintPatronInfo implements Command
{
BlackboardClass blackboard = new BlackboardClass();

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		blackboard.PrintPatronInfo();
	}

	@Override
	public String toString() {
		return "As patron see your information by giving your name";
	}
	
}
