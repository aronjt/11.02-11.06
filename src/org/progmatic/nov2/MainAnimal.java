package org.progmatic.nov2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainAnimal {

    public static List<Animal> animals;

    static {
        try {
            animals = new ArrayList<>(animals());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
       // System.out.println(animals);
        System.out.println(animalsOccurrence());
    }

    public static List<Animal> animals() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("files/animals.txt"));
        List<Animal> animals = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] splitit = sc.nextLine().split(",");
            double avgWeight = Double.parseDouble(splitit[2]);
            double maxSpeed = Double.parseDouble(splitit[3]);
            double avgAge = Double.parseDouble(splitit[4]);
            Animal animal = new Animal(splitit[0], splitit[1], avgWeight, maxSpeed, avgAge);
            animals.add(animal);
        }
        return animals;
    }

    public static List<String[]> animalsOccurrence() throws FileNotFoundException {
        Scanner sc2 = new Scanner(new File("files/foldresz.txt"));
        List<String[]> animalOcc = new ArrayList<>();
        while (sc2.hasNextLine()) {
            String[] splitit2 = sc2.nextLine().split(",");
            animalOcc.add(splitit2);
        }
        return animalOcc;
    }

    //csinéljak új classt
}
