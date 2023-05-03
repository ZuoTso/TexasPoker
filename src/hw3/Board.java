package hw3;

public class Board {
    private Card[] cards;

    public Board(Card card1, Card card2, Card card3, Card card4, Card card5) {
        this.cards = new Card[]{card1, card2, card3, card4, card5};
    }

    public Card[] getCards() {
        return cards;
    }
}
