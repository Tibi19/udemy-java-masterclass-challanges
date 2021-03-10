package com.javamc;

public class Main {

    public static void main(String[] args) {

        boolean bool1 = TeenNumberChecker.hasTeen(9, 99, 19);
        boolean bool2 = TeenNumberChecker.hasTeen(23, 15, 42);
        boolean bool3 = TeenNumberChecker.hasTeen(22, 23, 34);

        System.out.println(bool1);
        System.out.println(bool2);
        System.out.println(bool3);
    }
}
