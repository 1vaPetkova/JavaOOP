package T02Encapsulation.exercise.P04PizzaCalories;

import java.util.Arrays;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!ToppingModifiers.contains(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
            this.toppingType = toppingType;
    }


    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50]."
                    , this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        ToppingModifiers type = ToppingModifiers.valueOf(this.toppingType.toUpperCase());
        return 2 * type.getModifier() * this.weight;
    }
}
