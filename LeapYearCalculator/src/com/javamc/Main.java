package com.javamc;

public class Main {

    public static void main(String[] args) {

        int year1 = -1600;
        int year2 = 1600;
        int year3 = 2017;
        int year4 = 2000;

        System.out.println(LeapYear.isLeapYear(year1));
        System.out.println(LeapYear.isLeapYear(year2));
        System.out.println(LeapYear.isLeapYear(year3));
        System.out.println(LeapYear.isLeapYear(year4));
    }
}
