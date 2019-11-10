
package edu.unl.cse.csce361.book_management.blackboard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Librarian implements Observer
{

	public String name;
	public static Book book;
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
	public Book addBookAsLibrarian() {
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
				book = build.build();
				
				arrBooks.add(book);
			

			} catch (Exception e) {
				System.out.println("You did not input the integers, You need to input the integers again");
			}
		}
		return book;

	}

	public static Book removeBookAsLibrarian() {
		System.out.println("Please enter catalog number of the book you want to remove");
		String catalogNumber = scan.nextLine();
		for(int i = 0; i<arrBooks.size(); i++) {
			if(arrBooks.get(i).getCallNumber().equalsIgnoreCase(catalogNumber)) {
				arrBooks.remove(i);
			   book = arrBooks.get(i);
			}
		}
		return book;
	}
	public static void printCatalog() {
		Collections.sort(arrBooks);
		for(int i = 0; i<arrBooks.size();i++) {
			if(!arrBooks.get(i).getStatus().equalsIgnoreCase("Missing")) {
				System.out.println("Book Number :- " + i + " ----------------------------------------------------------------");	
				System.out.println("Author :- "+ arrBooks.get(i).getAuthor());
				System.out.println("Title :- "+ arrBooks.get(i).getTitle());
				System.out.println("Status :- "+ arrBooks.get(i).getStatus());
				System.out.println("CallNumber :- " + arrBooks.get(i).getCallNumber());
				System.out.println("Summary :-"+arrBooks.get(i).getSummary());
			}
		}
	}

	public static void updateBookInfo() {
		System.out.println("Please enter 1 to change author name of the book");
		System.out.println("Please enter 2 to change the Title of book");
		System.out.println("Please enter 3 to change the call number of the book");
		int input = scan.nextInt();
		scan.nextLine();
		if(input == 1)
		{
			System.out.println("Please enter author of the book you want to change ");
			String authorinput = scan.nextLine();
			for(int b = 0; b<arrBooks.size(); b++) {
				if(arrBooks.get(b).getAuthor().equalsIgnoreCase(authorinput)) {
					System.out.println("Please enter new author name");
					String newAuthorName = scan.nextLine();
					arrBooks.get(b).setAuthor(newAuthorName);
					b = arrBooks.size();
				}
				else {
					System.out.println("Please enter correct author name for book");
					authorinput = scan.nextLine();
					b = 0;
				}
			}
		}
		else if(input == 2) {
			System.out.println("Please enter title of the book you would like to change");
			String titleinput = scan.nextLine();
			for(int b = 0; b<arrBooks.size(); b++) {
				if(arrBooks.get(b).getTitle().equalsIgnoreCase(titleinput)) {
					System.out.println("Please enter new title name");
					String newTitleName = scan.nextLine();
					arrBooks.get(b).setTitle(newTitleName);
					b = arrBooks.size();
				}
				else {
					System.out.println("Please enter correct title for book");
					titleinput = scan.nextLine();
					b = 0;
				}
			}
		}
		else if(input == 3) {
			System.out.println("Please enter the call number of the book you would like to change");
			String callNumberInput = scan.nextLine();
			for(int b = 0; b<arrBooks.size(); b++) {
				if(arrBooks.get(b).getCallNumber().equalsIgnoreCase(callNumberInput)) {
					System.out.println("Please enter new title name");
					String newCallName = scan.nextLine();
					arrBooks.get(b).setCallNumber(newCallName);
					b = arrBooks.size();
				}
				else {
					System.out.println("Please enter correct title for book");
					callNumberInput = scan.nextLine();
					b = 0;
				}
			}


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

