package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class PrintCatalog implements Command{

	@Override
	public void execute() {
		BlackboardClass.printCatalog();
	}
	@Override
	public String toString() {
		return "See catalog for information about Books";
	}
	
}
