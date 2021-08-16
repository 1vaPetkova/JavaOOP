package T02Encapsulation.exercise.P04PizzaCalories;

import java.util.Arrays;

public enum ToppingModifiers {
    MEAT(1.2),
    VEGGIES(.8),
    CHEESE(1.1),
    SAUCE(.9);
    private final double modifier;

    ToppingModifiers(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
    public static boolean contains(String name){
        return Arrays.stream(ToppingModifiers.values()).anyMatch(e->e.name().equals(name.toUpperCase()));
    }
}
