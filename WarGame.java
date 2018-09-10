package arraylistProject;

import java.util.ArrayList;
import java.util.Scanner;

/**	
 * Scott Arima and Howard Chen
 * 9 Sep 2018
 * Purpose of the program- Plays a card game of War 
 * Inputs: Any key to start the game
 * Output: Game Log - Displays games actions with winner of each round and entire game.
 */
public class WarGame {

	public static void main(String[] args) {
		String[] suits = new String[] {"Clubs", "Spades", "Hearts", "Diamonds"}; 
		String[] faces = new String[] {"Jack", "Queen", "King", "Ace"};  
		DeckOfCards fullDeck = new DeckOfCards();
		ArrayList<DeckOfCards> playersDecks = new ArrayList<DeckOfCards>();
		DeckOfCards middlePile = new DeckOfCards();
		boolean insufficentCardsForWar = true;
		boolean playerWonWar = true;

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

		//Game starts here
		Scanner in = new Scanner(System.in);
		System.out.println("Lets play War!");
		System.out.print("Press Enter key to play");
		String anyKey = in.nextLine().trim();
		
		//creates the players' hands/decks to the arraylist
		int j = 1;
		while(j <= 2) {
			String playerName = "Player " + Integer.toString(j);
		    playersDecks.add(new DeckOfCards(playerName));
		    j++;
		}
		
		//shuffles the full deck before dealing
		fullDeck.shuffle();
		System.out.println("The main deck is shuffled.");
		
		//deals out the card objects to the players' decks from the full deck
		fullDeck.deal(playersDecks.get(0), playersDecks.get(1)); 
		System.out.println("Dealing out the cards to the 2 players.");
		

		//game starts to play
		while(playersDecks.get(0).deck.size()  != 0 && playersDecks.get(1).deck.size()  != 0 && insufficentCardsForWar) {
			System.out.println("Player 1 played a " + playersDecks.get(0).deck.get(0).getName());
			playersDecks.get(0).play(middlePile);
			System.out.println("Player 2 played a " + playersDecks.get(1).deck.get(0).getName());
			playersDecks.get(1).play(middlePile);
			if(middlePile.deck.get(0).getValue() > middlePile.deck.get(1).getValue()  ) {  // checks if player 1 card's rank is higher
				System.out.println("Player 1 wins the round!");
				playersDecks.get(0).deck.add(middlePile.deck.get(0) );
				playersDecks.get(0).deck.add(middlePile.deck.get(1) );
				middlePile.deck.clear();
				
			} else if (middlePile.deck.get(0).getValue()  < middlePile.deck.get(1).getValue() ) {  // checks if player 2 card's rank is higher
				System.out.println("Player 2 wins the round!");
				playersDecks.get(1).deck.add(middlePile.deck.get(0) );
				playersDecks.get(1).deck.add(middlePile.deck.get(1) );
				middlePile.deck.clear();
				
			} else if ( middlePile.deck.get(0).getValue()  == middlePile.deck.get(1).getValue() ) { // if both cards equal in value
				insufficentCardsForWar = true; //resets insufficentWar boolean
				playerWonWar = true;
				while (playersDecks.get(0).deck.size() > 3 &&  playersDecks.get(1).deck.size()  > 3 && insufficentCardsForWar && playerWonWar) { //loop to start War
					System.out.println("We have a tie; time for war!");
					System.out.println("Player 1 played a War card face down "); // outputs and places war card facedown in middlepile
					playersDecks.get(0).play(middlePile);
					System.out.println("Player 2 played a War card face down "); // outputs and places war card facedown in middlepile
					playersDecks.get(1).play(middlePile);
					System.out.println("Player 1 played a War card face down "); // outputs and places war card facedown in middlepile
					playersDecks.get(0).play(middlePile);
					System.out.println("Player 2 played a War card face down "); // outputs and places war card facedown in middlepile
					playersDecks.get(1).play(middlePile);
					System.out.println("Player 1 played a War card face down "); // outputs and places war card facedown in middlepile
					playersDecks.get(0).play(middlePile);
					System.out.println("Player 2 played a War card face down "); // outputs and places war card facedown in middlepile
					playersDecks.get(1).play(middlePile);
					System.out.println("Player 1 played a " + playersDecks.get(0).deck.get(0));
					playersDecks.get(0).play(middlePile);
					System.out.println("Player 2 played a " + playersDecks.get(1).deck.get(0));
					playersDecks.get(1).play(middlePile);
					
					//checks which player has higher card rank
					//checks if player 1 card rank is higher
					if(middlePile.deck.get(middlePile.deck.size() - 2).getValue() > middlePile.deck.get(middlePile.deck.size() - 1).getValue()  ) { // player one wins the round
						System.out.println("Player 1 wins the round!");
						playersDecks.get(0).pickup(middlePile);
						playerWonWar = false;
						
						if (playersDecks.get(0).deck.size() < 4) { // checks if player 1 card has enough cards to continue war
							System.out.println("Player 1 does not have enough cards to continue war, Player 2 Wins the Game! ");
							insufficentCardsForWar = false;

						}
							
						else if (playersDecks.get(1).deck.size() < 4) {// checks if player 2 card has enough cards to continue war
							System.out.println("Player 2 does not have enough cards to continue war, Player 1 Wins the Game! ");
							insufficentCardsForWar = false;

						}
					
					//checks if player 2 card rank is higher
					} else if (middlePile.deck.get(middlePile.deck.size() - 2).getValue()  < middlePile.deck.get(middlePile.deck.size() - 1).getValue() ) {
						System.out.println("Player 2 wins the round!");
						playersDecks.get(1).pickup(middlePile);
						playerWonWar = false;
						
						if (playersDecks.get(0).size < 4 ) {  // checks if player 1 card has enough cards to continue war
							System.out.println("Player 1 does not have enough cards to continue war, Player 2 Wins the Game! ");
							insufficentCardsForWar = false;
						}
							
						else if (playersDecks.get(1).size < 4) { // checks if player 2 card has enough cards to continue war
							System.out.println("Player 2 does not have enough cards to continue war, Player 1 Wins the Game! ");
							insufficentCardsForWar = false;
						}
					}
				}
			}
		}
		
		if ( playersDecks.get(0).deck.size()  == 0 ) { // checks if player 1 card has enough cards to continue game
			System.out.println("Player 1 has ran out of cards! Player 2 Wins The Game");
		}
	
		else if(playersDecks.get(1).deck.size()  == 0) { // checks if player 2 card has enough cards to continue game
			System.out.println("Player 2 has ran out of cards! Player 1 Wins The Game");
		}
		System.out.println("Game Over! Thanks for playing!"); //outputs Game Over!
	}
}