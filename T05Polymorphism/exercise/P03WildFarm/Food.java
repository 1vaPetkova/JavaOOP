package T05Polymorphism.exercise.P03WildFarm;

public abstract class Food {
    private final Integer quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
