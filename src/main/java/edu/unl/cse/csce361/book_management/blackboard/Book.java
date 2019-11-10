package edu.unl.cse.csce361.book_management.blackboard;

public interface Book extends Comparable {
    String getCallNumber();
    String getAuthor();
    String getTitle();
    String getStatus();
    String getSummary();
    int getCopyNumber();
    String setAuthor(String author);
    String setTitle(String title);
    String setSummary(String summary);
    String setCallNumber(String callNumber);
    int setCopyNumber(int CopyNumber);
    
    
}
