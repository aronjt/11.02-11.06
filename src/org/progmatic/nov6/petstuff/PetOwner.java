package org.progmatic.nov6.petstuff;

import java.util.ArrayList;
import java.util.List;

public class PetOwner {
    private String name;
    private int age;
    private String sex;
    private List<Integer> petsID;
    private List<Pet> pets = new ArrayList<>();

    public PetOwner(String name, int age, String sex, List<Integer> petsID) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.petsID = petsID;
    }

    public int getPetCount() {
        return pets.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(Pet pet) {
        pets.add(pet);
    }

    public List<Integer> getPetsID() {
        return petsID;
    }

    public void setPetsID(List<Integer> petsID) {
        this.petsID = petsID;
    }

    @Override
    public String toString() {
        return "PetOwner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", petsID=" + petsID +
                ", pets=" + pets +
                '}';
    }
}
