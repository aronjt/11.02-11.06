package org.progmatic.nov2;

import java.util.Comparator;

public class fastestAnimalComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        if (o1.getMaxSpeed() - o2.getMaxSpeed() < 0) {
            return 1;
        } else if (o1.getMaxSpeed() - o2.getMaxSpeed() == 0) {
            return 0;
        }
        return -1;
    }
}
