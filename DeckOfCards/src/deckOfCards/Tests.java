package deckOfCards;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests class tests deck constructor, shuffle, and dealOneCard methods.
 */
public class Tests {

	@Rule
    public ExpectedException thrown = ExpectedException.none();//To test 
	
	/**
	 * Tests the Deck method and getCardAt methods. Makes a deck and test each
	 * card using the getCardAt. It checks the card value and type by a for-loop.
	 */
	@Test
	public void testDeck() {
		Deck deckTest = new Deck();//new Deck
		int cardNum = 0;
		for(int cardType = 0; cardType < 4; cardType++) {
			for(int cardVal = 0; cardVal < 13; cardVal++) {
				assertTrue((deckTest.getCardAt(cardNum).getSuit()) == cardType 
						&&(deckTest.getCardAt(cardNum).getValue() == cardVal));
				cardNum++;
			}
		}
	}

	/**
	 * This method only outputs the shuffle result and should always pass.
	 */
	@Test
	public void testShuffle() {
		System.out.println("testShuffle started\n");
		Deck deckTest = new Deck();
		for(Card e : deckTest.getCards())
			System.out.println(e.toString());
		deckTest.shuffle();
		System.out.println("\nShuffle Time\n");
		for(Card e : deckTest.getCards())
			System.out.println(e.toString());
	}
	
	
	/**
	 * Checks if dealOneCards method works when calling it 53 times after shuffling.
	 */
	@Test
	public void testDealOneCards () {
		System.out.println("\ntestDealOneCard started\n");
		Deck deckTest = new Deck();
		deckTest.shuffle();
		for(int i = 0; i < 52; i++)
			System.out.println(deckTest.dealOneCard().toString());
		//Sets up the thrown check case
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("No more cards!");
		deckTest.dealOneCard();
	}
	
}
