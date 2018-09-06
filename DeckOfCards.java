package arraylistProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class DeckOfCards {

	private static TreeMap<String, Card> deckTreeMap = new TreeMap<String, Card>(); //sorted deck
	private static HashMap<String, Card> deckHashMap = new HashMap<String, Card>(); //not sorted deck
	private int size;
	
	public DeckOfCards() {
		String[] suits = new String[] {"Clubs", "Spades", "Hearts", "Diamonds"};
		String[] faces = new String[] {"Jack", "Queen", "King", "Ace"};
		
		//makes all the number cards
		for(int i = 2; i < 11; i++) {
			for(String suit: suits) {
				String cardName = Integer.toString(i) + " of " + suit;
				String cardColor = "";
				if(suit.equals("Clubs") || suit.equals("Spades")) {
					cardColor = "Black";
				}else {
					cardColor = "Red";
				}
				deckHashMap.put(Integer.toString(i), new Card(suit, cardName, cardColor, i, false)); //key: card value, value: Card object
				size++;
			}
		}
		
		//makes all the face cards
		int i = 10;
		for(String face: faces) {
			i++;
			for(String suit: suits) {
				String cardName = face + " of " + suit;
				String cardColor = "";
				if(suit.equals("Clubs") || suit.equals("Spades")) {
					cardColor = "Black";
				}else {
					cardColor = "Red";
				}
				deckHashMap.put(Integer.toString(i), new Card(suit, cardName, cardColor, i, true)); //key: card value, value: Card object
				size++;
			}
		}
	}
	
	public static void shuffle() { //shuffles the hashmap based on the keys (value of the card)
		List keys = new ArrayList(deckHashMap.keySet());
		Collections.shuffle(keys);
	}
	
	public static void deal(int numOfPlayers) { //makes hashmaps depending on number of players
		
	}
	
	public static void sort() { //sorts the hashmap by putting it into a treemap for auto sort
		deckTreeMap.putAll(deckHashMap);
	}
	
	public static void play() { //need?
		
	}
	
	public static void pickup() { //need?
		
	}
}
