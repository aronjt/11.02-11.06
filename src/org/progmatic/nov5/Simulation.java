package org.progmatic.nov5;

public class Simulation {
    public static void main(String[] args) {
        Person faszi = new Person();
        Pub kocsma = new Pub();
        kocsma.setBeerCapacity(300);
        kocsma.setWineCapacity(300);
        kocsma.setPalinkaCapacity(300);
        kocsma.simulation(30);
    }
}
