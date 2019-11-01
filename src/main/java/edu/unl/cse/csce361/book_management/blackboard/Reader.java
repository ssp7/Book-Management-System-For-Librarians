package edu.unl.cse.csce361.book_management.blackboard;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Reader {

	
	public static ArrayList<Books> booksReader(String filename) {
		ArrayList<Books> arrBooks = new ArrayList<Books>();
		
		Set<Map<String, String>> bookData;
		bookData = CSVReaderWriter.readCSV(filename);
		
		for(Map<String, String> b : bookData) {
			
			Books books = new Books();
			books.setAuthor(b.get("Author"));
			books.setCallNumber(b.get("CallNumber"));
			books.setStatus(b.get("Status"));
			books.setTitle(b.get("Title"));
			
			arrBooks.add(books);
		}
		
		return arrBooks;
	}
	public static void main(String[]args) {
   
  ArrayList<Books> books = new ArrayList<Books>();
     books = booksReader("books.csv");

     for(int i = 0 ; i < books.size(); i++) {
			
			System.out.println(books.get(i).getAuthor());
		}
	
     
	}
}
