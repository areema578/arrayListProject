package arraylistProject;

import java.util.ArrayList;
import java.util.Collections;

/**	
 * Scott Arima and Howard Chen
 * 9 Sep 2018
 * Purpose of the program- Plays a card game of War 
 * Inputs: Any key to start the game
 * Output: Game Log - Displays games actions with winner of each round and entire game.
 */
public class DeckOfCards {

	public ArrayList<Card> deck = new ArrayList<Card>();
	public int size;
	public String player;
	
	/**
	 * constructs a default Deck of Cards object with ArrayList deck, default values for size is 0, and player is ""
	 * 
	 */
	public DeckOfCards() { //make the full deck (52)
		ArrayList<Card> deck = new ArrayList<Card>();
		size = 0;
		player = "";
	}

	/**
	 * Constructs a DeckOfCards object with user input values for suit, name, color, value, and whether its a face card or not
	 * @param playerName - name of the player this DeckofCards belongs to
	 */
	public DeckOfCards(String playerName) { //make the hand/deck for the player
		ArrayList<Card> deck = new ArrayList<Card>();
		size = 0;
		player = playerName;
	}
	
	/**
	 * shuffles DeckofCards
	 */
	public void shuffle() { //shuffles the arraylist containing the card objects
		Collections.shuffle(this.deck);
	}
	
	/**
	 * deals cards evenly and in order to both players
	 * @param player1Hand - player 1's deckofCards object hand 
	 * @param player2Hand - player 2's deckofCards object hand 
	 */
	public void deal(DeckOfCards player1Hand, DeckOfCards player2Hand) {
		while(this.size != 0) {
			player1Hand.deck.add(this.deck.get(0));
			player1Hand.size++;
			this.deck.remove(0);
			player2Hand.deck.add(this.deck.get(0));
			player2Hand.size++;
			this.deck.remove(0);
			this.size = this.size - 2;
		}
	}
	
	/**
	 * plays cards into middlePile
	 * @param middlePile- DeckofCards object of middlePile
	 */
	public void play(DeckOfCards middlePile) { //plays the card object at index 0 and place it in the middle pile
		Card playedCard = this.deck.get(0); 
		middlePile.deck.add(playedCard);
		this.deck.remove(0);
		this.size --;
	}
	
	/**
	 * picks up all cards in middlePile and adds to winner's hand
	 * @param middlePile- DeckofCards object of middlePile
	 */
	public void pickup( DeckOfCards middlePile) { //picks up all the cards in the middle pile to the winner of the round
		for(Card c : middlePile.deck ) {
			this.deck.add(c);
			this.size ++;
		}
		middlePile.deck.clear();
	}
	
	/**
	 * creates and return String of all cards in Object DeckOfCards
	 * @return - returns the string to output
	 */
	public String toString() {
		String str = " ";
		
		for ( Card c : deck) {
			
			str = c + "\n";
		}
		return str;
	}
}
