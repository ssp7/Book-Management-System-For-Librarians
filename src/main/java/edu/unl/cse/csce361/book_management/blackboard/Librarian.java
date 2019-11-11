package edu.unl.cse.csce361.book_management.blackboard;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Librarian implements Observer
{

    public String name;
    public Book book;
    public ArrayList<Book> arrayBook;
    static ArrayList<Book> arrBooks = BookConverter.bookConvert("books.csv");
    static ArrayList<Patron> arrPatron = new ArrayList<Patron>();
    static Scanner scan = new Scanner(System.in);
    static Librarian librarian = new Librarian();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ArrayList<Book> getArrayBook() {
        return arrayBook;
    }

    public void setArrayBook(ArrayList<Book> arrayBook) {
        this.arrayBook = arrayBook;
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub


    }
    /*
    Read the Author name, Summary of book,
    amount of copies of book from user.if
    the user input null for author,title,summary
    or copyNumber to 0, it will output you should
    input again
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
                if (author ==null &&title == null&&summary == null||copyNumber == 0){
                    NeedToLoop = true;
                }else {
                    NeedToLoop =false;
                }
                if (author != null && author.length() > 0) {
                    build.setAuthor(author);
                }
                if (title != null && title.length() > 0) {
                    build.setAuthor(title);
                }
                if (summary != null && summary.length() > 0) {
                    build.setSummary(summary);
                }
                if (copyNumber != 0) {
                    build.setCopyNumber(copyNumber);
                }
                Book newBook = build.build();
                arrBooks.add(newBook);
            } catch (Exception e) {
                System.out.println("You did not input the integers, You need to input the integers again");
            }
        }
        scan.close();
    }

    public static void removeBookAsLibrarian() {
        System.out.println("Please enter catalog number of the book you want to remove");
        String catalogNumber = scan.nextLine();
        for(int i = 0; i<arrBooks.size(); i++) {
            if(arrBooks.get(i).getCallNumber().equalsIgnoreCase(catalogNumber)) {
                arrBooks.remove(i);
            }
        }
    }
    public static void printCatalog() {
        for(int i = 0; i<arrBooks.size();i++) {
            System.out.println("Book Number :- " + i + " ----------------------------------------------------------------");
            if(arrBooks.get(i).getStatus().equalsIgnoreCase("Shelved"))
                System.out.println("Author :- "+ arrBooks.get(i).getAuthor());
            System.out.println("Title :- "+ arrBooks.get(i).getTitle());
            System.out.println("Status :- "+ arrBooks.get(i).getStatus());
            System.out.println("CallNumber :- " + arrBooks.get(i).getCallNumber());
            System.out.println("Summary :-"+arrBooks.get(i).getSummary());
        }
    }


/*
This part is for Updating the bookInfo
Change the author name
change the title of book
change the call number of the book
if the user input the invalid values,
it should loop again
 */
    public static void updateBookInfo() {
        Boolean NeedToLoop = true;
        while (NeedToLoop) {
            System.out.println("Please enter 1 to change author name of the book");
            System.out.println("Please enter 2 to change the Title of book");
            System.out.println("Please enter 3 to change the call number of the book");
            int input = scan.nextInt();
            scan.nextLine();
            switch (input) {
                case 1:
                    System.out.println("Please enter author of the book you want to change ");
                    String authorinput = scan.nextLine();
                    for (int b = 0; b < arrBooks.size(); b++) {
                        if (arrBooks.get(b).getAuthor().equalsIgnoreCase(authorinput)) {
                            System.out.println("Please enter new author name");
                            String newAuthorName = scan.nextLine();
                            arrBooks.get(b).setAuthor(newAuthorName);
                        } else {
                            System.out.println("Please enter correct author name for book");
                            authorinput = scan.nextLine();
                            b = 0;
                        }
                    }
                    NeedToLoop =false;
                    break;
                case 2:
                    System.out.println("Please enter title of the book you would like to change");
                    String titleinput = scan.nextLine();
                    for (int b = 0; b < arrBooks.size(); b++) {
                        if (arrBooks.get(b).getTitle().equalsIgnoreCase(titleinput)) {
                            System.out.println("Please enter new title name");
                            String newTitleName = scan.nextLine();
                            arrBooks.get(b).setTitle(newTitleName);
                        } else {
                            System.out.println("Please enter correct title for book");
                            titleinput = scan.nextLine();
                            b = 0;
                        }
                    }
                    NeedToLoop =false;
                    break;
                case 3:
                    System.out.println("Please enter the call number of the book you would like to change");
                    String callNumberInput = scan.nextLine();
                    for (int b = 0; b < arrBooks.size(); b++) {
                        if (arrBooks.get(b).getCallNumber().equalsIgnoreCase(callNumberInput)) {
                            System.out.println("Please enter new title name");
                            String newCallName = scan.nextLine();
                            arrBooks.get(b).setCallNumber(newCallName);
                        } else {
                            System.out.println("Please enter correct title for book");
                            callNumberInput = scan.nextLine();
                            b = 0;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input, you need to input the valid values, please input again");

            }
        }
        scan.close();
    }

    public void ViewHoldList(){
        scan = new Scanner(System.in);
        System.out.println("What is the book title that you want to search?");
        String InputTitle = scan.nextLine();
        System.out.println(arrBooks.get(0).PatronHoldList());

        for (Book book:arrBooks
             ) {
            if (book.getTitle().equals(InputTitle)){
                System.out.println("The hold list is that: ");
                System.out.println(book.PatronHoldList());
            }

        }
    }
    public void printPatrons() {
    	ArrayList<Patron> patrons = Patron.getArrPatron();
    	
    	for(int i = 0; i < patrons.size() ;i ++) {
    		System.out.println(" Patron No :- " + (i-1) + "---------------");
    		System.out.println("Name of the Patron :- "+patrons.get(i).getName());
    		System.out.println("Books in the Patron's cart :- " + patrons.get(i).getBooksInCart());
    	}
    }
    
    public void printSpecificPatronInfo() {
    	
    	System.out.println("Please enter patron's name");
    	String patronName = scan.nextLine();
    	boolean check = false;
    	while(check == false) {
    	for(int i =0 ; i< arrPatron.size(); i++) {
    		if(arrPatron.get(i).getName().equalsIgnoreCase(patronName)) {
    			System.out.println(" Patron's Name :- " + patronName);
                System.out.println("Books that patron has checked out in cart " + arrPatron.get(i).getBooksCheckedOut());
                System.out.println("Books in patron's cart :- " + arrPatron.get(i).getBooksInCart());
                check = true;
    		}
    	}
    	if(check == false) {
    	   System.out.println("Please enter correct patron's name");
    	   patronName = scan.nextLine();
    	}
    }
    
    }
//Manipulate hold list
    public void manipulateHoldList(){
        System.out.println("How do you want to manipulate the hold list? Type 1 for remove people so that he will no longer have a hold on the book. 2 for place people at the front of the queue, 3 for add patron into holdList,4 for delete patron in holdList");
        int UserInput = scan.nextInt();
        System.out.println("Please input the patron Name");
        Scanner scanner2 =new Scanner(System.in);
        String PatronName = scanner2.nextLine();
        System.out.println("Please input the Book Title");
        String BookTitle = scanner2.nextLine();
        for (Book book:arrBooks
             ) {
            if (book.getTitle().equals(BookTitle)) {
                switch (UserInput) {
                    case 1:
                        book.RemovePatronForeverInHoldList(PatronName);
                        break;
                    case 2:
                        book.PlacePatronFrontInHoldList(PatronName);
                        break;
                    case 3:
                        book.AddPatron(PatronName);
                        break;
                    case 4:
                        book.RemovePatronInHoldList(PatronName);
                        break;

                }
            }

        }

    }
}

