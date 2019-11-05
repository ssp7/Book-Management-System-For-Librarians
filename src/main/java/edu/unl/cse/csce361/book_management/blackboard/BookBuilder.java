package edu.unl.cse.csce361.book_management.blackboard;

public class Books implements Book {

    public String author;
    public String title;
    public String callNumber;
    public String status;
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

   public void setAuthor(String author) {
	   this.author = author;
   }
   
	@Override
public String toString() {
	return "Books [author=" + author + ", title=" + title + ", callNumber=" + callNumber + ", status=" + status
			+ ", getCallNumber()=" + getCallNumber() + ", getAuthor()=" + getAuthor() + ", getTitle()=" + getTitle()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	@Override
	public String getCallNumber() {
		// TODO Auto-generated method stub
		return callNumber;
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
