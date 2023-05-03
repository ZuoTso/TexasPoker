package hw3;

public class Card implements Comparable<Card> {
    private char suit;
    private int rank;

    public Card(char suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public char getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    public int compareTo(Card other) {
        // 比較花色
        int suitDiff = this.suit - other.suit;
        if (suitDiff != 0) {
            return suitDiff;
        }

        // 花色相同，比較點數
        return this.rank - other.rank;
    }
}


