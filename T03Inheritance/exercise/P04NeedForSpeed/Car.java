package T03Inheritance.exercise.P04NeedForSpeed;

public class Car extends Vehicle {

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(3);
    }
}
