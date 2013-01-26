package deckOfCards;


/**
 * A class representing a standard deck with 52 cards.
 * While this is a cost of resizing arrays, I opt not to use ArrayList because
 * due to less overhead.
 * 
 * @author Stewart Valencia
 */
public class Deck {

	private Card cards[];

	/**
	 * This will create 52 cards in the cards array. It will then copy the deck
	 * from Ace of Hearts to Kings of Diamonds
	 */
	public Deck() {
		setCards(new Card[52]);
		int cardNum = 0;
		for(int cardType = 0; cardType < 4; cardType++) {
			for(int cardVal = 0; cardVal < 13; cardVal++) {
				getCards()[cardNum] = new Card(cardVal, cardType);
				cardNum++;
			}
		}
	}
	
	/**
	 * Getter for cards array
	 */
	public Card[] getCards() {
		return cards;
	}

	/**
	 * Setter for cards array
	 */
	public void setCards(Card cards[]) {
		this.cards = cards;
	}
	
	/**
	 * Getter for single card
	 */
	public Card getCardAt(int position) {
		return cards[position];
	}

	/**
	 * The shuffle method shuffles the deck where each permutations on the deck
	 * are equally likely. The main idea is shuffled cards will be swapped in the front.
	 * Since we know cards from 0 to i-1 have already been chosen to shuffle, we will select
	 * a random card from i to deck length. I actually learned this trick in an early academic project.
	 * 
	 */
	public void shuffle() {
		Card temp;
		int swap;
		for(int i = 0; i < getCards().length; i++) {
			swap = (int) (Math.random() * (getCards().length - i)) + i;
			temp = getCards()[i];
			getCards()[i] = getCards()[swap];
			getCards()[swap] = temp;
		}
	}



	/**
	 * The deal method will return a new copy of card at position 0. A temporary deck that will be the new size of the deck. It will be
	 * used to copy the rest of the deck.
	 */
	public Card dealOneCard() throws RuntimeException {
		if(getCards().length < 1)
			throw new RuntimeException("No more cards!");
		Card dealt = new Card(this.getCardAt(0).getValue(), this.getCardAt(0).getSuit());
		Card[] tempDeck = new Card[getCards().length-1];
		for(int i = 1; i< getCards().length; i++ ) {
			tempDeck[i-1] = getCards()[i];
		}
		setCards(tempDeck);
		return dealt;
	}

}
