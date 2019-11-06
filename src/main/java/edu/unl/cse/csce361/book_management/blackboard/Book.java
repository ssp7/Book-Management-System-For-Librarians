package edu.unl.cse.csce361.book_management.blackboard;

import java.util.ArrayList;

public interface Book extends Comparable {
    String getCallNumber();
    String getAuthor();
    String getTitle();
    String getStatus();
    ArrayList<String> getStringArrayList();
    void AddpatronOnHoldArrayList(String name);
    void DeletepatronOnHoldArrayList(String name);

}
