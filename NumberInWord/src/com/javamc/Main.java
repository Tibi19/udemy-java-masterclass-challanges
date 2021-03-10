package com.javamc;

public class Main {

    public static void main(String[] args) {
        int nr1 = 3;
        int nr2 = 8;
        int nr3 = -5;
        int nr4 = 0;

        NumberInWord.printNumberInWord(3);
        NumberInWord.printNumberInWord(8);
        NumberInWord.printNumberInWord(-5);
        NumberInWord.printNumberInWord(0);
    }
}

class NumberInWord {

    public static void printNumberInWord (int number) {

        if (number < 0 || number > 9) {
            System.out.println("OTHER");
        } else {
            String[] numbersAsWords = {"ZERO", "ONE", "TWO", "THREE",
                    "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
            System.out.println(numbersAsWords[number]);
        }

    }
}
