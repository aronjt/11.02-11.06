package org.progmatic.nov2;

import java.util.Comparator;

public class weakestComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        if (o2.getMaxSpeed()*o2.getAvgWeight() - o1.getMaxSpeed()*o1.getAvgWeight() < 0) {
            return 1;
        } else if (o1.getMaxSpeed()*o1.getAvgWeight() - o2.getMaxSpeed()*o2.getAvgWeight() == 0) {
            return 0;
        }
        return -1;
    }
}
