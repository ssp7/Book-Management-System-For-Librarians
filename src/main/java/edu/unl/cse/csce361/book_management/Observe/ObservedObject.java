package edu.unl.cse.csce361.book_management.Observe;

import java.util.Observable;
import java.util.Observer;

abstract class ObservedObject extends Observable {
    public String String1;

    public String getString1() {
        return String1;
    }

    public void setString1(String string1) {
        String1 = string1;
    }

    public abstract void update();

}