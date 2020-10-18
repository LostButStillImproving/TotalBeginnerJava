package org.totalbeginner.tutorial;

import org.junit.Test;

public class Person{
    private String name;
    private int maximumBooks = 1;

    public Person(){
        name = "unknown name";
        maximumBooks = 1;
    }
    public int getMaximumBooks() {
        return maximumBooks;
    }

    public void setMaximumBooks(int maximumBooks) {
        this.maximumBooks = maximumBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String anyName) {
        this.name = anyName;
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getMaximumBooks() + " books" + ")";
    }
}
