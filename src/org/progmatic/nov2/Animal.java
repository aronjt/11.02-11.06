package org.progmatic.nov2;

import java.util.List;

public class Animal {
    private String species;
    private String type;
    private double avgWeight;
    private double maxSpeed;
    private double avgAge;
    private List<String[]> occurrence;

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public double getAvgWeight() {
        return avgWeight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getAvgAge() {
        return avgAge;
    }

    public List<String[]> getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(List<String[]> occurrence) {
        this.occurrence = occurrence;
    }

    public Animal(String species, String type, double avgWeight, double maxSpeed, double avgAge) {
        this.species = species;
        this.type = type;
        this.avgWeight = avgWeight;
        this.maxSpeed = maxSpeed;
        this.avgAge = avgAge;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", avgWeight=" + avgWeight +
                ", maxSpeed=" + maxSpeed +
                ", avgAge=" + avgAge +
                ", occurrence=" + occurrence +
                '}';
    }
}
