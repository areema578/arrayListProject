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
	public static ArrayList<DeckOfCards> hands = new ArrayList<DeckOfCards>();
	private int size;
	public String player;
	
	public DeckOfCards() { //make the full deck (52)
//		TreeMap<String, Card> deckTreeMap = new TreeMap<String, Card>(); //sorted deck
//		HashMap<String, Card> deckHashMap = new HashMap<String, Card>(); //not sorted deck
		ArrayList<Card> deck = new ArrayList<Card>();
		size = this.deck.size();
		player = "";
	}
	
	public DeckOfCards(String playerName) { //make the hands for the players
//		TreeMap<String, Card> deckTreeMap = new TreeMap<String, Card>(); //sorted deck
//		HashMap<String, Card> deckHashMap = new HashMap<String, Card>(); //not sorted deck
		ArrayList<Card> deck = new ArrayList<Card>();
		size = this.deck.size();
		player = playerName;
	}
	
	public void shuffle() { //shuffles the hashmap based on the keys (value of the card)
		Collections.shuffle(this.deck);
	}
	
	public void deal(int numOfPlayers) { //makes hashmaps depending on number of players
		int i = 1;
		while(i < numOfPlayers) {
			String playerName = "Player " + Integer.toString(i);
			DeckOfCards hand = new DeckOfCards(playerName);
			hands.add(hand);
			i++;
		}
		
		for(Card card:this.deck) {
			for(int j = 0; j < numOfPlayers; j++) {
				
			}
		}
		
	}
	
	public void sort() { //need?
		
	}
	
	public void play() { //need?
		
	}
	
	public void pickup() {
		
	}
}
