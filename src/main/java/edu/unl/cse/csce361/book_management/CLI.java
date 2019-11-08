package edu.unl.cse.csce361.book_management;

import edu.unl.cse.csce361.book_management.commands.AddBookAsLibrarian;
import edu.unl.cse.csce361.book_management.commands.Command;
import edu.unl.cse.csce361.book_management.commands.ExitCommand;
import edu.unl.cse.csce361.book_management.commands.SetDateCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private List<Command> commands;
    private boolean running;
    private Scanner scan = new Scanner(System.in);

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
        addCommand(new AddBookAsLibrarian());
        
        
    }

    private void run() {
        while (running) {
            for (int i=0; i<commands.size(); i++) {
                System.out.println(i + ". " + commands.get(i));
             
            }
            System.out.println("Please enter the number to execute the command");
            int input = scan.nextInt();
            scan.nextLine();
            if(input == 2) {
            commands.get(input).execute();
            scan.close();
            }
        
        }
    }

    public static void main(String[] args) {
        new CLI().run();
    }
}
