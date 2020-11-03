package org.progmatic.nov2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainAnimal {

    public static List<Animal> animals;

    static {
        try {
            animals = new ArrayList<>(dataIntoList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
       // System.out.println(animals);
        fastestAnimal(animals);
        fastestAndSlowestFieldAnimals(animals);
        fastestAnimalInEu();
        force();
        weight();
    }

    public static ArrayList<Animal> dataIntoList() throws FileNotFoundException {
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner s = new Scanner(new File("files/animals.txt"));
        for (int i = 0; s.hasNextLine(); i++) {
            String[] row = s.nextLine().split(",");
            String name = row[0];
            String type = row[1];
            String weight = row[2];
            double fweight = Float.parseFloat(weight);
            String speed = row[3];
            double fspeed = Float.parseFloat(speed);
            String age = row[4];
            double fage = Float.parseFloat(age);
            animals.add(new Animal(name, type, fweight, fspeed, fage, new ArrayList<>()));
        }
        Scanner sc = new Scanner(new File("files/foldresz.txt"));
        for (int i = 0; sc.hasNextLine(); i++) {
            String[] row = sc.nextLine().split(",");
            ArrayList<String> continents = new ArrayList<>(Arrays.asList(row).subList(1, row.length));
            for (Animal animal : animals) {
                if (animal.getSpecies().equals(row[0])){
                    animal.setOccurrence(continents);
                    break;
                }
            }
        }
        return animals;
    }

    public static void fastestAnimal(List<Animal> animals) {
        comparatorBySpeed comparator = new comparatorBySpeed();

        animals.sort(comparator);
        System.out.println("A három leggyorsabb állat: " + animals.get(0).getSpecies()+ ", " + animals.get(1).getSpecies() + ", " + animals.get(2).getSpecies());
    }

    public static void fastestAndSlowestFieldAnimals(List<Animal> animals) {
        fastestAnimalComparator comparator = new fastestAnimalComparator();
        slowestAnimalComparator comparator2 = new slowestAnimalComparator();
        animals.sort(comparator);
        int nr = 1;
        for (Animal animal : animals) {
            if (animal.getType().equals("szárazföldi") && nr < 4) {
                System.out.println(animal.getSpecies() + " seb: " + animal.getMaxSpeed());
                nr++;
            }
        }
        animals.sort(comparator2);
        int nm = 1;
        for (Animal animal : animals) {
            if (animal.getType().equals("szárazföldi") && nm < 4) {
                System.out.println(animal.getSpecies() + " seb: " + animal.getMaxSpeed());
                nm++;
            }
        }
    }

    //3. Melyik a három leggyorsabb állat, ami él Európában? És a három leglassabb?

    public static void fastestAnimalInEu() {
        fastestAnimalComparator fastestAnimalComparator = new fastestAnimalComparator();
        slowestAnimalComparator slowestAnimalComparator = new slowestAnimalComparator();
        animals.sort(fastestAnimalComparator);
        int n1 = 1;
        for (Animal animal : animals) {
            if (animal.getOccurrence().contains("Európa") && n1 < 4) {
                    System.out.println(animal.getSpecies() + " sebesség: " + animal.getMaxSpeed());
                    n1++;
            }
        }
        animals.sort(slowestAnimalComparator);
        int n2 = 1;
        for (Animal animal : animals) {
            if (animal.getOccurrence().contains("Európa") && n2 < 4) {
                System.out.println(animal.getSpecies() + " sebesség: " + animal.getMaxSpeed());
                n2++;
            }
        }
    }

    //4. Ha a fenti adatok alapján úgy következtetünk egy állat erejére, hogy a legnagyobb sebességét szorozzuk
    //a állat átlagos tömegével, akkor melyik a három legerősebb állat? És a három leggyengébb?

    public static void force() {
        strongestComparator strongestComparator = new strongestComparator();
        weakestComparator weakestComparator = new weakestComparator();
        animals.sort(strongestComparator);
        int nr1 = 1;
        for (Animal animal : animals) {
            if (nr1 < 4) {
                System.out.println(animal.getSpecies() + " " + animal.getAvgWeight() + " " + animal.getMaxSpeed());
                nr1++;
            }
        }
        animals.sort(weakestComparator);
        int nr2 = 1;
        for (Animal animal : animals) {
            if (nr2 < 4) {
                System.out.println(animal.getSpecies() + " " + animal.getAvgWeight() + " " + animal.getMaxSpeed());
                nr2++;
            }
        }
    }

    public static void weight() {
        weakestComparator comparator = new weakestComparator();
        int n = 1;
        for (Animal animal : animals) {
            if (animal.getAvgWeight() > 50 && n < 4) {
                System.out.println(animal.getSpecies() + " " + animal.getAvgWeight());
                n++;
            }
        }
    }
}
