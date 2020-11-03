package org.progmatic.nov2;

import java.util.Comparator;

public class slowestTypeAnimalComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        if (o1.getType().equals("szárazföldi") && o2.getType().equals("szárazföldi")) {
            return (int) (-1 * (o1.getMaxSpeed() - o2.getMaxSpeed()));
        }
        return 1;
    }
}
