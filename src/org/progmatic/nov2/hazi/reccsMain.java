package org.progmatic.nov2.hazi;

import java.io.FileNotFoundException;

public class reccsMain {
    public static void main(String[] args) throws FileNotFoundException {
        Reccsegi reccsegi = new Reccsegi();
        reccsegi.candidatesReader();
    }
}
