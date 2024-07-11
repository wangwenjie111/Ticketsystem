package org.example;//tested by Xingcai Zhang 34355979

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testPersonCreation() {
        Person person = new Person("John", "Doe", 25, "Man") {
        };
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getSecondName());
        assertEquals(25, person.getAge());
        assertEquals("Man", person.getGender());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGender() {
        Person person = new Person();
        person.setGender("InvalidGender");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        Person person = new Person();
        person.setFirstName("123John");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSecondName() {
        Person person = new Person();
        person.setSecondName("Doe@");
    }

    @Test
    public void testValidGender0() {
        Person person = new Person();
        person.setGender("Non-binary | gender diverse");
        assertEquals("Non-binary | gender diverse", person.getGender());
    }

    @Test
    public void testValidGender1() {
        Person person = new Person();
        person.setGender("Prefer not to say");
        assertEquals("Prefer not to say", person.getGender());
    }

    @Test
    public void testValidGender2() {
        Person person = new Person();
        person.setGender("Other");
        assertEquals("Other", person.getGender());
    }

    @Test
    public void testValidGender3() {
        Person person = new Person();
        person.setGender("Woman");
        assertEquals("Woman", person.getGender());
    }

    @Test
    public void testValidGender4() {
        Person person = new Person();
        person.setGender("Man");
        assertEquals("Man", person.getGender());
    }

    @Test
    public void testValidFirstName() {
        Person person = new Person();
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName());
    }

    @Test
    public void testValidSecondName() {
        Person person = new Person();
        person.setSecondName("Smith");
        assertEquals("Smith", person.getSecondName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAge() {
        Person person = new Person();
        person.setAge(-5);
    }

    @Test
    public void testValidAge() {
        Person person = new Person();
        person.setAge(30);
        assertEquals(30, person.getAge());
    }
}
