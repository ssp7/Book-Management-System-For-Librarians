package edu.unl.cse.csce361.book_management.blackboard;

import java.util.ArrayList;

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
    ArrayList<String>PatronHoldList();
    void PlacePatronFrontInHoldList(String PatronName);
    void RemovePatronForeverInHoldList(String Patronname);
    ArrayList<String>BlackList();
    void AddPatron(String PatronName);
    void RemovePatronInHoldList(String PatronName);

}

