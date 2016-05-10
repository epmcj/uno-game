package tableGame;

import java.util.ArrayList;
import player.Player;


/**
 * This class is responsible to take care of the player and the sequence of
 * plays.
 * @author Eduardo Pinto and Otavio Augusto.
 *
 */
public class PlayersManager {
	private ArrayList <Player> players;
	private boolean canAdd;
	private int currElem;
	private int nextElem;
	private boolean toRight;
	
	public PlayersManager(){
		this.players = new ArrayList<Player>();
		this.canAdd  = true;
		this.currElem = 0;
		this.nextElem = 0;
		this.toRight = true;
	}
	
	/**
	 * Add a player in the list only if inclusion of new players is 
	 * allowed.
	 * @param player to be add.
	 * @return true if it was possible to add the player, false otherwise.
	 */
	public boolean addPlayer(Player player){
		if(this.canAdd){
			this.players.add(player);
			
			if(this.players.size() == 1)
				this.players.get(0).timeToPlay();
			
			if(this.players.size() == 2)
				this.nextElem = 1;
		}
			
		return this.canAdd;
	}
	
	/**
	 * Get the number of players in the list.
	 * @return the number of players.
	 */
	public int getNumPlayers(){
		return this.players.size();
	}
	
	/**
	 * Signal to stop allowing new players.
	 */
	public void lockAdd(){
		this.canAdd = false;
	}
	
	/**
	 * Signal to allow new players.
	 */
	public void unlockAdd(){
		this.canAdd = true;
	}
	
	/**
	 * Get the direction of the rotation of the players.
	 * @return "RIGHT"(increasing) or "LEFT"(decreasing).
	 */
	public String getDirection(){
		if(this.toRight)
			return "RIGHT";
		else
			return "LEFT";
	}
	
	/** 
	 * Change the direction of the rotation.
	 */
	public void changeDirection(){
		this.toRight ^= true;
		
		if(this.toRight)
			this.nextElem = (this.currElem + 1) % players.size();
		else
			this.nextElem = (this.currElem - 1 + players.size()) % players.size();
	}
	
	
	/**
	 * Rotate the players.
	 */
	public void rotate(){
		if(this.toRight){
			this.currElem = (this.currElem + 1) % players.size();
			this.nextElem = (this.nextElem + 1) % players.size();
		} else{
			this.currElem = (this.currElem - 1 + players.size()) % players.size();
			this.nextElem = (this.nextElem - 1 + players.size()) % players.size();
		}
		
		this.players.get(this.currElem).passTurn(this.players.get(this.currElem));
	}
	
	/**
	 * Get the current player.
	 * @return the current player.
	 */
	public Player getCurrent(){
		return this.players.get(this.currElem);
	}
	
	/**
	 * Get the next player.
	 * @return the next player.
	 */
	public Player getNext(){
		return this.players.get(this.nextElem);
	}
}
