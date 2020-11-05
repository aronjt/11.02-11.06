package org.progmatic.nov4;

public class karakterInt {
    public static void main(String[] args) {
        //firstThousand();
        System.out.println(decoder(68));
        System.out.println(isAlphanumeric('É'));
    }

    //1.

    static void firstThousand() {
        for (int i = 0; i < 100; i++) {
            char c = (char) i;
            System.out.println(c);
        }
    }

    //2.

    static char decoder(int num) {
        char c = (char) num;
        return c;
    }

    //3.

    static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
}
