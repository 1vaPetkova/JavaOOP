package T02Encapsulation.exercise.P04PizzaCalories;

import java.util.Arrays;

public enum FlourTypeModifiers {
    WHITE(1.5),
    WHOLEGRAIN(1.0);

    private final double modifier;

    FlourTypeModifiers(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }

    public static boolean contains(String name) {
        return Arrays.stream(FlourTypeModifiers.values()).anyMatch(e -> e.name().equals(name.toUpperCase()));
    }
}
