package T02Encapsulation.exercise.P04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!FlourTypeModifiers.contains(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!BakingTechniqueModifiers.contains(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        FlourTypeModifiers flour = FlourTypeModifiers.valueOf(flourType.toUpperCase());
        BakingTechniqueModifiers bakingTechnique = BakingTechniqueModifiers.valueOf(this.bakingTechnique.toUpperCase());
        return 2 * flour.getModifier() * bakingTechnique.getModifier() * this.weight;
    }
}
