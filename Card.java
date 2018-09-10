package arraylistProject;
/**	
 * Scott Arima and Howard Chen
 * 9 Sep 2018
 * Purpose of the program- Plays a card game of War 
 * Inputs Number of Players
 * Output - Game Log -Displays games actions with winner of each round and entire game.
 */
public class Card {

	private String suit;
	private String name;
	private String color;
	private int value;
	private boolean faceCard;
	private boolean faceUp;
	
	/**
	 * constructs a default Card object with default values for suit is "N/A", name is "N/A", color is "N/A", value is 0, 
	 * faceCard is false, and faceUp is true
	 */
	public Card() {
		suit = "N/A";
		name = "N/A";
		color = "N/A";
		value = 0;
		faceCard = false;
		faceUp = true;
	}
	
	/**
	 * Constructs a Card object with user input values for suit, name, color, value, and whether its a face card or not
	 * @param suit - suit of the card (Clubs, Spades, Hearts, Diamonds)
	 * @param name - name of the card with suit
	 * @param color - color of the card
	 * @param value - value of the card from 2-14
	 * @param faceCard - true or false on whether its a face card
	 */
	public Card(String suit, String name, String color, int value, boolean faceCard) {
		this.suit = suit;
		this.name = name;
		this.color = color;
		this.value = value;
		this.faceCard = faceCard;
	}
	/**
	 * gets the String name variable of card
	 * @return - returns the String name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * gets the value of the card
	 * @return - returns card rank value
	 */
	public int getValue() {
		return this.value;
	}
	
	
	/**
	 * creates and return String of all cards in Object Card
	 * @return - returns the string to output
	 */
	public String toString() {
		
		String str = name;
		
		return str;
		
	}
}
