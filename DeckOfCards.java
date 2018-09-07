package arraylistProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class DeckOfCards {

//	public TreeMap<String, Card> deckTreeMap = new TreeMap<String, Card>(); //sorted deck
//	public HashMap<String, Card> deckHashMap = new HashMap<String, Card>(); //not sorted deck
	public ArrayList<Card> deck = new ArrayList<Card>();
//	public static ArrayList<DeckOfCards> hands = new ArrayList<DeckOfCards>();
	public int size;
	public String player;
	
	public DeckOfCards() { //make the full deck (52)
//		TreeMap<String, Card> deckTreeMap = new TreeMap<String, Card>(); //sorted deck
//		HashMap<String, Card> deckHashMap = new HashMap<String, Card>(); //not sorted deck
		ArrayList<Card> deck = new ArrayList<Card>();
		size = 0;
		player = "";
	}
	
	public DeckOfCards(String playerName) { //make the hand/deck for the player
//		TreeMap<String, Card> deckTreeMap = new TreeMap<String, Card>(); //sorted deck
//		HashMap<String, Card> deckHashMap = new HashMap<String, Card>(); //not sorted deck
		ArrayList<Card> deck = new ArrayList<Card>();
		size = 0;
		player = playerName;
	}
	
	public void shuffle() { //shuffles the arraylist containing the card objects
		Collections.shuffle(this.deck);
	}
	
	public void deal(DeckOfCards player1Hand, DeckOfCards player2Hand) {
		while(this.size != 0) {
			player1Hand.deck.add(this.deck.get(0));
			this.deck.remove(0);
			player2Hand.deck.add(this.deck.get(0));
			this.deck.remove(0);
			this.size = this.size - 2;
		}
//		int i = 1;
//		while(i < numOfPlayers) {
//			String playerName = "Player " + Integer.toString(i);
//			DeckOfCards hand = new DeckOfCards(playerName);
//			hands.add(hand);
//			i++;
//		}
//		
//		for(Card card:this.deck) {
//			for(int j = 0; j < numOfPlayers; j++) {
//				
//			}
//		}
	}
	
	public void sort() { //need?
		
	}
	
	public void play(DeckOfCards middlePile) { //plays the card object at index 0 and place it in the middle pile
		Card playedCard = this.deck.remove(0);
		middlePile.deck.add(playedCard);
	}
	
	public void pickup() { //picks up all the cards in the middle pile to the winner of the round
		
	}
}
