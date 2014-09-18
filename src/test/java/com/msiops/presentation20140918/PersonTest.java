package com.msiops.presentation20140918;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public final class PersonTest {

    private Person p1, p2;

    @Before
    public void setup() {
        this.p1 = Person.noParents();
        this.p2 = Person.noParents();
    }

    @Test
    public void testConstructWithFatherGetFather() {

        assertEquals(this.p1, Person.withFather(this.p1).getFather().get());

    }

    @Test
    public void testConstructWithFatherHasNoMother() {

        assertFalse(Person.withFather(this.p1).getMother().isPresent());

    }

    @Test
    public void testConstructWithMotherGetMother() {

        assertEquals(this.p1, Person.withMother(this.p1).getMother().get());

    }

    @Test
    public void testConstructWithMotherHasNoFather() {

        assertFalse(Person.withMother(this.p1).getFather().isPresent());

    }

    @Test
    public void testMaternalGrandfather() {

        assertEquals(this.p1, Person.withMother(Person.withFather(this.p1))
                .maternalGrandfather().get());

    }

    @Test
    public void testMaternalGrandfatherMotherWithoutFather() {

        // one way to test
        assertFalse("should not have grandfather",
                Person.withMother(Person.noParents()).maternalGrandfather()
                        .isPresent());

    }

    @Test
    public void testMaternalGrandfatherNoMother() {

        // another way to test
        Person.withMother(Person.noParents()).maternalGrandfather()
                .ifPresent(p -> fail("shold not have grandfather"));

    }

    @Test
    public void testNoParentsHasNoFather() {

        assertFalse(Person.noParents().getFather().isPresent());

    }

    @Test
    public void testNoParentsHasNoMother() {

        assertFalse(Person.noParents().getMother().isPresent());

    }

    @Test(expected = NullPointerException.class)
    public void testWithFatherNullFails() {

        Person.withFather(null);

    }

    @Test(expected = NullPointerException.class)
    public void testWithMotherNullFails() {

        Person.withMother(null);

    }

    @Test
    public void testWithParentsGetFather() {

        assertEquals(this.p2, Person.withParents(this.p1, this.p2).getFather()
                .get());

    }

    @Test
    public void testWithParentsGetMother() {

        assertEquals(this.p1, Person.withParents(this.p1, this.p2).getMother()
                .get());

    }

    @Test(expected = NullPointerException.class)
    public void testWithParentsNullFatherFails() {

        Person.withParents(this.p1, null);

    }

    @Test(expected = NullPointerException.class)
    public void testWithParentsNullMotherFails() {

        Person.withParents(null, this.p1);

    }

}
