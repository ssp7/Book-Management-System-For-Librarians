package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.CLI;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class ExitCommandTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    @Test
    public void execute() {
        CLI cli =new CLI();
        ExitCommand exitCommand = new ExitCommand(cli);
        exit.expectSystemExitWithStatus(0);
        exitCommand.execute();
    }

    @Test
    public void toString1() {
        CLI cli = new CLI();
        ExitCommand exitCommand = new ExitCommand(cli);
        assertEquals("Exit",exitCommand.toString());
    }
}