package T05Polymorphism.exercise.P02VehiclesExtension;

import java.text.DecimalFormat;


public abstract class Vehicle {
    private double fuelQty;
    private double consumption;
    private final double tankCapacity;

    protected Vehicle(double fuelQty, double consumption, double tankCapacity) {
        this.fuelQty = fuelQty;
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelQty(double fuel) {
        this.fuelQty = fuel;
    }

    protected void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getFuelQty() {
        return fuelQty;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void drive(double distance) {
        DecimalFormat df = new DecimalFormat("##.##");
        double neededLiters = distance * this.consumption;
        if (this.fuelQty >= neededLiters) {
            setFuelQty(getFuelQty() - neededLiters);
            System.out.printf("%s travelled %s km\n", getClass().getSimpleName(),
                    df.format(distance));
        } else {
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        }
    }

    public void refuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (getFuelQty() + fuel > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQty(getFuelQty() + fuel);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQty());
    }


}
