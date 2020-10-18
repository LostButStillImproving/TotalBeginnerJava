package org.totalbeginner.tutorial;
import org.junit.Assert;
import org.junit.Test;

public class BookTest {

    @Test
    public void testBook() {
        Book b1 = new Book("Great Expectations");
        Assert.assertEquals("Great Expectations", b1.title);
        Assert.assertEquals("unknown author", b1.author);
    }

    @Test
    public void testGetPerson() {
        Book b2 = new Book("War and Peace");
        Person p2 = new Person();
        p2.setName("Elvis");
        // book is loaned to this person
        b2.setPerson(p2);
        //get the name of the person
        String testName = b2.getPerson().getName();
        Assert.assertEquals("Elvis", testName);
    }
}
