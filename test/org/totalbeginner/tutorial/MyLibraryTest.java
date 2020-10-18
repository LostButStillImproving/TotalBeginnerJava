package org.totalbeginner.tutorial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MyLibraryTest {

    private Book b1;
    private Book b2;
    private Person p1;
    private Person p2;
    private MyLibrary ml;

    @Before
    public void setUp() throws Exception {
        b1 = new Book("Book1");
        b2 = new Book("Book2");

        p1 = new Person();
        p2 = new Person();
        p1.setName("Fred");
        p2.setName("Sue");

        ml = new MyLibrary("Test");
    }
    public void addItems() {
        p1.setMaximumBooks(1);
        ml.addBook(b1);
        ml.addBook(b2);
        ml.addPerson(p1);
        ml.addPerson(p2);
    }
    //test constructor
    @Test
    public void testMyLibrary(){
        MyLibrary ml = new MyLibrary("Test");

        Assert.assertEquals("Test", ml.name);
        Assert.assertTrue(ml.books instanceof ArrayList);
        Assert.assertTrue(ml.people instanceof ArrayList);
    }
    @Test
    public void testAddBook() throws Exception {
        setUp();

        Assert.assertEquals(0, ml.getBooks().size());

        ml.addBook(b1);
        ml.addBook(b2);

        Assert.assertEquals(2, ml.getBooks().size());
        Assert.assertEquals(0, ml.getBooks().indexOf(b1));
        Assert.assertEquals(1, ml.getBooks().indexOf(b2));

        ml.removePerson(b1);
        Assert.assertEquals(0, ml.getBooks().indexOf(b2));
        Assert.assertEquals(1, ml.getBooks().size());

        ml.removePerson(b2);
        Assert.assertEquals(0, ml.getBooks().size());
    }

    @Test
    public void testCheckOut() throws Exception {
        setUp();
        addItems();

        Assert.assertTrue("Book did not checkout correctly",
                ml.checkout(b1, p1));
        Assert.assertEquals("Fred", b1.getPerson().getName());
       // Assert.assertFalse("Book was already checked out",
     //           ml.checkout(b2, p2));
        Assert.assertTrue("Book check in failed", ml.checkIn(b1));
        Assert.assertFalse("Book was already checked in", ml.checkIn(b1));
        Assert.assertFalse("Book was never checked out", ml.checkIn(b2));

        setUp();
        addItems();

        Assert.assertTrue("First book did not checkout",
                ml.checkout(b2, p1));
        Assert.assertFalse("Second book should not have checked out",
                ml.checkout(b1, p1));
    }



    @Test
    public void testGetBooksForPerson() throws Exception {
        setUp();
        addItems();
        Assert.assertEquals(0, ml.getBooksForPerson(p1).size());

        ml.checkout(b1, p1);

        ArrayList<Book> testBooks = ml.getBooksForPerson(p1);
        Assert.assertEquals(1, testBooks.size());
        Assert.assertEquals(0, testBooks.indexOf(b1));

        ml.checkout(b2, p1);
        testBooks = ml.getBooksForPerson(p1);
        Assert.assertEquals(1, testBooks.size());
        Assert.assertEquals(0, testBooks.indexOf(b1));

    }
}
