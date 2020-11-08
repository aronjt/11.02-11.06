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
                    if (person.getId() != person1.getId()) {
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

    //Melyik felhasználó a legválogatósabb? (Melyik felhasználónál a legkisebb az az arány,
    //hogy hány felhasználót jelölt szimpatikusnak az összes jelöléséhez képest.)

    public void pickyUser() {
        double rate = 1.0;
        int totalSwipes;
        int totalLikes = 0;
        String name = null;
        for (Person person : people) {
            totalSwipes = person.getSwipes().size();
            for (Integer key : person.getSwipes().keySet()) {
                if (person.getSwipes().get(key).equals("LIKE")) {
                    totalLikes++;
                }
            }
            if ((double) totalLikes / totalSwipes < rate && (double) totalLikes / totalSwipes > 0) {
                rate = (double) totalLikes / totalSwipes;
                name = person.getName();
            }
            totalLikes = 0;
        }
        System.out.println("A legválógatósabb felhasználó: " + name + " " + rate);
    }

    //Hány olyan elkeseredett felhasználó volt, aki mindenkit szimpatikusnak jelölt?
    //(Azaz nem volt DISLIKE jelölése, csak LIKE.)

    public void gotNoType() {
        int usersNum = 0;
        int totalSwipes;
        int totalLikes = 0;
        for (Person person : people) {
            totalSwipes = person.getSwipes().size();
            for (Integer key : person.getSwipes().keySet()) {
                if (person.getSwipes().get(key).equals("LIKE")) {
                    totalLikes++;
                }
            }
            if (totalLikes == totalSwipes) {
                usersNum++;
            }
            totalLikes = 0;
        }
        System.out.println("Összesen " + usersNum + " elkeseredett felhasználó volt.");
    }

    //Hány olyan felhasználó volt, akit senki sem húzott jobbra az alkalmazásban?

    public void ugly() {
        int uglies = 0;
        int likes;
        int dislikes;
        List<String> names = new ArrayList<>();
        for (Person person : people) {
            likes = 0;
            dislikes = 0;
            for (Person person1 : people) {
                if (person.getId() != person1.getId()) {
                    for (Integer key : person1.getSwipes().keySet()) {
                        if (key == person.getId()) {
                            if (person1.getSwipes().get(key).equals("LIKE")) {
                                likes++;
                            } else {
                                dislikes++;
                            }
                        }
                    }
                }
            }
            if (likes == 0 && dislikes > 0) {
                uglies++;
                names.add(person.getName());
            }
        }
        System.out.println(uglies + " csúnnya ember volt, akit senki sem húzott jobbra." + names);
    }

    //Hány “match” van a felhasználók között a jelenlegi állapot szerint? (Match-nek hívjuk azt az állapotot,
    //amikor két felhasználó egymást kölcsönösen szimpatikusnak jelöli.)

    public void matches() {
        int matches = 0;
        for (Person person : people) {
            for (Person person1 : people) {
                if (person.getId() != person1.getId()) {
                    for (Integer key : person.getSwipes().keySet()) {
                       if (key == person1.getId()) {
                           for (Integer key1 : person1.getSwipes().keySet()) {
                               if (key1 == person.getId() && person.getSwipes().get(key).equals("LIKE") && person1.getSwipes().get(key1).equals("LIKE")) {
                                   matches++;
                               }
                           }
                       }
                    }
                }
            }
        }
        System.out.println("Ennyi match volt: " + matches/2);
    }

    //Hány olyan kék szemű felhasználó van, aki több szőke felhasználót húzott jobbra, mint barna hajút balra?

    public void blueEyed() {
        int userSum = 0;
        for (Person person : people) {
            int blondeLike = 0;
            int brownDislike = 0;
            if (person.getEyeColour().equals("BLUE")) {
                for (Person person1 : people) {
                    if (person.getId() != person1.getId()) {
                        for (Integer key : person.getSwipes().keySet()) {
                            if (person.getSwipes().get(key).equals("LIKE") && key == person1.getId() && person1.getHairColour().equals("BLONDE")) {
                                blondeLike++;
                            } else if (person.getSwipes().get(key).equals("DISLIKE") && key == person1.getId() && person1.getHairColour().equals("BROWN")) {
                                brownDislike++;
                            }
                        }
                    }
                }
            }
            if (blondeLike > brownDislike) {
                userSum++;
            }
        }
        System.out.println(userSum + " kék szemű felhasználó van, aki több szőke felhasználót húzott jobbra, mint barna hajút balra");
    }
}
