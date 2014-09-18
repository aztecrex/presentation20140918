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

    private final Person father;

    private final int id;

    private final Person mother;

    private Person(final Person mother, final Person father) {
        this.id = nextId.getAndIncrement();
        this.mother = mother;
        this.father = father;
    }

    public Person getFather() {
        return this.father;
    }

    public Person getMother() {
        return this.mother;
    }

    public String lineage() {

        // @formatter:off
        return new StringBuilder()
        .append(this.id)
        .append(":")
        .append("{")
        .append(this.mother == null ? "" : this.mother.lineage())
        .append(",")
        .append(this.father == null ? "" : this.father.lineage())
        .append("}").toString();
        // @formatter:on

    }

    public Optional<Person> maternalGrandfather() {

        final Person rval;
        if (getMother() != null) {
            rval = getMother().getFather();
        } else {
            rval = null;
        }
        return Optional.ofNullable(rval);

    }

    @Override
    public String toString() {

        return String.valueOf(this.id);

    }
}
