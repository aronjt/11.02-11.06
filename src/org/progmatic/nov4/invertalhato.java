package org.progmatic.nov4;

import java.util.Arrays;

public class invertalhato {
    public static void main(String[] args) {
        String[] stringArray = {"Mézga-család", "hello", "Mz/x"};
        System.out.println(join(stringArray));
        System.out.println(Arrays.toString(split(join(stringArray))));

    }

    static String join (String[] stringArray) {
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }

    public static String[] split(String str) {
        return str.split(" ");
    }
}
