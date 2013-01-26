package deckOfCards;

/**
 * A class representing a playing card from a standard deck.
 * Each card has a value and a suit.
 * Class is immutable.
 * 
 * @author Stewart Valencia
 */
public class Card {

	private final int suit;   // 0-3 represent Hearts, Spades, Clubs, Diamonds
	
	private final int value;  // 1 through 13 (1 is Ace, 13 is king, etc.)
	
	
	/* Strings for toString method*/
	private final static String[] suitNames = {"hearts", "spades", "clubs", "diamonds"};
	private final static String[] valueNames = {"A", "2", "3", "4", 
		"5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	/**
	 * Card constructor.
	 * @param value 0 through 13: 1 represents Ace, 2 through 10 for number cards, 11 is Jack, 12 is Queen, 13 is King
	 * @param suit 0 through 3; represents Heart, Spades, Clubs, or Diamonds
	 * @throws RuntimeException; either illegal card value or suit
	 */
	public Card(int value, int suit) throws RuntimeException {
		if (value < 0 || value > 12) {
			throw new RuntimeException("Illegal card value. Must be from 1 to 13. Value: " + value);
		}
		if (suit < 0 || suit > 3) {
			throw new RuntimeException("Illegal suit. Must be from 0 to 3. Value: " + suit);
		}
		this.suit = suit;
		this.value = value;
	}

	/** 
	 * Getter for card value.
	 * @return value of card
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Getter for card suit.
	 * @return suit of card
	 */
	public int getSuit() {
		return this.suit;
	}
	
	/** 
	 * Returns the name of the card as a String. Ex. ace of spades will be "A of spades"
	 * @return string that represents the card
	 */
	public String toString() {
		return valueNames[value] + " of " + suitNames[suit];
	}
	
}
