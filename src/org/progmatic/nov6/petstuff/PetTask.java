package org.progmatic.nov6.petstuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetTask {

    private List<PetOwner> petOwners = new ArrayList<>(petOwnerReader());
    private List<Pet> pets = new ArrayList<>(petReader());

    public PetTask() throws FileNotFoundException {

    }

    //Állattartó kiírása

    public void soutPetOwner() {
        for (PetOwner owner : petOwners) {
            System.out.print(owner.getName() + " " + owner.getAge() + " : ");
            for (int i = 0; i < owner.getPets().size(); i++) {
                System.out.print(owner.getPets().get(i).getName() + ", ");
            }
            System.out.println();
        }
    }

    //Állatok kiírása

    public void soutPet() {
        for (Pet pet : pets) {
            System.out.println(pet.getOwner().getName() + " : " + pet.getName() + " " + pet.getAge());
        }
    }

    //Állattartól beolvasása

    public List<PetOwner> petOwnerReader() throws FileNotFoundException {
        List<PetOwner> petOwners = new ArrayList<>();
        Scanner sc = new Scanner(new File("files/petowners.txt"));
        while (sc.hasNextLine()) {
            String[] readLine = sc.nextLine().split(",");
            String name = readLine[0];
            int age = Integer.parseInt(readLine[1]);
            String sex = readLine[2];
            List<Integer> pets = new ArrayList<>();
            for (int i = 3; i < readLine.length; i++) {
                pets.add(Integer.parseInt(readLine[i]));
            }
            petOwners.add(new PetOwner(name, age, sex, pets));
        }
        return petOwners;
    }

    //Állatok beolvasása

    public List<Pet> petReader() throws FileNotFoundException {
        List<Pet> pets = new ArrayList<>();
        Scanner sc = new Scanner(new File("files/pets.txt"));
        while (sc.hasNextLine()) {
            String[] readLine = sc.nextLine().split(",");
            int ID = Integer.parseInt(readLine[0]);
            String name = readLine[1];
            String species = readLine[2];
            int age = Integer.parseInt(readLine[3]);
            pets.add(new Pet(ID, name, species, age));
        }
        return pets;
    }

    //Összekapcsolom az állatot a tartóval
    public void mergePetOwnerWithPet() {
        for (PetOwner petOwner : petOwners) {
            for (Pet pet : pets) {
                if (petOwner.getPetsID().contains(pet.getId())) {
                    petOwner.setPets(pet);
                    pet.setOwner(petOwner);
                }
            }
        }
    }

    //Állattartók kora szerinti növekvő sorrendbe rendezve kiírja az állattartókat és
    //állataikat!

    public void petOwnerSortedAge() {
        PetOwnerAgeComparator comparator = new PetOwnerAgeComparator();
        petOwners.sort(comparator);
    }

    //Állatok kora szerinti növekvő sorrendbe rendezve kiírja az állattartókat és állataikat!

    public void petSortedAge() {
        PetAgeComparator comparator = new PetAgeComparator();
        pets.sort(comparator);
    }

    //Listázza azokat az állattartókat, akiknek van legalább egy náluk idősebb
    //házikedvence!

    public void petOlderThanOwner() {
        for (Pet pet : pets) {
            if (pet.getAge() > pet.getOwner().getAge()) {
                System.out.println(pet.getOwner().getName());
            }
        }
    }

    //Kérd be a felhasználótól egy háziállat nevét! Valósíts meg egy metódust, amely
    //visszaadja az adott nevű háziállat gazdáját!

    public void searchPetByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Írj be egy állat nevet: ");
        String name = sc.nextLine();
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                System.out.println(name + " gazdija: " + pet.getOwner().getName());
            }
        }
    }

    //Kérd be a felhasználótól egy állattartó nevét! Valósíts meg egy metódust, amely
    //visszaadja az adott nevű állattartó házikedvenceit, életkor szerinti csökkenő
    //sorrendben!

    //Melyik állattartónak van a legtöbb házikedvence?

    public void biggestPetOwner() {
        int sum = 0;
        String name = null;
        for (PetOwner owner : petOwners) {
            if (owner.getPets().size() > sum) {
                sum = owner.getPets().size();
                name = owner.getName();
            }
        }
        System.out.println("Legtöbb állata neki van: " + name);
    }
}
