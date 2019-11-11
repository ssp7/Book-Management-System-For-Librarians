package edu.unl.cse.csce361.book_management;

import edu.unl.cse.csce361.book_management.commands.AddBookAsLibrarian;
import edu.unl.cse.csce361.book_management.commands.AddBookToCartAsPatron;
import edu.unl.cse.csce361.book_management.commands.Command;
import edu.unl.cse.csce361.book_management.commands.ExitCommand;
import edu.unl.cse.csce361.book_management.commands.PrintAllPatronInfo;
import edu.unl.cse.csce361.book_management.commands.PrintBooksFromCart;
import edu.unl.cse.csce361.book_management.commands.PrintCatalog;
import edu.unl.cse.csce361.book_management.commands.PrintPatronInfo;
import edu.unl.cse.csce361.book_management.commands.PrintSpecificPatronInfo;
import edu.unl.cse.csce361.book_management.commands.RemoveBookAsLibrarian;
import edu.unl.cse.csce361.book_management.commands.SearchBookByAuthorOrTitle;
import edu.unl.cse.csce361.book_management.commands.SetDateCommand;
import edu.unl.cse.csce361.book_management.commands.UpdateBookInfoAsLibrarian;
import edu.unl.cse.csce361.book_management.commands.ViewHoldList;
import edu.unl.cse.csce361.book_management.commands.manipulateHoldList;

import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.BadLocationException;
import javax.swing.text.View;
import javax.swing.text.Position.Bias;

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
        addCommand(new SearchBookByAuthorOrTitle());
        addCommand(new RemoveBookAsLibrarian());
        addCommand(new AddBookToCartAsPatron());
        addCommand(new PrintCatalog());
        addCommand(new UpdateBookInfoAsLibrarian());
        addCommand(new PrintBooksFromCart());
        addCommand(new PrintAllPatronInfo());
        addCommand(new PrintSpecificPatronInfo());
        addCommand(new PrintPatronInfo());
        addCommand(new ViewHoldList());
        addCommand(new manipulateHoldList());
      
    }

    private void run() {
        while (running) {
            for (int i=0; i<commands.size(); i++) {
                System.out.println(i + ". " + commands.get(i));
            }
            System.out.println("Please enter the number to execute the command");
            int input = scan.nextInt();
      
            commands.get(input).execute();
        }
    }

    public static void main(String[] args) {
        new CLI().run();
    }
}
