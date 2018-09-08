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
		System.out.println(fullDeck.size);
		
		int cardNumber = 0;
		//game starts to play
		while(playersDecks.get(0).deck.size()  != 0 && playersDecks.get(1).deck.size()  != 0) {
			System.out.println("Player 1 played a " + playersDecks.get(0).deck.get(0).getName() + " and Player 2 played a " + playersDecks.get(1).deck.get(0).getName());
			playersDecks.get(0).play(middlePile);
			playersDecks.get(1).play(middlePile);
			
			if(middlePile.deck.get(0).getValue() > middlePile.deck.get(1).getValue()  ) {
				System.out.println("player 1 wins the round!");
				playersDecks.get(0).deck.add(middlePile.deck.get(0) );
				playersDecks.get(0).deck.add(middlePile.deck.get(1) );
				middlePile.deck.clear();

			
				
			} else if (middlePile.deck.get(0).getValue()  < middlePile.deck.get(1).getValue() ) {
				System.out.println("Player 2 wins the round!");
				playersDecks.get(1).deck.add(middlePile.deck.get(0) );
				playersDecks.get(1).deck.add(middlePile.deck.get(1) );
				middlePile.deck.clear();

			
				
			} else if ( middlePile.deck.get(0).getValue()  == middlePile.deck.get(1).getValue() ) {
				while (playersDecks.get(0).deck.size() > 3 &&  playersDecks.get(1).deck.size()  > 3 ) {
					System.out.println(playersDecks.get(0).deck.size() );
					System.out.println(playersDecks.get(1).deck.size() );
					System.out.println("Player 1 played a xxx and Player 2 played a xxx");
					playersDecks.get(0).play(middlePile);
					playersDecks.get(1).play(middlePile);
					System.out.println("Player 1 played a xxx and Player 2 played a xxx");
					playersDecks.get(0).play(middlePile);
					playersDecks.get(1).play(middlePile);
					System.out.println("Player 1 played a xxx and Player 2 played a xxx");
					playersDecks.get(0).play(middlePile);
					playersDecks.get(1).play(middlePile);
					System.out.println("Player 1 played a " + playersDecks.get(0).deck.get(0).getName() + " and Player 2 played a " + playersDecks.get(1).deck.get(0).getName());
					playersDecks.get(0).play(middlePile);
					playersDecks.get(1).play(middlePile);
					
					if(middlePile.deck.get(middlePile.deck.size() - 2).getValue() > middlePile.deck.get(middlePile.deck.size() - 1).getValue()  ) {
						System.out.println("player 1 wins the round!");
						playersDecks.get(0).pickup(middlePile);
						if (playersDecks.get(0).size < 4 ) {
							
							System.out.println("Player 1 does not have enough cards to continue war, Player 2 Wins the Game! ");
							
						}
							
						else if (playersDecks.get(1).size < 4) {
							System.out.println("Player 2 does not have enough cards to continue war, Player 1 Wins the Game! ");
							
						}
					
						
					} else if (middlePile.deck.get(middlePile.deck.size() - 2).getValue()  < middlePile.deck.get(middlePile.deck.size() - 1).getValue() ) {
						System.out.println("Player 2 wins the round!");
						playersDecks.get(1).pickup(middlePile);
						if (playersDecks.get(0).size < 4 ) {
							
							System.out.println("Player 1 does not have enough cards to continue war, Player 2 Wins the Game! ");
							
						}
							
						else if (playersDecks.get(1).size < 4) {
							System.out.println("Player 2 does not have enough cards to continue war, Player 1 Wins the Game! ");
							
						}
					
					}
				}
				

	
				}
		}
		
		if ( playersDecks.get(0).deck.size()  == 0 ) {
			System.out.println("Player 1 has ran out of cards! Player 2 Wins The Game");
		}
				
				else if(playersDecks.get(1).deck.size()  == 0) {
					System.out.println("Player 2 has ran out of cards! Player 1 Wins The Game");
				}
			
		
		
	}
	
}
