package com.javamc;

public class Main {

    public static void main(String[] args) {

        printSquareStar(5);
        System.out.println();
        printSquareStar(8);
        System.out.println();
        printSquareStar(36);
        System.out.println();
        printSquareStar(100);

    }

    public static void printSquareStar (int number) {

        final String STAR = "*";

        if (number < 5) {
            System.out.println("Invalid Value");
        } else {

            for (int i = 0; i < number; i++) {

                for (int j = 0; j < number; j++) {

                    if (i == 0 || i == number - 1) {
                        System.out.print(STAR);
                        continue;
                    }

                    if (j == 0 || j == number - 1) {
                        System.out.print(STAR);
                        continue;
                    }

                    if (i == j) {
                        System.out.print(STAR);
                        continue;
                    }

                    if (j == number - i - 1) {
                        System.out.print(STAR);
                        continue;
                    }

                    System.out.print(" ");
                }

                System.out.println();
            }
        }
    }

}
