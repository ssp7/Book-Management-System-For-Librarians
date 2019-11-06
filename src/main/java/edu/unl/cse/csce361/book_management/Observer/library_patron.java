package edu.unl.cse.csce361.book_management.Observer;

public class library_patron implements Observer {
    public String string;
    private String name;
    public library_patron(String name) {
        this.name = name;
    }
    @Override
    public void setString(String string) {
        this.string = string;
    }
    @Override
    public void update() {
        System.out.println(string);

    }
}
