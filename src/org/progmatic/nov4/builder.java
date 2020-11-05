package org.progmatic.nov4;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class builder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        int lenght = 100;
        String s = "a";
        for (int i = 0; i < lenght; i++) {
            sb.append(s);
        }
        System.out.println(sb);

        String a = "alma";
        String b = "alma";
        System.out.println(a == b);

        List<String> words = new ArrayList<>();
        words.add("Cili");
        words.add("Csaba");
        words.add("Ödön");
        words.add("Olga");
        words.add("Zoli");
        words.add("Czeglédi");

        Collections.sort(words);
        System.out.println(words);
        words.sort(Collator.getInstance());
        System.out.println(words);
    }
}
