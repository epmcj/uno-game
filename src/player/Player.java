package player;

import uno.Hand;
import uno.UnoCard;
import system.ID;

/** 
 * 
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class Player {
	private ID <Integer> p_id;
	private boolean p_turn;
	private Hand p_hand;
	private String p_name;
	
	public Player(ID<Integer> p_id){
		this("Player ", p_id.getID());
		this.p_name += this.p_id.getID();
	}
	
	public Player(String name, int p_id) {
		this.p_id   = new ID<Integer>(p_id);
		this.p_turn = false;
		this.p_hand = new Hand();
		this.p_name = name;
	}
	
	public Player(String name, ID<Integer> p_id){
		this(name, p_id.getID());
	}
	
	/**
	 * Get the Identification (ID) of the player.
	 * @return the player's ID.
	 */
	public int getID(){
		return this.p_id.getID();
	}
	
	/**
	 * Get the name of the player.
	 * @return the player's name.
	 */
	public String getName(){
		return this.p_name;
	}
	
	/**
	 * Set that it's time to play.
	 */
	public void timeToPlay(){
		this.p_turn = true;
	}
	
	
	/**
	 * Pass turn to another player.
	 * @param p2: The player that will play next.
	 */
	public void passTurn(Player p2){
		if(this.isAbleToPlay()){
			this.p_turn = false;
			p2.timeToPlay();
		}
	}
	
	/**
	 * Verify if it's the player turn.
	 * @return true if it's its turn. False otherwise.
	 */
	public boolean isAbleToPlay(){
		return this.p_turn;
	}
	
	/**
	 * @return the number of cards present in hand
	 */
	public int numCards(){
		return p_hand.getNumCards();
	}
	
	/**
	 * The player takes a card if it's its turn.
	 * @param card that will be taken.
	 */
	public boolean takeCard(UnoCard card){
		if(this.isAbleToPlay())
			this.p_hand.addCard(card);
		
		return this.isAbleToPlay();
	}
	
	/**
	 * The player will always take the card.
	 * @param card to be added.
	 */
	public void forceToTakeCard(UnoCard card){
		this.p_hand.addCard(card);
	}
	
	/**
	 * Play a card if it is its turn.
	 * @param cardName: The name of the card. The name is compose by the color 
	 * and the number or effect.
	 * @return true if the card was played.
	 */
	public UnoCard playCard(String cardName){
		if(this.isAbleToPlay()){
			int i = 0;
			while(i != this.p_hand.getNumCards()){
				if(this.p_hand.showCard(i).equals(cardName))
					return this.p_hand.getCard(i);
				i++;
			}
		}
		
		System.out.println("INVALID OPERATION.");
		return null;
	}
	
	/**
	 * Play the ith card in the hand of the player; 
	 * @param i index of the card.
	 * @return the ith card or null if there is no ith card.
	 */
	public UnoCard playCard(int i){
		if(this.isAbleToPlay()){
			return this.p_hand.getCard(i);
		}
		
		System.out.println("INVALID OPERATION.");
		return null;
	}
	
	/**
	 * Print all the cards on the hand of the player.
	 */
	public void showCards(){
		int ncards =  this.p_hand.getNumCards();
		if(ncards == 0){
			System.out.print("EMPTY HAND.");
			
		} else{
			for(int i = 0; i < ncards; i++){
				System.out.print("[" + this.p_hand.showCard(i) + "] ");
			}
		}
		System.out.print("\n");
	}
	
	/**
	 * Empty the hand.
	 */
	public void emptyHand(){
		while(!this.p_hand.isEmpty())
			this.p_hand.getCard(0);
		}
}
