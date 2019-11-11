package edu.unl.cse.csce361.book_management.commands;

public interface Command {
    void execute();
    @Override
	String toString();
    
}
