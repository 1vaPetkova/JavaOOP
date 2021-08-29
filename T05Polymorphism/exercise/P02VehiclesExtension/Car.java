package T05Polymorphism.exercise.P02VehiclesExtension;

public class Car extends Vehicle {
    public static final double CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQty, double litersPerKm, double tankCapacity) {
        super(fuelQty, litersPerKm + CONSUMPTION_INCREASE, tankCapacity);
    }


}
