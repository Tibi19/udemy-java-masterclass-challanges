package com.javamc;

public class Car extends Vehicle {

    private int currentGear;
    private String name;

    public Car(String name) {
        super(1, 1);
        this.currentGear = 1;
        this.name = name;
    }

    public void changeGears (int targetGear) {
        System.out.println("Car is changing gear from " + currentGear + " to " + targetGear);
        currentGear = targetGear;
    }

    public int getCurrentGear() {
        return currentGear;
    }
}
