package edu.unl.cse.csce361.book_management;

import edu.unl.cse.csce361.book_management.commands.Command;
import edu.unl.cse.csce361.book_management.commands.ExitCommand;
import edu.unl.cse.csce361.book_management.commands.SetDateCommand;

import java.util.ArrayList;
import java.util.List;

public class CLI {
    private List<Command> commands;
    private boolean running;

    public CLI() {
        commands = new ArrayList<>();
        addInitialCommands();
        running = true;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void terminate() {
        running = false;
    }

    private void addInitialCommands() {
        addCommand(new ExitCommand(this));
        addCommand(new SetDateCommand());
    }

    private void run() {
        while (running) {
            for (int i=0; i<commands.size(); i++) {
                System.out.println(i + ". " + commands.get(i));
            }
            // ...
        }
    }

    public static void main(String[] args) {
        new CLI().run();
    }
}
