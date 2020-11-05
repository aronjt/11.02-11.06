package org.progmatic.nov4;

public class Ceasar {
    public static void main(String[] args) {
        System.out.println(encrypt("AbC", 1));
    }

    static StringBuffer encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char ch = (char) ((int) text.charAt(i) + s);
            result.append(ch);
        }
        return result;
    }
}
