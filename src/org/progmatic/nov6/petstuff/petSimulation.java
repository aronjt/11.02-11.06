package org.progmatic.nov6.petstuff;

import java.io.FileNotFoundException;

public class petSimulation {

    public static void main(String[] args) throws FileNotFoundException {
        PetTask petfasz = new PetTask();
        petfasz.mergePetOwnerWithPet();
        petfasz.petOwnerSortedAge();
        petfasz.soutPetOwner();
        System.out.println("------------");
        petfasz.petSortedAge();
        petfasz.soutPet();
        System.out.println("------------");
        petfasz.petOlderThanOwner();
        System.out.println("------------");
        petfasz.searchPetByName();
        System.out.println("------------");
        petfasz.biggestPetOwner();
    }
}
