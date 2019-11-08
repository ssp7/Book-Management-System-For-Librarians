package edu.unl.cse.csce361.book_management.Observe;

public class library_patron extends ObservedObject {
    @Override
    public void update() {
        System.out.println(getString1());
    }
}
