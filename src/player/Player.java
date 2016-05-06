package player;

import system.IDGenerator;
import system.ID;
import UNO.Hand;

/** 
 * 
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class Player {
	private ID <Integer> p_id;
	private boolean p_turn;
	private Hand p_hand;
	
	public Player(IDGenerator gen){
		if(gen == null)
			gen = IDGenerator.getInstance();
		this.p_id   = gen.getAnID();
		this.p_turn = false;
		this.p_hand = new Hand();
	}
	
	public int getID(){
		return this.p_id.getID();
	}
	
	public void timeToPlay(){
		this.p_turn = true;
	}
	
	public void passTurn(){
		this.p_turn = false;
	}
	
	public boolean isAbleToPlay(){
		return this.p_turn;
	}
	
}
