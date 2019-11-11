package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.BlackboardClass;

public class ViewHoldList implements Command {
    BlackboardClass blackboard = new BlackboardClass();

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        blackboard.ViewHoldList();
    }

    @Override
    public String toString() {
        return "View Hold List for librarian";

    }
}
