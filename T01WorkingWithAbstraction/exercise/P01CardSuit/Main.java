package T01WorkingWithAbstraction.exercise.P01CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equals("Card Suits")){
            Suits[] values = Suits.values();
            System.out.println("Card Suits:");
            for (Suits value : values) {
                System.out.printf("Ordinal value: %d; Name value: %s\n",value.ordinal(),value);
            }
        }
    }
}
