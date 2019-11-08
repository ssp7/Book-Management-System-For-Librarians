package edu.unl.cse.csce361.book_management.Observe;

public class Librarian extends ObservedObject   {
    @Override
    public void update() {
        System.out.println(getString1());
    }
}
