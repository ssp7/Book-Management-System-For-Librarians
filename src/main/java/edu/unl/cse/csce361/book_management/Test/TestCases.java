package edu.unl.cse.csce361.book_management.Test;

import edu.unl.cse.csce361.book_management.CLI;
import edu.unl.cse.csce361.book_management.blackboard.Book;
import edu.unl.cse.csce361.book_management.commands.AddBookAsLibrarian;
import edu.unl.cse.csce361.book_management.commands.Command;
import edu.unl.cse.csce361.book_management.commands.ExitCommand;
import edu.unl.cse.csce361.book_management.commands.PrintCatalog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

import javax.sql.rowset.CachedRowSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCases {
    private InputStream in;
    private PrintStream out;
    private PrintStream err;
    public static final int MAXIMUM_TOKEN_LENGTH = 20;

    private CLI cli;
    private ByteArrayOutputStream fakeOut;
    private String lineSeparator;

    private static void setFakeIn(String input) {
        if (input == null) {
            input = "";
        }
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


    @Before
    public void setUp() {
        if (System.getProperty("os.name").contains("Windows"))
            lineSeparator = "\r\n";
        else
            lineSeparator = "\n";
        cli = new CLI(); 

        in = System.in;
        out = System.out;
        err = System.err;
        fakeOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOut));
    }

    @After
    public void tearDown() {
        System.setIn(in);
        System.setOut(out);
        System.setErr(err);
    }

   @Test
   public void Exit() {
	   Command c = new ExitCommand(cli);
	  
	    c.execute();
	   
   }
    
   @Test(timeout = 1000)
   public void printBook() {
	   Command c = new PrintCatalog();
	   c.execute();
	   }
   }