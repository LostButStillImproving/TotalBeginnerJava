package org.totalbeginner.tutorial;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

  @Test
  public void testPerson() {
    Person p1 = new Person();
    Assert.assertEquals("unknown name", p1.getName());
    Assert.assertEquals(1, p1.getMaximumBooks());
  }

  @Test
  public void testGetMaximumBooks() {
    Person person = new Person();
    Assert.assertEquals(1, person.getMaximumBooks());
  }

  @Test
  public void testSetMaximumBooks() {
    Person person = new Person();
    person.setMaximumBooks(10);
    Assert.assertEquals(10, person.getMaximumBooks());
  }

  @Test
  public void testGetName() {
    Person person = new Person();
    Assert.assertEquals("unknown name", person.getName());
  }

  @Test
  public void testSetName() {
    Person person = new Person();
    person.setName("Mike");
    Assert.assertEquals("Mike", person.getName());
  }

  @Test
  public void testToString(){
    Person person =  new Person();
    person.setName("Fred Flintstone");
    person.setMaximumBooks(7);
    String testString = "Fred Flintstone (7 books)";
    Assert.assertEquals(testString, person.toString());
  }
}
