package com.msiops.presentation20140918;

public final class Person {

    private final Person father;

    private final Person mother;

    private Person(Person mother, Person father) {
        this.mother = mother;
        this.father = father;
    }

    public Person getFather() {
        return this.father;
    }

    public Person getMother() {
        return this.mother;
    }

    public static Person noParents() {
        return new Person(null, null);
    }

    public static Person withMother(Person m) {
        return new Person(m, null);
    }

    public static Person withFather(Person f) {
        return new Person(null, f);
    }

    public static Person withParents(Person m, Person f) {
        return new Person(m, f);
    }

}
