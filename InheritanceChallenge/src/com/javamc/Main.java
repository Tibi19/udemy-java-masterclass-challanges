package com.javamc;

// CHALLENGE

public class Main {

    public static void main(String[] args) {
        Vehicle vroomThingy = new Vehicle(6, 2);
        Car car = new Car("X5");
        Tesla teslaCar = new Tesla("Model S", 1.789);

        vroomThingy.setSpeed(40);
        vroomThingy.move();
        vroomThingy.decreaseSpeed(20);
        vroomThingy.move();

        System.out.println();

        car.setSpeed(50);
        car.changeGears(3);
        car.move();
        car.increaseSpeed(30);
        car.changeGears(5);
        car.move();
        car.steer(40, -1);

        System.out.println();

        teslaCar.setSpeed(80);
        teslaCar.changeGears(5);
        teslaCar.move();
        teslaCar.setAutoPilot(true);
        teslaCar.setAutoPilot(false);
        teslaCar.decreaseSpeed(30);
        teslaCar.move();
    }
}
