package com.javamc;

public class AreaCalculator {

    private static double INVALID_VALUE_DOUBLE = -1.0;

    // Circle area
    public static double area (double radius) {

        if (radius < 0.0) {
            return INVALID_VALUE_DOUBLE;
        }

        return radius * radius * Math.PI;
    }

    // Rectangle area
    public static double area (double x, double y) {

        if (x < 0.0 || y < 0.0) {
            return INVALID_VALUE_DOUBLE;
        }

        return x * y;
    }

}
