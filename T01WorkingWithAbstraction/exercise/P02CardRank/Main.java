package T01WorkingWithAbstraction.exercise.P02CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equals("Card Ranks")){
            Rank[] values = Rank.values();
            System.out.println("Card Ranks:");
            for (Rank value : values) {
                System.out.printf("Ordinal value: %d; Name value: %s\n",value.getValue(),value);
            }
        }
    }
}
