package com.javamc;

public class Main {

    public static void main(String[] args) {

        boolean bark1 = BarkingDog.shouldWakeUp(true, 1);
        boolean bark2 = BarkingDog.shouldWakeUp(false, 2);
        boolean bark3 = BarkingDog.shouldWakeUp(true, 8);
        boolean bark4 = BarkingDog.shouldWakeUp(true, -1);

        System.out.println(bark1);
        System.out.println(bark2);
        System.out.println(bark3);
        System.out.println(bark4);
    }
}
