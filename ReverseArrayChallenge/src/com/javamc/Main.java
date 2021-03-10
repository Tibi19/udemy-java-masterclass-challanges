package com.javamc;

import java.util.Arrays;

// CHALLENGE

public class Main {

    public static void main(String[] args) {
	    int[] array = {5, 2, 11, 34, 89, 99, 101, 2, 34, 82};
	    int[] origArray = Arrays.copyOf(array, array.length);

        System.out.println("Original array: " + Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed array: " + Arrays.toString(array));

        System.out.println();
        System.out.println("Is the original array reversed? " + isReversed(origArray, array));
    }

    // Reverses the positions of @array's values.
    // 1st value changes positions with the last, 2nd with last - 1 and so on.
    private static void reverse(int[] array) {
        for(int i = 0; i < array.length / 2; i++) {
            int targetPosition = array.length - 1 - i;
            int temp = array[i];
            array[i] = array[targetPosition];
            array[targetPosition] = temp;
        }
    }

    // Returns true if @targetArray is the reverse array of @origArray.
    private static boolean isReversed(int[] origArray, int[] targetArray) {
        if(origArray.length != targetArray.length) {
            return false;
        }

        int length = targetArray.length;
        for(int i = 0; i < length / 2; i++) {
            if(origArray[i] != targetArray[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
