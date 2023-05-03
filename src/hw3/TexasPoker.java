package hw3;

import java.util.Scanner;

public class TexasPoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Please input board cards:");
        Card[] boardCards = new Card[5];
        for (int i = 0; i < boardCards.length; i++) {
            boardCards[i] = readCard(scanner);
        }
        Board board = new Board(boardCards[0], boardCards[1], boardCards[2], boardCards[3], boardCards[4]);

        //System.out.println("Please input hands:");
        Hand[] hands = new Hand[6];
        for (int i = 0; i < hands.length; i++) {
            Card card1 = readCard(scanner);
            Card card2 = readCard(scanner);
            hands[i] = new Hand(card1, card2);
        }

        Game game = new Game(board, hands);
        int[] bestRanks = game.getBestRanks();

        for (int i = 0; i < hands.length; i++) {
            System.out.println(bestRanks[i]);
            /*System.out.println("Player " + (i + 1) + " hand cards " + board.getCards()[0].getRank() + board.getCards()[0].getSuit() + " "
            		+ board.getCards()[1].getRank() + board.getCards()[1].getSuit() + " "
            		+ board.getCards()[2].getRank() + board.getCards()[2].getSuit() + " "
            		+ board.getCards()[3].getRank() + board.getCards()[3].getSuit() + " "
            		+ board.getCards()[4].getRank() + board.getCards()[4].getSuit() + " "
            		+ hands[i].getCards()[0].getRank() + hands[i].getCards()[0].getSuit() + " "
            		+ hands[i].getCards()[1].getRank() + hands[i].getCards()[1].getSuit());*/
            //System.out.println();
        }
    }

    private static Card readCard(Scanner scanner) {
        String input = scanner.next();
        char suit = input.charAt(input.length()-1);
        int rank = 0;
        rank = Integer.parseInt(input.substring(0,input.length()-1));
        return new Card(suit, rank);
    }
    
}
