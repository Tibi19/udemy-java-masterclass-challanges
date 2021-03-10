package com.javamc;

public class Main {

    public static void main(String[] args) {
        System.out.println(NumberPalindrome.isPalindrome(-1221));
        System.out.println(NumberPalindrome.isPalindrome(707));
        System.out.println(NumberPalindrome.isPalindrome(11212));
        System.out.println(NumberPalindrome.isPalindrome(34543));
    }

}

class NumberPalindrome {

    public static boolean isPalindrome (int number) {

        number = Math.abs(number);
        int aux = number;
        int reverse = 0;

        while (aux > 0) {
            reverse *= 10;
            reverse += aux % 10;
            aux /= 10;
        }

        return number == reverse;
    }

}
