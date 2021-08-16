package T02Encapsulation.exercise.P04PizzaCalories;

import java.util.Arrays;

public enum BakingTechniqueModifiers {
    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1.0);
    private final double modifier;

    BakingTechniqueModifiers(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }

    public static boolean contains(String name) {
        return Arrays.stream(BakingTechniqueModifiers.values()).anyMatch(e -> e.name().equals(name.toUpperCase()));
    }
}
