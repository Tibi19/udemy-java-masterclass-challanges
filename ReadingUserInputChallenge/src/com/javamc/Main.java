package com.javamc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // CHALLENGE

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        while (count < 10) {
            System.out.println("Enter number #" + (count + 1) + ":");
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                count++;
            } else {
                System.out.println("Invalid Number");
            }
            scanner.nextLine();
        }

        System.out.println("Sum is " + sum);

        scanner.close();
    }
}
