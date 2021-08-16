package T01WorkingWithAbstraction.lab.P03StudentSystemv2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String input = "";
        while (!"Exit".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s+");
            String result = studentSystem.parseCommand(tokens);
            if (result != null) {
                System.out.println(result);
            }
        }
    }
}

