package edu.unl.cse.csce361.book_management.blackboard;

import java.util.Observable;

public class BookBuilder extends Observable{
	
	private String callnumber;
	private String title;
	private String author;
	private String status;
	private String summary;
	private int copyNumber;
	
	public BookBuilder() {
		
		this.callnumber = null;
		this.title = "title is unknown";
		this.author = "author is unknown";
		this.status = " Status is unknown ";
		this.summary = "Summary is not presented";
		this.copyNumber = 0;
				 
	}
	public BookBuilder setSummary(String summary) {
		this.summary = summary;
		return this;
	}
	public BookBuilder setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
		return this;
	}
    public BookBuilder setStatus(String status) {
    	this.status = status;
    	return this;
    }
	public BookBuilder setCallnumber(String callnumber) {
		this.callnumber = callnumber;
		return this;
	}
	public BookBuilder setTitle(String title) {
		this.title = title;
		return this;
	}
	public BookBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}

	public Book build() {
		return new ConcreteBook(callnumber, title, author, status, summary, copyNumber);
	}
	
	private class ConcreteBook implements Book{

		ConcreteBook(String callnumber, String title, String author, String status, String summary, int copyNumber){
		    
			
		}

		@Override
		public String getCallNumber() {
			// TODO Auto-generated method stub
			
			return callnumber;
		}

		@Override
		public String getAuthor() {
			// TODO Auto-generated method stub
			return author;
		}

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return title;
		}
		@Override
	    public String getStatus() {
	    	return status;
	    }
		@Override
	    public String getSummary() {
	    	return summary;
	    }

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getCopyNumber() {
			// TODO Auto-generated method stub
			return copyNumber;
		}
		
	}

}
