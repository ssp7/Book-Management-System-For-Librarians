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
	amount of copies of book from user.
	 */
	    public void addBookAsLibrarian() {
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

	            } catch (Exception e) {
	                System.out.println("You did not input the integers, You need to input the integers again");
	            }
	        }
	     
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
