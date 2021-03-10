package com.javamc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        //int[] array = getIntegers(length);
//        int[] array = {56, 7, 34, 9, 81};
//
//        System.out.println("ORIGINAL ARRAY");
//        printArray(array);
//        System.out.println();
//
//        int[] sortedArray = sortIntegers(array);
//
//        System.out.println("UNSORTED ARRAY");
//        printArray(array);
//        System.out.println("SORTED ARRAY");
//        printArray(sortedArray);

        int length = 5;
        printArray(sortIntegers(getIntegers(length)));

        scanner.close();
    }

    private static int[] sortIntegers(int[] values) {
        int[] sortedValues = Arrays.copyOf(values, values.length);
        boolean sorted = false;
        while(!sorted) {
            sorted = true;

            for(int i = 0; i < sortedValues.length - 1; i++) {
                if (sortedValues[i] < sortedValues[i + 1]) {
                    int temp = sortedValues[i];
                    sortedValues[i] = sortedValues[i + 1];
                    sortedValues[i + 1] = temp;

                    sorted = false;
                }
            }
        }

        return sortedValues;
    }

    private static void printArray(int[] array) {
        System.out.print("Array values: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static int[] getIntegers(int length) {
        int[] values = new int[length];
        System.out.println("Input " + length + " integer values:\r");

        for(int i = 0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }

        return values;
    }
}
