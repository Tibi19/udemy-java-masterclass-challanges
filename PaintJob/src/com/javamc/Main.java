package com.javamc;

public class Main {

    public static void main(String[] args) {

        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));
        System.out.println();

        System.out.println(getBucketCount(-3.4, 2.1, 1.5));
        System.out.println(getBucketCount(3.4, 2.1, 1.5));
        System.out.println(getBucketCount(7.25, 4.3, 2.35));
        System.out.println();

        System.out.println(getBucketCount(3.4, 1.5));
        System.out.println(getBucketCount(6.26, 2.2));
        System.out.println(getBucketCount(3.26, 0.75));
        System.out.println();
    }

    final static int ERROR_INDICATOR_VALUE = -1;

    public static int getBucketCount (double width, double height, double areaPerBucket, int extraBuckets) {

        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return ERROR_INDICATOR_VALUE;
        }

        if (extraBuckets < 0) {
            return ERROR_INDICATOR_VALUE;
        }

        double area = width * height;
        double currentCoveredArea = areaPerBucket * extraBuckets;
        double areaToBeCovered = area - currentCoveredArea;
        int neededBuckets = (int) Math.ceil(areaToBeCovered / areaPerBucket);

        return neededBuckets;
    }

    public static int getBucketCount (double width, double height, double areaPerBucket) {

        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return ERROR_INDICATOR_VALUE;
        }

        double area = width * height;
        int neededBuckets = (int) Math.ceil(area / areaPerBucket);

        return neededBuckets;
    }

    public static int getBucketCount (double area, double areaPerBucket) {

        if (area <= 0 || areaPerBucket <= 0) {
            return ERROR_INDICATOR_VALUE;
        }

        int neededBuckets = (int) Math.ceil(area / areaPerBucket);

        return neededBuckets;
    }

}
