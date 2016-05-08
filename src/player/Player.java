package player;

import system.IDGenerator;
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
	
	public Player(){
		this("Player ");
		this.p_name += this.p_id.getID();
	}
	
	public Player(String name){
		this.p_id   = IDGenerator.getInstance().getAnID();
		this.p_turn = false;
		this.p_hand = new Hand();
		this.p_name = name;
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
	 * The player takes a card if it's its turn.
	 * @param card that will be taken.
	 */
	public void takeCard(UnoCard card){
		if(this.isAbleToPlay())
			this.p_hand.addCard(card);
		else
			System.out.println("INVALID OPERATION.");
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
}
