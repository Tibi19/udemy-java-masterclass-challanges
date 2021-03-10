package com.javamc;

public class Main {

    public static void main(String[] args) {

        double area1 = AreaCalculator.area(5.0);
        double area2 = AreaCalculator.area(-1);
        double area3 = AreaCalculator.area(5.0, 4.0);
        double area4 = AreaCalculator.area(-1.0, 4.0);

        System.out.println(area1);
        System.out.println(area2);
        System.out.println(area3);
        System.out.println(area4);
    }

}
