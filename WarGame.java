package arraylistProject;

import java.util.HashMap;
import java.util.Scanner;

public class WarGame {

	public static void main(String[] args) {
		String[] suits = new String[] {"Clubs", "Spades", "Hearts", "Diamonds"};
		String[] faces = new String[] {"Jack", "Queen", "King", "Ace"};
		HashMap<String, Card> deck = new HashMap<String, Card>();
		
		int size = 0;
		
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
				deck.put(cardName, new Card(suit, cardName, cardColor, i, false));
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
				deck.put(cardName, new Card(suit, cardName, cardColor, i, true));
				size++;
			}
		}
		
		//Game starts here
		Scanner in = new Scanner(System.in);
		System.out.println("Lets play War!");
		System.out.println("Enter the number of players playing: ");
		String numOfPlayers = in.nextLine().trim();
		
	}
	
}
