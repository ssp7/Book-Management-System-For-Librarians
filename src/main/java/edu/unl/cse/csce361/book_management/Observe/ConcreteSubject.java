package edu.unl.cse.csce361.book_management.Observe;

import java.util.*;


public class ConcreteSubject implements Subject {
    private List<ObservedObject> list = new ArrayList<>();
    private String data;


    @Override
    public void registerObserver(ObservedObject observer) {
        if (!list.contains(observer)){
            list.add(observer);
        }
    }

    @Override
    public void removeObserver(ObservedObject observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (ObservedObject observedObject:list
             ) {
            System.out.println(observedObject.getString1());
        }

    }
}