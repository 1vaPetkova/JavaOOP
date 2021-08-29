package T05Polymorphism.lab.P03Animals;

public class Animal {
    private final String name;
    private final String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String explainSelf() {
        return String.format("I am %s and my favourite food is %s\n", this.name, this.favouriteFood);
    }
}
