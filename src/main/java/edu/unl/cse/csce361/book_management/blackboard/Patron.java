package edu.unl.cse.csce361.book_management.blackboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Patron implements Observer {
    static ArrayList<Book> arrBooks = BookConverter.bookConvert("books.csv");
    static ArrayList<Patron> arrPatron = new ArrayList<Patron>();
    static Scanner scan = new Scanner(System.in);
    static Librarian librarian = new Librarian();
	public String name;
	public Book bookInCart;
	public Book getBookInCart() {
		return bookInCart;
	}
	public void setBookInCart(Book bookInCart) {
		this.bookInCart = bookInCart;
	    booksInCart.add(this.bookInCart);
	}
	public ArrayList<Book> booksInCart;
	public ArrayList<Book> booksCheckedOut;
	public int date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Book> getBooksInCart() {
		return booksInCart;
	}
	public void setBooksInCart(ArrayList<Book> booksInCart) {
		this.booksInCart = booksInCart;
	}
	public ArrayList<Book> getBooksCheckedOut() {
		return booksCheckedOut;
	}
	public void setBooksCheckedOut(ArrayList<Book> booksCheckedOut) {
		this.booksCheckedOut = booksCheckedOut;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	@Override
	public void update(Observable b, Object Books) {
	 
		System.out.println("New book is added to a catalog");

		
		
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
	 public static void addBookToCartAsPatron() {
	     Patron newPatron = new Patron();
			
			System.out.println("Please enter your Name");
			String patronName = scan.nextLine();
			newPatron.setName(patronName);
			System.out.println("Please enter the author of the book");
			String authorName = scan.nextLine();
	        
			for(int i = 0; i<arrBooks.size();i++) {
				if(arrBooks.get(i).getAuthor().equalsIgnoreCase(authorName))
				{
					newPatron.setBookInCart(arrBooks.get(i));
				}
				else {
					System.out.println("Please enter correct author name");
					authorName = scan.nextLine();
					i = 0;
				}
			}
			Date today = new Date();
	        newPatron.setDate(today.getDate());
	        
	      arrPatron.add(newPatron);
	        
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
