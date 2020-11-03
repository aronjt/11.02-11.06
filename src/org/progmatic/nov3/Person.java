package org.progmatic.nov3;

import java.util.List;

public class Person {
    private String name;
    private List<String> profession;
    private int year;
    private String bestPromotion;

    public Person(String name, List<String> profession, int year, String bestPromotion) {
        this.name = name;
        this.profession = profession;
        this.year = year;
        this.bestPromotion = bestPromotion;
    }

    public Person(String name, List<String> profession, int year) {
        this.name = name;
        this.profession = profession;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public List<String> getProfession() {
        return profession;
    }

    public int getYear() {
        return year;
    }

    public String getBestPromotion() {
        return bestPromotion;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", profession=" + profession +
                ", year=" + year +
                ", bestPromotion='" + bestPromotion + '\'' +
                '}';
    }
}
