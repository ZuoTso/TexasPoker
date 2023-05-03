package hw3;

import java.util.Arrays;

public class Hand {
    private Card[] cards;
	private HandType handType;

    public Hand(Card card1, Card card2) {
        this.cards = new Card[]{card1, card2};
    }

	public Hand(Card[] combination) {
        this.cards = combination;
    }
	
	public Card[] getCards() {
    	return cards;
    }
	
	public HandType getHandType() {
        return handType;
    }

	public int compareTo(Hand other) {
		this.handType = evaluateHandType(this.cards);
		other.handType = evaluateHandType(other.cards);
		if (this.handType.getValue() < other.handType.getValue()) {
			return -1;
		} else if (this.handType.getValue() > other.handType.getValue()) {
			return 1;
		} else {
			for (int i = 0; i < 5; i++) {
				if (this.cards[i].getRank() < other.cards[i].getRank()) {
					return -1;
				} else if (this.cards[i].getRank() > other.cards[i].getRank()) {
					return 1;
				}
			}
			return 0;
		}
	}
	
	
	
	private HandType evaluateHandType(Card[] Cards) {
	    if (isStraightFlush(Cards)) {
	        return HandType.STRAIGHT_FLUSH;
	    } else if (fourOfAKind(Cards)) {
	        return HandType.FOUR_OF_A_KIND;
	    } else if (fullHouse(Cards)) {
	        return HandType.FULL_HOUSE;
	    } else if (isFlush(Cards)) {
	        return HandType.FLUSH;
	    } else if (isStraight(Cards)) {
	        return HandType.STRAIGHT;
	    } else if (threeOfAKind(Cards)) {
	        return HandType.THREE_OF_A_KIND;
	    } else if (twoPairs(Cards)) {
	        return HandType.TWO_PAIRS;
	    } else if (pair(Cards)) {
	        return HandType.PAIR;
	    } else {
	        return HandType.HIGH_CARD;
	    }
	}

	private boolean isStraightFlush(Card[] allCards) {
	    // 檢查是否同花順
	    return isFlush(allCards) && isStraight(allCards);
	}

	private boolean fourOfAKind(Card[] allCards) {
	    // 檢查是否四條
	    int[] ranks = new int[13];
	    for (Card card : allCards) {
	        ranks[card.getRank()-1]++;
	    }
	    for (int rank : ranks) {
	        if (rank == 4) {
	            return true;
	        }
	    }
	    return false;
	}

	private boolean fullHouse(Card[] allCards) {
	    // 檢查是否葫蘆
	    int[] ranks = new int[13];
	    for (Card card : allCards) {
	        ranks[card.getRank()-1]++;
	    }
	    boolean hasThreeOfAKind = false;
	    boolean hasPair = false;
	    for (int rank : ranks) {
	        if (rank == 3) {
	            hasThreeOfAKind = true;
	        } else if (rank == 2) {
	            hasPair = true;
	        }
	    }
	    return hasThreeOfAKind && hasPair;
	}

	private boolean isFlush(Card[] allCards) {
	    // 檢查是否同花
	    int[] suits = new int[4];
	    for (Card card : allCards) {
	        char suitChar = card.getSuit();
	        int suitIndex = -1;
	        if (suitChar == 'H') {
	            suitIndex = 0;
	        } else if (suitChar == 'S') {
	            suitIndex = 1;
	        } else if (suitChar == 'C') {
	            suitIndex = 2;
	        } else if (suitChar == 'D') {
	            suitIndex = 3;
	        }
	        if (suitIndex >= 0) {
	            suits[suitIndex]++;
	        }
	    }
	    for (int suit : suits) {
	        if (suit == 5) {
	            return true;
	        }
	    }
	    return false;
	}
	
	private boolean isStraight(Card[] allCards) {
	    // 檢查是否順子
	    int[] ranks = new int[13];
	    for (Card card : allCards) {
	        ranks[card.getRank() - 1]++;
	    }
	    int count = 0;
	    for (int i = 0; i < ranks.length; i++) {
	        if (ranks[i] > 0) {
	            count++;
	        } else {
	            count = 0;
	        }
	        if (count == 5) {
	            return true;
	        }
	    }
	    // Check special case: Ace can be low
	    if (ranks[0] > 0 && ranks[9] > 0 && ranks[10] > 0 && ranks[11] > 0 && ranks[12] > 0) {
	        return true;
	    }
	    return false;
	}



/*	private boolean isStraight(Card[] allCards) {
	    // 檢查是否順子
	    int[] ranks = new int[13];
	    for (Card card : allCards) {
	        ranks[card.getRank()-1]++;
	    }
	    int count = 0;
	    for (int i = 0; i < ranks.length; i++) {
	        if (ranks[i] == 0) {
	            count = 0;
	        } else {
	            count++;
	        }
	        if (count == 5) {
	            return true;
	        }
	    }
	    return false;
	}*/

	private boolean threeOfAKind(Card[] allCards) {
	    // 檢查是否三條
	    int[] ranks = new int[13];
	    for (Card card : allCards) {
	        ranks[card.getRank()-1]++;
	    }
	    for (int rank : ranks) {
	        if (rank == 3) {
	            return true;
	        }
	    }
	    return false;
	}

	private boolean twoPairs(Card[] allCards) {
	    // 檢查是否兩對
	    int[] ranks = new int[13];
	    int count = 0;
	    for (Card card : allCards) {
	        ranks[card.getRank()-1]++;
	    }
	    for (int rank : ranks) {
	        if (rank == 2) {
	            count++;
	        }
	    }
	    return count == 2;
	}

	private boolean pair(Card[] allCards) {
	    // 檢查是否一對
	    int[] ranks = new int[13];
	    for (Card card : allCards) {
	        ranks[card.getRank()-1]++;
	    }
	    for (int rank : ranks) {
	        if (rank == 2) {
	            return true;
	        }
	    }
	    return false;
	}

}

