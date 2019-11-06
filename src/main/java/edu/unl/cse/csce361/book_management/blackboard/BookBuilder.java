package edu.unl.cse.csce361.book_management.blackboard;

public class BookBuilder{
	
	private String callnumber;
	private String title;
	private String author;
	private String status;
	
	public BookBuilder() {
		
		this.callnumber = null;
		this.title = "title is unknown";
		this.author = "author is unknown";
		this.status = " Status is unknown ";
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
		return new ConcreteBook(callnumber, title, author, status);
	}
	
	private class ConcreteBook implements Book{

		ConcreteBook(String callnumber, String title, String author, String status){
		    
			
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
		
			return 0;
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
	    public String getStatus() {
	    	return status;
	    }
		
	}

}
