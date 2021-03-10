package com.javamc;

public class Main {

    public static void main(String[] args) {

        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));
    }

    public static boolean hasSharedDigit (int x, int y) {

        if (x < 10 || x > 99) {
            return false;
        }

        if (y < 10 || y > 99) {
            return false;
        }

        int aux = y;
        for (int i = 0; i < 2; i++){
            int lastDigitX = x % 10;
            x /= 10;
            for (int j = 0; j < 2; j++) {
                int lastDigitY = y % 10;
                y /= 10;
                if (lastDigitX == lastDigitY) {
                    return true;
                }
            }
            y = aux;
        }

        return false;
    }
}
