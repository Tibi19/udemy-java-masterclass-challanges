package com.javamc;

public class IntEqualityPrinter {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";
    private static final String EQUAL_VALUES_MESSAGE = "All numbers are equal";
    private static final String DIFFERENT_VALUES_MESSAGE = "All numbers are different";
    private static final String NEITHER_EQUAL_NOR_DIFFERENT_VALUES_MESSAGE = "Neither all are equal or different";

    public static void printEqual (int x, int y, int z) {

        if (x < 0 || y < 0 || z < 0) {
            System.out.println(INVALID_VALUE_MESSAGE);
        } else {
            int[] parameters = {x, y, z};   // An array of the parameters.
            int howManyPairsAreEqual = 0;   // How many pairs of numbers between the given parameters are equal.
            final int ALL_PAIRS_EQUAL_VALUE = 3;  // Value of howManyPairsAreEqual if all pairs of parameters are equal.
            final int ALL_PAIRS_DIFFERENT_VALUE = 0;  // Value of howManyPairsAreEqual if all pairs of parameters are different.

            // Calculate how many pairs are equal.
            for (int i = 0; i < parameters.length - 1; i++) {
                for (int j = i + 1; j < parameters.length; j++) {

                    // If it's a pair of equal parameters, increment howManyPairsAreEqual.
                    howManyPairsAreEqual += parameters[i] == parameters[j] ? 1 : 0;

                }
            }

            // Compare howManyPairsAreEqual with the equality values and print the appropriate message.
            if (howManyPairsAreEqual == ALL_PAIRS_EQUAL_VALUE) {
                System.out.println(EQUAL_VALUES_MESSAGE);
            } else if (howManyPairsAreEqual == ALL_PAIRS_DIFFERENT_VALUE) {
                System.out.println(DIFFERENT_VALUES_MESSAGE);
            } else {
                System.out.println(NEITHER_EQUAL_NOR_DIFFERENT_VALUES_MESSAGE);
            }
        }

    }

    public static void printEqual (int x, int y, int z, boolean isThisMethodBoring) {

        if (isThisMethodBoring) {
            System.out.println("Yes, this method is boring!");
        } else {
            System.out.println("No, this method IS boring!");
        }

        if (x < 0 || y < 0 || z < 0) {
            System.out.println(INVALID_VALUE_MESSAGE);
        } else if (x == y && x == z) {
            System.out.println(EQUAL_VALUES_MESSAGE);
        } else if (x != y && x != z && y != z) {
            System.out.println(DIFFERENT_VALUES_MESSAGE);
        } else {
            System.out.println(NEITHER_EQUAL_NOR_DIFFERENT_VALUES_MESSAGE);
        }

    }
}
