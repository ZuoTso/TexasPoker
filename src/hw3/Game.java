package hw3;

//import java.util.Arrays;

public class Game {
    private Board board;
    private Hand[] hands;
    //private HandEvaluator handEvaloutor;

    public Game(Board board, Hand[] hands) {
        this.board = board;
        this.hands = hands;
    }
    
    public int[] getBestRanks() {
        int[] bestRanks = new int[hands.length];
        for (int i = 0; i < hands.length; i++) {
            Card[] allCards = new Card[7];
            System.arraycopy(board.getCards(), 0, allCards, 0, board.getCards().length);
            System.arraycopy(hands[i].getCards(), 0, allCards, board.getCards().length, hands[i].getCards().length);
            
            // TODO: 使用 allCards 計算出最大牌型的值，並存入 bestRanks[i] 中
            HandEvaluator evaluator = new HandEvaluator();
            Hand bestHand = evaluator.evaluate(allCards);
            /*System.out.println("Player " + (i + 1) + " hand cards " + bestHand.getCards()[0].getRank() + bestHand.getCards()[0].getSuit() + " " 
            		+ bestHand.getCards()[1].getRank() + bestHand.getCards()[1].getSuit() + " "
            		+ bestHand.getCards()[2].getRank() + bestHand.getCards()[2].getSuit() + " "
            		+ bestHand.getCards()[3].getRank() + bestHand.getCards()[3].getSuit() + " "
            		+ bestHand.getCards()[4].getRank() + bestHand.getCards()[4].getSuit() + " ");*/
            bestRanks[i] = bestHand.getHandType().getValue();
            
        	}
        return bestRanks;
    	}
    }
      

