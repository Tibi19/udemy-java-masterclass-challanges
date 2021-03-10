package com.javamc;

public class Main {

    public static void main(String[] args) {

        IntEqualityPrinter.printEqual(1, 1, 1);
        IntEqualityPrinter.printEqual(1, 1, 2);
        IntEqualityPrinter.printEqual(-1, -1, -1);
        IntEqualityPrinter.printEqual(1, 2, 3);

        System.out.println();

        IntEqualityPrinter.printEqual(1, 1, 1, true);
        System.out.println();
        IntEqualityPrinter.printEqual(1, 1, 2, true);
        System.out.println();
        IntEqualityPrinter.printEqual(-1, -1, -1, false);
        System.out.println();
        IntEqualityPrinter.printEqual(1, 2, 3, true);

    }
}
