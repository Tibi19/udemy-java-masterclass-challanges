package com.javamc;

import java.awt.geom.AffineTransform;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // CHALLENGE

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("How many integers to input: ");
        int count = scanner.nextInt();

        int minimumValue = findMin(readIntegers(count));

        System.out.println("The lowest value in the array is " + minimumValue);

        scanner.close();
    }

    // Returns the lowest value in @array.
    public static int findMin(int[] array) {
        final int ERROR_INDICATOR_VALUE = -1;

        if(array == null) {
            return ERROR_INDICATOR_VALUE;
        }

        // If both the 1st and last elements of a sorted array are 0,
        // The array has not been initialized, return error indicator.
        Arrays.sort(array);
        if(array[0] == 0 && array[array.length - 1] == 0) {
            return ERROR_INDICATOR_VALUE;
        }

        int min = array[0];

        for(int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }

    // Returns an array that represents @count numbers the user inputs.
    public static int[] readIntegers(int count) {
        int[] array = new int[count];

        System.out.println("Input " + count + " numbers: ");
        for(int i = 0; i < count; i++){
            array[i] = scanner.nextInt();
        }

        return array;
    }
}
