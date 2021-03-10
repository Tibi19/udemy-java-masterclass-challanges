package com.javamc;

public class Vehicle {

    private int wheels;
    private int engine;

    private int speed;

    public Vehicle(int wheels, int engine) {
        this.wheels = wheels;
        this.engine = engine;

        this.speed = 0;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void increaseSpeed(int speed) {
        this.speed += speed;
    }

    public void decreaseSpeed(int speed) {
        this.speed -= speed;
    }

    public void steer(int degrees, int direction) {
        String directionString = direction < 0 ? "left" : "right";
        System.out.println("Vehicle steering " + degrees + " degrees to the " + directionString);
    }

    public void move() {
        System.out.println("Vehicle is moving with " + speed + " speed");
    }

    public void stop() {
        System.out.println("Vehicle stopped");
        speed = 0;
    }
}
