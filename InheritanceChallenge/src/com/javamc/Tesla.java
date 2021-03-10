package com.javamc;

public class Tesla extends Car {

    private boolean autoPilot;
    private int carComputer;
    private String name;
    private double computerVersion;

    public Tesla(String name, double computerVersion) {
        super(name);
        this.autoPilot = false;
        this.carComputer = 1;
        this.computerVersion = computerVersion;
    }

    public void setAutoPilot (boolean autoPilot) {
        String autopilotString = autoPilot ? "ON" : "OFF";
        System.out.println("Tesla autopilot " + autopilotString);
        this.autoPilot = autoPilot;
    }

    private void changeGearAutomatically() {
        int targetGear = this.getSpeed() / 20 + 1;
        if (targetGear != getCurrentGear()) {
            super.changeGears(targetGear);
        }
    }

    @Override
    public void setSpeed(int speed) {
        super.setSpeed(speed);
        changeGearAutomatically();
    }

    @Override
    public void increaseSpeed(int speed) {
        super.increaseSpeed(speed);
        changeGearAutomatically();
    }

    @Override
    public void decreaseSpeed(int speed) {
        super.decreaseSpeed(speed);
        changeGearAutomatically();
    }

    @Override
    public void changeGears(int targetGear) {
        System.out.println("Tesla will change gears automatically");
    }

    @Override
    public void stop() {
        super.stop();
        autoPilot = false;
    }
}
