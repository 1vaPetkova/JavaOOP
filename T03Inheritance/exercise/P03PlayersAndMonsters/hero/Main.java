package T03Inheritance.exercise.P03PlayersAndMonsters.hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName = "Gosho";
        int level = 15;
        Hero hero = new Hero(userName,level);
        System.out.println(hero);
    }
}
