package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class manipulateHoldList implements Command {
    BlackboardClass blackboard = new BlackboardClass();

    @Override
    public void execute() {
        blackboard.manipulateHoldList();


    }
    @Override
    public String toString() {
        return "manipulate Hold List for librarian";
    }
}
