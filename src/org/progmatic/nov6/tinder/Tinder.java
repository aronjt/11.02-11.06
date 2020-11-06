package org.progmatic.nov6.tinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tinder {

    private List<Person> people = new ArrayList<>(peopleReader());

    public Tinder() throws FileNotFoundException {
    }

    //Read in

    public List<Person> peopleReader() throws FileNotFoundException {
        List<Person> peopleRead = new ArrayList<>();
        Scanner sc = new Scanner(new File("files/users.txt"));
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            int id = Integer.parseInt(line[0]);
            String name = line[1];
            String sex = line[2];
            int age = Integer.parseInt(line[3]);
            String hairColour = line[4];
            String eyeColour = line[5];
            peopleRead.add(new Person(id, name, sex, age, hairColour, eyeColour));
        }
        sc = new Scanner(new File("files/swipes.txt"));
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            for (Person person : peopleRead) {
                if (person.getId() == Integer.parseInt(line[0])) {
                    person.setSwipes(Integer.parseInt(line[1]), line[2]);
                }
            }
        }
        return peopleRead;
    }

    //Sout

    public void kiir() {
        for (Person person : people) {
            System.out.print(person.getName() + " ");
        }
    }

    //Ki az alkalmazás “királynője”? (Melyik női felhasználót jelölték be a legtöbben kedvencnek?)
    //Ha holtverseny alakul ki, akkor írd ki az összes felhasználó nevét!

    public void queenOfTheApp() {
        int sum = 0;
        int compare = 0;
        int keeper = 0;
        String name = null;
        for (Person person : people) {
            if (person.getSex().equals("FEMALE")) {
                for (Person person1 : people) {
                    if (person.getId() == person1.getId()) {
                        break;
                    } else {
                        for (Integer integer : person1.getSwipes().keySet()) {
                            if (integer == person.getId()) {
                                if (person1.getSwipes().get(integer).equals("LIKE")) {
                                    sum++;
                                    if (sum > compare) {
                                        compare = sum;
                                        name = person.getName();
                                        keeper = sum;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            sum = 0;
        }
        System.out.println("A tinder kurvája " + name + ", " + keeper + " like-al");
    }
}
