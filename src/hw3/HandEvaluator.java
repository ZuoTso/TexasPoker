package hw3;

import java.util.ArrayList;
import java.util.List;

public class HandEvaluator {
	public Hand evaluate(Card[] allCards) {
        Hand bestHand = null;
        List<Card[]> combinations = combinations(allCards, 5);
        for (Card[] combination : combinations) {
            Hand hand = new Hand(combination);
            if (bestHand == null || hand.compareTo(bestHand) > 0) {
                bestHand = hand;
            }
        }
        System.out.println(" bestcard " + bestHand.getCards()[0].getRank() + bestHand.getCards()[0].getSuit() + " " 
        		+ bestHand.getCards()[1].getRank() + bestHand.getCards()[1].getSuit() + " "
        		+ bestHand.getCards()[2].getRank() + bestHand.getCards()[2].getSuit() + " "
        		+ bestHand.getCards()[3].getRank() + bestHand.getCards()[3].getSuit() + " "
        		+ bestHand.getCards()[4].getRank() + bestHand.getCards()[4].getSuit() + " ");
        return bestHand;
    }
	
	private List<Card[]> combinations(Card[] cards, int size) {
	    List<Card[]> result = new ArrayList<>();
	    combinationsHelper(cards, size, 0, new Card[size], result);
	    return result;
	}

	private void combinationsHelper(Card[] cards, int size, int start, Card[] combination, List<Card[]> result) {
	    if (size == 0) {
	        result.add(combination.clone());
	        return;
	    }
	    for (int i = start; i <= cards.length - size; i++) {
	        combination[combination.length - size] = cards[i];
	        combinationsHelper(cards, size - 1, i + 1, combination, result);
	    }
	}

}
