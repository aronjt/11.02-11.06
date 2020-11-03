package org.progmatic.nov2.hazi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reccsegi {
    List<Candidate> candidates = candidatesReader();

    public Reccsegi() throws FileNotFoundException {

    }

    public List<Candidate> candidatesReader() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("files/szavazatok.txt"));
        List<Candidate> candidates = new ArrayList<>();
        while (sc.hasNextLine()) {
            int constituency = sc.nextInt();
            int votes = sc.nextInt();
            String lastName = sc.next();
            String firstName = sc.next();
            String party = sc.next();
            candidates.add(new Candidate(constituency, votes, lastName, firstName, party));
        }
        return candidates;
    }

    public void outPrint() {
        System.out.println(candidates);
    }
}
