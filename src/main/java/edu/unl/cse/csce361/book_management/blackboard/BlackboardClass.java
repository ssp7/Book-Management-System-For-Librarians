package edu.unl.cse.csce361.book_management.blackboard;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Scanner;

public class BlackboardClass extends Observable {

	static ArrayList<Book> arrBooks = BookConverter.bookConvert("books.csv");
	static ArrayList<Patron> arrPatron = new ArrayList<Patron>();
	static Scanner scan = new Scanner(System.in);

	public static void addBookAsLibrarian() {



		System.out.println("Please enter Author");
		String author = scan.nextLine();
		System.out.println("Please enter Title of the Book");
		String title = scan.nextLine();
		System.out.println("Please enter Summary of the Book");
		String summary = scan.nextLine();
		System.out.println("Please enter amount of copies you want to add");
		int copyNumber = scan.nextInt();
		scan.close();


		BookBuilder build = new BookBuilder();
		if(author != null && author.length() >0) {
			build.setAuthor(author);
		}
		if(title != null && title.length() >0) {
			build.setAuthor(title);
		}
		if(summary != null && summary.length() >0) {
			build.setSummary(summary);
		}
		if(copyNumber != 0) {
			build.setCopyNumber(copyNumber);
		}

		Book newBook = build.build();
		arrBooks.add(newBook);
		System.out.println(newBook.getSummary());

	}
	public static void searchBookbyAuthorOrTitle() {

		System.out.println("If you like to search by author then press 1 or If you like to search by title press 2");
		int search = scan.nextInt();
		scan.nextLine();
		if(search == 1) {
			System.out.println("Please enter the author name");
			String authorName = scan.nextLine();


			for(int i = 0; i<arrBooks.size(); i++) {
				if(arrBooks.get(i).getAuthor().equalsIgnoreCase(authorName)) {

					if(arrBooks.get(i).getStatus().equalsIgnoreCase("Missing")) {

						System.out.println("Author :- "+ arrBooks.get(i).getAuthor());

						System.out.println("Title :- "+ arrBooks.get(i).getTitle());

						System.out.println("Status :- Will be available later1");

						System.out.println("Summary :-"+arrBooks.get(i).getSummary());
					}
					else {


						System.out.println("Author :- "+ arrBooks.get(i).getAuthor());

						System.out.println("Title :- "+ arrBooks.get(i).getTitle());

						System.out.println("Status :- "+ arrBooks.get(i).getStatus());

						System.out.println("Summary :-"+arrBooks.get(i).getSummary());
					}

				}


			}
		}
		else if(search == 2) {
			System.out.println("Please enter the title of the book");
			String titleName = scan.nextLine();


			for(int i = 0; i<arrBooks.size(); i++) {
				if(arrBooks.get(i).getTitle().equalsIgnoreCase(titleName)) {

					if(arrBooks.get(i).getStatus().equalsIgnoreCase("Missing")) {

						System.out.println("Author :- "+ arrBooks.get(i).getAuthor());

						System.out.println("Title :- "+ arrBooks.get(i).getTitle());

						System.out.println("Status :- Will be available later1");

						System.out.println("Summary :-"+arrBooks.get(i).getSummary());
					}
					else {


						System.out.println("Author :- "+ arrBooks.get(i).getAuthor());

						System.out.println("Title :- "+ arrBooks.get(i).getTitle());

						System.out.println("Status :- "+ arrBooks.get(i).getStatus());
						System.out.println("CallNumber :- " + arrBooks.get(i).getCallNumber());

						System.out.println("Summary :-"+arrBooks.get(i).getSummary());
					}

				}


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
		}
		Date today = new Date();
        newPatron.setDate(today.getDate());
        
      arrPatron.add(newPatron);
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



}

