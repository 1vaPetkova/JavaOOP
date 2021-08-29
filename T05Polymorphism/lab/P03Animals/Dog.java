package T05Polymorphism.lab.P03Animals;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.explainSelf()+"DJAAF";
    }
}
