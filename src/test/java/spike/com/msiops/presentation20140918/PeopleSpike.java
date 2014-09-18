package spike.com.msiops.presentation20140918;

import com.msiops.presentation20140918.Person;

public final class PeopleSpike {

    public static void main(final String[] args) {

        final Person p = Person.withMother(Person.withFather(Person
                .withFather(Person.withParents(Person.noParents(),
                        Person.noParents()))));
        System.out.println(p.lineage());
        System.out.println(p.maternalGrandfather().lineage());

        final Person p2 = Person.noParents();

        // System.out.println(p2.maternalGrandfather().lineage()); // <-- NPE!
        final Person p2mg = p2.maternalGrandfather();
        if (p2mg != null) {
            System.out.println(p2mg.lineage());
        } else {
            System.out.println("p2 has no maternal grandfather");
        }

    }

}
