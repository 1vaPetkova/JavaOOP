package T05Polymorphism.exercise.P02VehiclesExtension;


public class Bus extends Vehicle {
    public static final double CONSUMPTION_CHANGE = 1.4;

    public Bus(double fuelQty, double litersPerKm, double tankCapacity) {
        super(fuelQty, litersPerKm + CONSUMPTION_CHANGE, tankCapacity);
    }

    public void driveEmpty(double distance) {
        super.setConsumption(getConsumption() - CONSUMPTION_CHANGE);
        drive(distance);
        super.setConsumption(getConsumption() + CONSUMPTION_CHANGE);
    }

}
