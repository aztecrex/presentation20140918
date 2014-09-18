package com.msiops.presentation20140918;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public final class Person {

    private static AtomicInteger nextId = new AtomicInteger();

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

    private final Optional<Person> father;

    private final int id;

    private final Optional<Person> mother;

    private Person(final Person mother, final Person father) {
        this.id = nextId.getAndIncrement();
        this.mother = Optional.ofNullable(mother);
        this.father = Optional.ofNullable(father);
    }

    public Optional<Person> getFather() {
        return this.father;
    }

    public Optional<Person> getMother() {
        return this.mother;
    }

    public String lineage() {

        // @formatter:off
        return new StringBuilder()
        .append(this.id)
        .append(":")
        .append("{")
        .append(this.mother.map(Person::lineage).orElse(""))
        .append(",")
        .append(this.father.map(Person::lineage).orElse(""))
        .append("}").toString();
        // @formatter:on

    }

    public Optional<Person> maternalGrandfather() {

        return getMother().flatMap(Person::getFather);

    }

    @Override
    public String toString() {

        return String.valueOf(this.id);

    }
}
