package com.msiops.presentation20140918;

import java.util.Objects;

public final class Person {

    public static Person noParents() {
        return new Person(null, null);
    }

    public static Person withFather(final Person f) {
        return new Person(null, Objects.requireNonNull(f));
    }

    public static Person withMother(final Person m) {
        return new Person(Objects.requireNonNull(m), null);
    }

    public static Person withParents(final Person m, final Person f) {
        return new Person(Objects.requireNonNull(m), Objects.requireNonNull(f));
    }

    private final Person father;

    private final Person mother;

    private Person(final Person mother, final Person father) {
        this.mother = mother;
        this.father = father;
    }

    public Person getFather() {
        return this.father;
    }

    public Person getMother() {
        return this.mother;
    }

    public Person maternalGrandfather() {

        return getMother().getFather();

    }

}
