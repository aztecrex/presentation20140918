package com.msiops.presentation20140918;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private Person p1, p2;

    @Before
    public void setup() {
        this.p1 = Person.noParents();
        this.p2 = Person.noParents();
    }

    @Test
    public void testConstructWithFatherGetFather() {

        assertEquals(this.p1, Person.withFather(this.p1).getFather());

    }

    @Test
    public void testConstructWithFatherHasNoMother() {

        assertNull(Person.withFather(this.p1).getMother());

    }

    @Test
    public void testConstructWithMotherGetMother() {

        assertEquals(this.p1, Person.withMother(this.p1).getMother());

    }

    @Test
    public void testConstructWithMotherHasNoFather() {

        assertNull(Person.withMother(this.p1).getFather());

    }

    @Test
    public void testNoParentsHasNoFather() {

        assertNull(Person.noParents().getFather());

    }

    @Test
    public void testNoParentsHasNoMother() {

        assertNull(Person.noParents().getMother());

    }

    @Test
    public void testWithParentsGetMother() {

        assertEquals(p1, Person.withParents(p1, p2).getMother());

    }

    @Test
    public void testWithParentsGetFather() {

        assertEquals(p2, Person.withParents(p1, p2).getFather());

    }

}
