package arraylistProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WarGame {

	public static void main(String[] args) {
		String[] suits = new String[] {"Clubs", "Spades", "Hearts", "Diamonds"};
		String[] faces = new String[] {"Jack", "Queen", "King", "Ace"};
		DeckOfCards fullDeck = new DeckOfCards();
		ArrayList<DeckOfCards> playersDecks = new ArrayList<DeckOfCards>();
		DeckOfCards middlePile = new DeckOfCards();
		
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
				fullDeck.deck.add(new Card(suit, cardName, cardColor, i, false));
				fullDeck.size++;
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
				fullDeck.deck.add(new Card(suit, cardName, cardColor, i, true));
				fullDeck.size++;
			}
		}
		System.out.println(fullDeck.size);
		
		//Game starts here
		Scanner in = new Scanner(System.in);
		System.out.println("Lets play War!");
		System.out.print("Enter the number of players playing: ");
		String numOfPlayers = in.nextLine().trim();
		
		//creates the players' hands/decks to the arraylist
		int j = 1;
		while(j <= Integer.parseInt(numOfPlayers)) {
			String playerName = "Player " + Integer.toString(j);
		    playersDecks.add(new DeckOfCards(playerName));
		    j++;
		}
		
		//shuffles the full deck before dealing
		fullDeck.shuffle();
		System.out.println(fullDeck.size);
		System.out.println("The main deck is shuffled.");
		
		//deals out the card objects to the players' decks from the full deck
		fullDeck.deal(playersDecks.get(0), playersDecks.get(1));
		System.out.println("Dealing out the cards to the " + numOfPlayers +" players.");
		System.out.println(playersDecks.get(0).size);
		System.out.println(playersDecks.get(1).size);
		
		//game starts to play
		/*
		commented out because i was doing testing but its currently in an infinite loop
		*/
//		while(playersDecks.get(0).size != 0 || playersDecks.get(1).size != 0) {
//			System.out.println("Player 1 played a " + playersDecks.get(0).deck.get(0).getName() + " and Player 2 played a " + playersDecks.get(1).deck.get(0).getName());
//			if(playersDecks.get(0).deck.get(0).getValue() == playersDecks.get(1).deck.get(0).getValue()) {
//				playersDecks.get(0).play(middlePile);
//			}
//		}
		
	}
	
}
