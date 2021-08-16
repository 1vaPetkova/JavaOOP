package T01WorkingWithAbstraction.exercise.P03CardsWithPower;

public class Card {
    private final Ranks rank;
    private final Suits suit;

    public Card(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getCardPower() {
        return this.rank.getPower() + this.suit.getValue();
    }

    public Ranks getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }
}
