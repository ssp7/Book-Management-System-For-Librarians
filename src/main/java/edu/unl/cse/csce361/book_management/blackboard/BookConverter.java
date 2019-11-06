package edu.unl.cse.csce361.book_management.blackboard;

import java.awt.List;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class BookConverter {
	
	public static ArrayList<Book> bookConvert( String filename){
	    ArrayList<Book> arrBooks = new ArrayList<Book>();
		ArrayList<BookBuilder> arrBookBuilder = new ArrayList<BookBuilder>();
		Set<Map<String, String>> csvSet = CSVReaderWriter.readCSV(filename);
	
	
			
			 
			for( Map<String,String> mapping : csvSet) {
				 BookBuilder builder = new BookBuilder();
				if(mapping.get("Author") != null && mapping.get("Author").length() >= 1) {
					
					builder.setAuthor(mapping.get("Author"));
				}
				if(mapping.get("Status") != null && mapping.get("Status").length() >= 1) {
					builder.setStatus(mapping.get("Status"));
				}
				if(mapping.get("Title") != null && mapping.get("Title").length() >= 1) {
					builder.setTitle(mapping.get("Title"));
				}
				if(mapping.get("CallNumber") != null && mapping.get("CallNumber").length() >= 1) {
					builder.setCallnumber(mapping.get("CallNumber"));
				}
				
				 Book b = builder.build();
				   arrBooks.add(b); 	   
			}
		return arrBooks;
	}

	
}
