package edu.unl.cse.csce361.book_management.Frontend;

import edu.unl.cse.csce361.book_management.blackboard.Librarian;
import edu.unl.cse.csce361.book_management.blackboard.Patron;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Welcome to book management system. Type 1 shows that you are a Librarian, type 2 shows that you are library patron");
        Scanner scanner =new Scanner(System.in);
        int UserInput=scanner.nextInt();

        switch (UserInput){
            case 1:
                System.out.println("what do you want to do? ");
                System.out.println("Type 1 for adding Book into catlog");
                System.out.println("Type 2 for removing Book from catlog");
                System.out.println("Type 3 for printing Catalog");
                System.out.println("Type 4 for updating BookInfo");
                int UserChoose = scanner.nextInt();
                switch (UserChoose){
                    case 1:
                        Librarian.addBookAsLibrarian();
                        break;
                    case 2:
                        Librarian.removeBookAsLibrarian();
                        break;
                    case 3:
                        Librarian.printCatalog();
                        break;
                    case 4:
                        Librarian.updateBookInfo();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            case 2:
                System.out.println("What do you want to do?");
                System.out.println("Type 1 for searching Book by Author or Title");
                System.out.println("Type 2 for addBook to Cart As Patron");
                int UserChoose2 = scanner.nextInt();
                switch (UserChoose2){
                    case 1:
                        Patron.searchBookbyAuthorOrTitle();
                        break;
                    case 2:
                        Patron.addBookToCartAsPatron();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }



        }
    }


}