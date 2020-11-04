package org.progmatic.nov3;

import java.util.Comparator;

public class orderPromoted implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getYear() != 2013 && o2.getYear() != 2013) {
            return 0;
        }
        if (o1.getYear() != 2013 && o2.getYear() == 2013) {
            return 1;
        }
        if (o1.getYear() == 2013 && o2.getYear() != 2013) {
            return -1;
        }
        return o1.getName().compareTo(o2.getName());
    }
}
