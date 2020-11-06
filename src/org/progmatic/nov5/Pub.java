package org.progmatic.nov5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pub {
    double waterCapacity = Double.MAX_VALUE;
    double beerCapacity;
    double wineCapacity;
    double palinkaCapacity;
    int capital;
    List<Person> people = new ArrayList<>();

    public Pub() {
        int help = (int) (Math.random()*10+1);
        for (int i = 0; i < help; i++) {
            people.add(new Person());
        }
    }
    public int meret() {
        return people.size();
    }

    public double getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(double waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public double getBeerCapacity() {
        return beerCapacity;
    }

    public void setBeerCapacity(double beerCapacity) {
        this.beerCapacity = beerCapacity;
    }

    public double getWineCapacity() {
        return wineCapacity;
    }

    public void setWineCapacity(double wineCapacity) {
        this.wineCapacity = wineCapacity;
    }

    public double getPalinkaCapacity() {
        return palinkaCapacity;
    }

    public void setPalinkaCapacity(double palinkaCapacity) {
        this.palinkaCapacity = palinkaCapacity;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void order(Person person) {
        int favoriteDrink = person.getFavoriteDrink();
        Map<Integer, String> drinks = new HashMap<>();
        drinks.put(1, "sör");
        drinks.put(2, "bor");
        drinks.put(3, "pálinka");
        if (person.isThirsty()) {
            if (isAvailable(favoriteDrink)) {
                if (favoriteDrink == 1) {
                    Beer beer = new Beer();
                    beerCapacity -= beer.getPortion();
                    capital += beer.getPrice();
                    System.out.println("Sikeres vásárlás sör, pénztár összege: " + getCapital());
                    person.drink(beer.totalAlcohol());
                } else if (favoriteDrink == 2) {
                    Wine wine = new Wine();
                    wineCapacity -= wine.getPortion();
                    capital += wine.getPrice();
                    System.out.println("Sikeres vásárlás bor, pénztár összege: " + getCapital());
                    person.drink(wine.totalAlcohol());
                } else {
                    Palinka palinka = new Palinka();
                    palinkaCapacity -= palinka.getPortion();
                    capital += palinka.getPrice();
                    System.out.println("Sikeres vásárlás pálinka, pénztár összege: " + getCapital());
                    person.drink(palinka.totalAlcohol());
                }
            } else {
                person.cantOrder();
                angryCheck(person);
                if (!person.isFavoriteDrink()) {
                    for (int i = 1; i < 4; i++) {
                        if (isAvailable(i)) {
                            System.out.println(drinks.get(i) + " tudsz rendelni");
                            person.setFavoriteDrink(i);
                            order(person);
                        }
                    }
                } else {
                    System.out.println("van kedvenc italom nem kérek mást");
                }
            }
        } else {
            System.out.println("Nem volt szomjas");
        }
        person.setTimeSpendMinus();
        person.thirstiness();
    }

    public void angryCheck(Person person) {
        if (person.isAngry()) {
            int damage = (int)(Math.random()*50000+1);
            capital -= damage;
            System.out.println("Nem kapott piát verekdett");
            person.setAngry(false);
            person.setFailOrder(0);
        }
    }

    public boolean isAvailable(int num) {
        if (num == 1 && beerCapacity > 0) {
            return true;
        } else if (num == 2 && wineCapacity > 0) {
            return true;
        } else if (num == 3 && palinkaCapacity > 0) {
            return true;
        }
        return false;
    }

    public void simulation(int round) {
        int start = people.size();
        for (int i = 0; i < round; i++) {
            for (Person person : people) {
                if (person.getTimeSpend() > 0) {
                    order(person);
                    System.out.println(person.getTimeSpend());
                } else {
                    people.remove(person);
                }
            }
            if (people.size() < start) {
                people.add(new Person());
            }
            System.out.println(i + "--------" + people.size());
        }
    }
}
