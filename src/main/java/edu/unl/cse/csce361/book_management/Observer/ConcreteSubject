package edu.unl.cse.csce361.book_management.Observer;

import java.util.*;


public class ConcreteSubject implements Subject {
    private List<Observer> list = new ArrayList<>();
    private String data;

    @Override
    public void registerObserver(Observer observer) {
        if (!list.contains(observer)) {
            list.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : list) {
            observer.update();
        }
    }

}