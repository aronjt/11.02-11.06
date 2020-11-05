package org.progmatic.nov4;

import java.util.regex.Pattern;

public class karakterekStringben {
    public static void main(String[] args) {
        String line = "Básszalak  meg 69";
        String s = "alma";
        String s2 = "álmatlan";
        countCharacters(line);
        System.out.println(countCharInString(line, 'a'));
       // getOccuringChar(line);
        System.out.println("ennyi eggyezik meg: " + sameChars(s, s2));

    }

    //1.

    public static void countCharacters (String line) {
        char[] chararr = line.toCharArray();
        int wordCount = 0;
        int numCounter = 0;
        int spaceCounter = 0;
        int otherCounter = 0;
        for (char c : chararr) {
            if (c == ' ') {
                spaceCounter++;
            } else if (c >= '0' && c <= '9') {
                numCounter++;
            } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                wordCount++;
            } else {
                otherCounter++;
            }
        }
        System.out.println("ennyi szó: " + wordCount);
        System.out.println("ennyi szám: " + numCounter);
        System.out.println("ennyi space: " + spaceCounter);
        System.out.println("ennyi más: " + otherCounter);
    }

    //2.

    public static int countCharInString (String line, char car) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == car) {
                count++;
            }
        }
        return count;
    }

    //netes cucc

    static void getOccuringChar(String str) {

        int[] count = new int[256];
        int len = str.length();

        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        char[] ch = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1)
                System.out.println("Number of Occurrence of " +
                        str.charAt(i) + " is:" + count[str.charAt(i)]);
        }
    }

    //3.

    static int sameChars(String str1, String str2) {
        int sum = 0;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        if (str1.length() < str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (s1[i] == s2[i]) {
                    sum++;
                }
            }
        } else {
            for (int i = 0; i < str2.length(); i++) {
                if (s2[i] == s1[i]) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
