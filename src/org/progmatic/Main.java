package org.progmatic;

import org.progmatic.nov3.MainPerson;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        MainPerson people = new MainPerson();
        //1.
        people.peopleReader();
        //2.
        //people.promotedAfter();
        //3.
        people.balett();
        //4.
        people.mostPromoted();
        //5.
        people.professionNum();
        //6.
        people.pittiKatalin();
    }
}
