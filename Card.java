package blackjack;

public class Card {
    private final int rank;
    private final int suit;
    private final int value;
     Card(int suit, int rank , int value) {
         this.suit = suit;
         this.rank =rank;
         this.value = value;
     }

    Card( Card card){
        this.suit = card.suit;
        this.rank =card.rank;
        this.value = card.value;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }
}
