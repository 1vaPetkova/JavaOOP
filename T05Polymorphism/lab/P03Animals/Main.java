package T05Polymorphism.lab.P03Animals;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Cat("Rocky", "Meat");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());


    }
}
