package org.progmatic.nov3;

import java.util.Comparator;

public class orderNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
