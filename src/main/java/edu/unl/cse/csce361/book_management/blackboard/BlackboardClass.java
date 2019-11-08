package edu.unl.cse.csce361.book_management.blackboard;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class BlackboardClass extends Observable {

    static ArrayList<Book> arrBooks = BookConverter.bookConvert("books.csv");
    static Scanner scan = new Scanner(System.in);
/*
Read the Author name, Summary of book,
amount of copies of book from user.
 */
    public static void addBookAsLibrarian() {
        Boolean NeedToLoop = true;

        while (NeedToLoop) {
             Scanner scan = new Scanner(System.in);
            System.out.println("Please enter Author");
            String author = scan.nextLine();
            System.out.println("Please enter Title of the Book");
            String title = scan.nextLine();
            System.out.println("Please enter Summary of the Book");
            String summary = scan.nextLine();
            System.out.println("Please enter amount of copies you want to add");
            try {
                int copyNumber = scan.nextInt();
                BookBuilder build = new BookBuilder();
                if (author != null && author.length() > 0) {
                    build.setAuthor(author);
                    NeedToLoop = false;
                }
                if (title != null && title.length() > 0) {
                    build.setAuthor(title);
                    NeedToLoop = false;
                }
                if (summary != null && summary.length() > 0) {
                    build.setSummary(summary);
                    NeedToLoop = false;
                }
                if (copyNumber != 0) {
                    build.setCopyNumber(copyNumber);
                    NeedToLoop = false;
                }
                Book newBook = build.build();
                arrBooks.add(newBook);
                System.out.println(newBook.getSummary());

            } catch (Exception e) {
                System.out.println("You did not input the integers, You need to input the integers again");
            }
        }
        scan.close();
    }
    public static void searchBookbyAuthorOrTitle() {
        System.out.println("If you like to search by author then press 1 or If you like to search by title press 2");
        int search = scan.nextInt();
        scan.nextLine();
        Boolean NeedToLoop = true;
        while (NeedToLoop) {
            if (search == 1) {
                System.out.println("Please enter the author name");
                String authorName = scan.nextLine();
                NeedToLoop = CheckValidityInput(authorName);
                if (NeedToLoop){
                    System.out.println("You input is invalid which can not match in the author name of database");
                }
                Loop(authorName, "author_name");
            } else if (search == 2) {
                System.out.println("Please enter the title of the book");
                String titleName = scan.nextLine();
                NeedToLoop = CheckValidityInput(titleName);
                if (NeedToLoop){
                    System.out.println("You input is invalid which can not match in the titleName of database");
                }
                Loop(titleName, "Title");
            }
        }


    }
    public static void removeBookAsPatron() {
        System.out.println("Please enter catalog number of the book you want to remove");
        String catalogNumber = scan.nextLine();
        for(int i = 0; i<arrBooks.size(); i++) {
            if(arrBooks.get(i).getCallNumber().equalsIgnoreCase(catalogNumber)) {
                arrBooks.remove(i);
            }
        }
    }
    public static void addBookToCartAsPatron() {
        System.out.println("Please enter your Name");
        String patronName = scan.nextLine();
        System.out.println("Please enter the author of the book");
    }
    public static void printCatalog() {

    }


    public static void main(String[] args) {
        addBookAsLibrarian();
    }

    private static void Prompt(String AuthorName, String TitleName, String Status, String Summary){
        System.out.println("Author :- "+ AuthorName);
        System.out.println("Title :- "+ TitleName);
        System.out.println("Status :- "+Status);
        System.out.println("Summary :-"+Summary);
    }

    private static void Loop(String string,String Type){
        switch (Type){
                /*This part only check for title,
                This contains when the status is missing or not,
                when the status is missing, it will shows that it will be
                available later
                */

            case "Title":
                for (Book book:arrBooks
                ) {
                    if (book.getTitle().equalsIgnoreCase(string)){
                        if (book.getStatus().equalsIgnoreCase("Missing")){
                            Prompt(book.getAuthor(),book.getTitle(),"Will be available later1",book.getSummary());
                        }
                        else {
                            Prompt(book.getAuthor(),book.getTitle(),book.getStatus(),book.getSummary());
                        }

                    }
                }
                break;
                /*This part only check for author_name,
                This contains when the status is missing or not,
                when the status is missing, it will shows that it will be
                available later
                */
            case "author_name":
                for (Book book:arrBooks
                ) {
                    if (book.getAuthor().equalsIgnoreCase(string)){
                        if (book.getStatus().equalsIgnoreCase("Missing")){

                        }else {
                            Prompt(book.getAuthor(),book.getTitle(),book.getStatus(),book.getSummary());
                        }
                    }
                }
                break;
                /*
                This part shows that the invalid input
                 */
        }
    }



/*
When the author name does not exist in database,
it will return True ,which will result to loop again
else,it will return false,which will result to no
loop again
 */
    public static Boolean CheckValidityInput(String string){
        Boolean NeedToLoop= true;
        for (Book book:arrBooks
        ) {
            if (book.getAuthor().equalsIgnoreCase(string)){
                NeedToLoop =false;
            }else if (book.getTitle().equalsIgnoreCase(string)){
                NeedToLoop =false;
            }
            }
        return NeedToLoop;
    }




}

