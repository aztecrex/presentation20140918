package spike.com.msiops.presentation20140918;

import com.msiops.presentation20140918.Person;

public final class PeopleSpike {

    public static void main(final String[] args) {

        final Person p = Person.withMother(Person.withFather(Person
                .withFather(Person.withParents(Person.noParents(),
                        Person.noParents()))));

        System.out.println(p.maternalGrandfather().map(Person::lineage)
                .orElse("p has no maternal grandfather"));

        final Person p2 = Person.noParents();
        System.out.println(p2.maternalGrandfather().map(Person::lineage)
                .orElse("p2 has no maternal grandfather"));
    }

}
