package player;

import system.IDGenerator;

/** 
 * 
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class Player {
	private int playerID;
	private boolean playerTurn;
	
	public Player(){
		this.playerID = -1;
		this.playerTurn =  false;
	}
	
	public void setPlayerID(){
		if(playerID == -1){
			IDGenerator gen = IDGenerator.getInstance();
			this.playerID = gen.getAnID();
		}	
	}
	
	public void timeToPlay(){
		this.playerTurn = true;
	}
	
	public void passTurn(){
		this.playerTurn = false;
	}
	
	public boolean isAbleToPlay(){
		return this.playerTurn;
	}
	
}
