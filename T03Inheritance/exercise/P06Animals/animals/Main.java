package T03Inheritance.exercise.P06Animals.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String animalType = "";
        while (!(animalType = scan.nextLine()).equals("Beast!")) {
            String[] info = scan.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            String gender = info[2];
            Animal animal = new Animal();
            try {
                switch (animalType) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age);
                        break;
                }
                System.out.println(animal);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
