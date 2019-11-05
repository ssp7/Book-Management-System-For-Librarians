package edu.unl.cse.csce361.book_management.blackboard;

public class BookBuilder{
	
	private String callnumber;
	private String title;
	private String author;
	
	public BookBuilder() {
		
		this.callnumber = callnumber;
		this.title = title;
		this.author = author;
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
		return new ConcreteBook(callnumber, title, author);
	}
	
	private class ConcreteBook implements Book{
		private String callnumber;
		private String author;
		private String title;
		ConcreteBook(String callnumber, String title, String author){
			
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
		
	}

}
