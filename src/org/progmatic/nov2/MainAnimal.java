package org.progmatic.nov2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainAnimal {

   // public static List<Animal> animals;


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(dataIntoList());
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
            String name = row[0];
            ArrayList<String> continents = new ArrayList<>();
            for (int j = 1; j < row.length; j++) {
                continents.add(row[j]);
            }
            for (Animal animal : animals) {
                if (animal.getSpecies().equals(row[0])){
                    animal.setOccurrence(continents);
                    break;
                }
            }
        }
        return animals;
    }

}
