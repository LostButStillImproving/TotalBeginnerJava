package org.totalbeginner.tutorial;
import java.util.ArrayList;

public class MyLibrary {
    String name;
    ArrayList<Book> books;
    ArrayList<Person> people;

    public MyLibrary(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.people = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }


    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removePerson(Book book) {
        this.books.remove(book);
    }
    public void addPerson(Person person) {
        this.people.add(person);
    }

    public void removePerson(Person person) {
        this.people.remove(person);
    }

    public boolean checkout(Book book, Person person) {
        int booksOut = this.getBooksForPerson(person).size();
        if (booksOut < person.getMaximumBooks()) {
            if (book.getPerson() == null) {
                book.setPerson(person);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIn(Book book) {
        if (book.getPerson() != null){
            book.setPerson(null);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Book> getBooksForPerson(Person person) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book aBook :this.getBooks() ) {
            if((aBook.getPerson() != null) &&
                    (aBook.getPerson().getName().equals(person.getName())))
            result.add(aBook);
        }
        return result;
    }
}
