package T03Inheritance.exercise.P04NeedForSpeed;

public class RaceMotorcycle extends Motorcycle {
       public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(8);
    }
}
