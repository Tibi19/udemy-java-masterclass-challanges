package com.javamc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //firstSolution();
        secondSolution();
    }

    private static void secondSolution() {

        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (true) {

            System.out.print("Enter number: ");

            if (scanner.hasNextInt()) {

                int number = scanner.nextInt();

                min = Math.min(min, number);
                max = Math.max(max, number);

                scanner.nextLine();
            } else {
                System.out.println("Invalid value, exiting loop.");
                scanner.nextLine();
                break;
            }
        }

        System.out.println();

        if (min != Integer.MAX_VALUE) {
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
        } else {
            System.out.println("No numbers entered.");
        }

        scanner.close();
    }

    private static void firstSolution () {

        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 0;
        boolean wereNumbersEntered = false;

        while (true) {

            System.out.print("Enter number: ");

            if (scanner.hasNextInt()) {

                int number = scanner.nextInt();

                if (!wereNumbersEntered) {
                    min = max = number;
                    wereNumbersEntered = true;
                    scanner.nextLine();
                    continue;
                }

                min = Math.min(min, number);
                max = Math.max(max, number);

                scanner.nextLine();
            } else {
                System.out.println("Invalid value, exiting loop.");
                scanner.nextLine();
                break;
            }
        }

        System.out.println();

        if (wereNumbersEntered) {
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
        } else {
            System.out.println("No numbers entered.");
        }

        scanner.close();
    }

}
