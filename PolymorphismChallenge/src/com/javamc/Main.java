package com.javamc;

// CHALLENGE

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println("Car nr " + (i + 1) + ":");
            Car randomCar = createRandomCar();
            callRandomCarMethod(randomCar);
            System.out.println();
        }

    }

    public static void callRandomCarMethod(Car car) {
        switch ((int) (Math.random() * 3) + 1) {
            case 1:
                car.accelerate();
                break;

            case 2:
                car.brake();
                break;

            case 3:
                car.startEngine();
                break;

            default:
                System.out.println("No random method called for this Car");
                break;
        }

        if (car instanceof Tesla && (int) (Math.random() * 3) == 0) {
            ((Tesla) car).switchAutopilot();
        }
    }

    public static Car createRandomCar() {
        int randomNumber = (int) (Math.random() * 3) + 1;
        switch (randomNumber) {
            case 1:
                return new Tesla("A Tesla", 4);
            case 2:
                return new Dacia("Dacia veche", 2, (int) (Math.random() * 20));
            case 3:
                return new BMW("Cool car", 3);
        }
        return null;
    }
}

class Tesla extends Car {

    private boolean autopilot;

    public Tesla(String name, int cylinders) {
        super(name, cylinders);
        this.autopilot = false;
    }

    public void switchAutopilot() {
        autopilot = !autopilot;
        String autopilotString = autopilot ? "ON" : "OFF";
        System.out.println("Tesla autopilot " + autopilotString);
    }

    @Override
    public void startEngine() {
        System.out.println("Tesla is starting Engine AND computer");
    }

    @Override
    public void accelerate() {
        String accelerateString = autopilot ? "Tesla zoom zooms on its own!" : "Tesla zoom zooms";
        System.out.println(accelerateString);
    }

    @Override
    public void brake() {
        System.out.println("Tesla brake pressed");
    }
}

class Dacia extends Car {
    private int partsMissing;

    public Dacia(String name, int cylinders, int partsMissing) {
        super(name, cylinders);
        this.partsMissing = partsMissing;
    }

    @Override
    public void startEngine() {
        System.out.println("Wow, the engine of this Dacia actually started");
    }

    @Override
    public void accelerate() {
        System.out.println("Dacia accelerated, even with " + partsMissing + " parts missing");
        if ((int) (Math.random() * 4) == 0) {
            partsMissing++;
            System.out.println("Oops, Dacia lost another part");
        }
    }

    @Override
    public void brake() {
        System.out.println("Dacia break.... what break?!");
    }
}

class BMW extends Car {
    public BMW(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public void startEngine() {
        System.out.println("BMW starts engine very loudly");
    }

    @Override
    public void accelerate() {
        System.out.println("BMW accelerates and is awaiting claps from the audience");
    }

    @Override
    public void brake() {
        System.out.println("BMW breaks in figuri");
    }
}

class Car {
    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;

    public Car (String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
    }

    public void startEngine() {
        System.out.println("Car is starting engine");
    }

    public void accelerate() {
        System.out.println("Car is accelerating");
    }

    public void brake() {
        System.out.println("Brake of Car pressed");
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
