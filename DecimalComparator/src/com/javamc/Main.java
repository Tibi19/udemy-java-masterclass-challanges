package com.javamc;

public class Main {

    public static void main(String[] args) {

        boolean bool1 = DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.175);
        boolean bool2 = DecimalComparator.areEqualByThreeDecimalPlaces(3.175, 3.176);
        boolean bool3 = DecimalComparator.areEqualByThreeDecimalPlaces(3.0, 3.0);
        boolean bool4 = DecimalComparator.areEqualByThreeDecimalPlaces(-3.123, 3.123);

        System.out.println(bool1);
        System.out.println(bool2);
        System.out.println(bool3);
        System.out.println(bool4);
    }
}
