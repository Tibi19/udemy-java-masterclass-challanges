package com.javamc;

public class Main {

    public static void main(String[] args) {
        System.out.println(getDigitCount(0));
        System.out.println(getDigitCount(123));
        System.out.println(getDigitCount(-12));
        System.out.println(getDigitCount(5200));
        System.out.println();
        System.out.println(reverse(-121));
        System.out.println(reverse(1212));
        System.out.println(reverse(1234));
        System.out.println(reverse(1));
        System.out.println();
        numberToWords(123);
        numberToWords(1010);
        numberToWords(1000);
        numberToWords(-12);
        System.out.println();
        System.out.println(-25%10);
    }

    public static int getDigitCount(int number) {

        // Validate for positive numbers.
        if (number < 0) {
            return -1;
        }

        int digitCount = 0;

        // Do-while so we can increment digitCount at least once,
        // To increment it even if number is 0.
        //
        // If we were to start with a digitCount of 1 and use a while,
        // The loop would increment for any number with a single digit,
        // Leaving us with a digitCount of 2.
        do {
            digitCount++;
            number /= 10;
        } while (number > 0);

        return digitCount;
    }

    public static int reverse (int number) {

        int reverse = 0;

        // Compute reverse.
        while (number != 0) {
            reverse *= 10; // Modify reverse by multiplying with 10 to make room for another digit.
            reverse += number % 10;  // Add the last digit of number to reverse.
            number /= 10;   // Modify number by taking out the last digit.
        }

        return reverse ;
    }

    public static void numberToWords (int number) {

        // To print every digit of number in order,
        // We will need to iterate each last digit of its reverse
        // And add that digit as a word to a string.
        // We will print the resulting string.

        // We will store "Zero" multiple times.
        // Therefore, we will store it in a final variable as we don't need to change it.
        final String ZERO_AS_STRING = "Zero";

        if (number < 0) {
            System.out.println("Invalid Value");
        } else if (number == 0) {
            System.out.println(ZERO_AS_STRING);
        } else {

            int reverse = reverse(number);
            int digitsCountNumber = getDigitCount(number);
            int digitsCountReverse = getDigitCount(reverse);
            String numberToWord = "";

            // An array of all digits as words.
            // Each digit corresponds to its index.
            // e.g. "Five" corresponds to the position 5 of the array.
            String[] digitsAsWords = {ZERO_AS_STRING, "One", "Two", "Three",
                    "Four", "Five", "Six", "Seven", "Eight", "Nine"};

            // Iterate each last digit of reverse.
            while (reverse > 0) {
                 int lastDigit = reverse % 10;

                 // Add the last digit as a word to numberToWord.
                 // Add a space to make room for the next digit.
                 numberToWord += (digitsAsWords [lastDigit] + " ");

                 reverse /= 10;
            }

            // If there are more digits in number than in its reverse,
            // Then it means the difference in digits is represented by zeros and
            // We need to add them to our word as well.
            for (int i = 0; i < digitsCountNumber - digitsCountReverse; i++) {
                // Add "Zero" and a space to make room for the next "Zero";
                numberToWord += (ZERO_AS_STRING + " ");
            }

            // Our current word has a space at the end.
            // We take the space out by replacing the word with its substring
            // That starts at position 0, and ends one character before the last (word's length - 1).
            numberToWord = numberToWord.substring(0, numberToWord.length() - 1);

            System.out.println(numberToWord);
        }
    }

}
