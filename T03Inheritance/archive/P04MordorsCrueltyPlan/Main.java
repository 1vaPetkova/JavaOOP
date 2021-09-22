package T03Inheritance.archive.P04MordorsCrueltyPlan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] foods = scan.nextLine().split("\\s+");
        Gandalf gandalf = new Gandalf();

        Arrays.stream(foods).forEach(gandalf::eatFood);
        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());
    }
}
