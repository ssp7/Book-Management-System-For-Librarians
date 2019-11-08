package edu.unl.cse.csce361.book_management.Observe;

public interface Subject {
    void registerObserver(ObservedObject observer);
    void removeObserver(ObservedObject observer);
    void notifyObservers();
}