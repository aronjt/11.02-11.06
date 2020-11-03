package org.progmatic.nov3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainPerson {

    List<Person> people = peopleReader();

    public MainPerson() throws FileNotFoundException {

    }

    //Olvasd be az adatokat egy megfelelő adatstruktúrába!

    public List<Person> peopleReader() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("files/szemely.txt"));
        Scanner sc2 = new Scanner(new File("files/foglalkozas.txt"));
        List<Person> people = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] splitit = sc.nextLine().split(",");
            String[] splitit2 = sc2.nextLine().split(",");
            String name = splitit[0];
            List<String> profession = new ArrayList<>(Arrays.asList(splitit2));
            profession.remove(0);
            int year = Integer.parseInt(splitit[1]);
            String bestPromotion;
            if (splitit.length > 2) {
                bestPromotion = splitit[2];
                people.add(new Person(name, profession, year, bestPromotion));
            } else {
                people.add(new Person(name, profession, year));
            }
        }
        return people;
    }

    public void kiir (){
        System.out.println(people);
    }

    //Sorold fel ábécérendben a 2013-ban kitüntetettek nevét! Írd meg a feladatot comparator segítségével is!

    public void promotedAfter() {
        people.sort(new orderNameComparator());
        for (Person person : people) {
            if (person.getYear() == 2013) {
                System.out.println(person.getName());
            }
        }
    }

    //Balettel foglalkozó díjazottakra vagyunk kíváncsiak, de többféle ezzel kapcsolatos hivatás létezik.
    //Írasd ki azoknak a nevét és foglalkozását, akik foglalkozási neve tartalmazza a „balett” szórészletet!
    public void balett() {
        for (Person person : people) {
            if (person.getProfession().toString().contains("balett")) {
                System.out.println(person.getName() + " : " + person.getProfession());
            }
        }
    }

    //Melyik évben volt a legtöbb díjazott és hányan voltak?

    public void mostPromoted() {
        Map<Integer, List<Person>> peopleByYear = new HashMap<>();
        for (Person person : people) {
            peopleByYear.putIfAbsent(person.getYear(), new ArrayList<>());
            peopleByYear.get(person.getYear()).add(person);
        }
        int sum = 0;
        int bestYear = 0;
        for (Integer year : peopleByYear.keySet()) {
            if (peopleByYear.get(year).size() > sum) {
                sum = peopleByYear.get(year).size();
                bestYear = year;
            }
        }
        System.out.println(bestYear + " " + sum);
    }

    //Add meg, hogy az egyes foglalkozásnevekhez hány művész tartozik!
    //A képernyőn darabszám szerint csökkenően jelenítsd meg a foglalkozásneveket és a darabszámokat!

    public void professionNum() {
        Map<String, List<String>> peopleByProfession = new HashMap<>();
        for (Person person : people) {
            for (int i = 0; i < person.getProfession().size(); i++) {
                peopleByProfession.putIfAbsent(person.getProfession().get(i), new ArrayList<>());
                peopleByProfession.get(person.getProfession().get(i)).add(person.getName());
            }
        }
        Map<String, Integer> trePeople = new TreeMap<>();
        for (String s : peopleByProfession.keySet()) {
            trePeople.putIfAbsent(s, peopleByProfession.get(s).size());
        }
        System.out.println(trePeople);
    }

    //Sorold fel Pitti Katalinnal együtt azoknak a nevét és a kitüntetés évét, akik vele azonos foglalkozásúak!

    public void pittiKatalin() {
        List<String> profession = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().equals("Pitti Katalin")) {
                profession = person.getProfession();
            }
        }
        for (Person person : people) {
            if (person.getProfession().toString().contains(profession.toString())) {
                System.out.println(person.getName() + " " + person.getYear());
            }
        }
    }

    //Határozd meg, hogy a grafikusoknak milyen más foglalkozásaik vannak még!
    //A listában a „grafikus” foglalkozásnév már ne szerepeljen, és minden foglalkozás neve egyszer jelenjen meg!

    public void graphicElseJob() {
        Set<String> jobs = new HashSet<>();
        for (Person person : people) {
            String job = person.getProfession().toString();
            if (job.contains("grafikus")) {
                jobs.add(job);
                System.out.println(job);
            }
        }
       // System.out.println(jobs);
    }

}
