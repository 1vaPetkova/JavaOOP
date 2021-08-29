package T05Polymorphism.exercise.P01Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQty;
    private double litersPerKm;

    public Vehicle(double fuelQty, double litersPerKm) {
        this.fuelQty = fuelQty;
        this.litersPerKm = litersPerKm;
    }

    public double getFuelQty() {
        return fuelQty;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    public void setFuelQty(double fuelQty) {
        this.fuelQty = fuelQty;
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    void drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.fuelQty >= distance * this.litersPerKm) {
            this.fuelQty -= distance * this.litersPerKm;
            System.out.printf("%s travelled %s km\n", getClass().getSimpleName(),
                    df.format(distance));
        } else {
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        }
    }

    void refuel(double fuel) {
        setFuelQty(getFuelQty() + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQty());
    }
}
