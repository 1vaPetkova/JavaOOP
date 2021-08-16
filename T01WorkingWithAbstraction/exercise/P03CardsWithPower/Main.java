package T01WorkingWithAbstraction.exercise.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rank = scan.nextLine();
        String suit = scan.nextLine();
        Card card = new Card(Ranks.valueOf(rank),Suits.valueOf(suit));
        System.out.printf("Card name: %s of %s; Card power: %d",card.getRank(),card.getSuit(),card.getCardPower());
    }
}
