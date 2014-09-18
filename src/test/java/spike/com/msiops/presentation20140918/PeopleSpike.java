package spike.com.msiops.presentation20140918;

import com.msiops.presentation20140918.Person;

public final class PeopleSpike {

    public static void main(final String[] args) {

        final Person p = Person.withMother(Person.withFather(Person
                .withFather(Person.withParents(Person.noParents(),
                        Person.noParents()))));
        System.out.println(p.lineage());
        System.out.println(p.maternalGrandfather().lineage());

    }

}
