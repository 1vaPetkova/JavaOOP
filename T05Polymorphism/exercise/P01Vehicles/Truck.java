package T05Polymorphism.exercise.P01Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQty, double litersPerKm) {
        super(fuelQty, litersPerKm + 1.6);
    }
    @Override
    void refuel(double fuel) {
        setFuelQty(getFuelQty() + 0.95*fuel);
    }
}
