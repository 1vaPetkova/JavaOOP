package T05Polymorphism.exercise.P02VehiclesExtension;

public class Truck extends Vehicle {
    public static final double CONSUMPTION_INCREASE = 1.6;
    public static final double REFUELLING_CAPACITY = 0.95;

    public Truck(double fuelQty, double litersPerKm, double tankCapacity) {
        super(fuelQty, litersPerKm + CONSUMPTION_INCREASE, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (getFuelQty() + fuel <= super.getTankCapacity()) {
            super.setFuelQty(getFuelQty() + REFUELLING_CAPACITY * fuel);
        } else {
            System.out.println("Cannot fit fuel in tank");
        }
    }
}
