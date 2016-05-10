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
	private static PlayersManager pM = null;
	
	private PlayersManager(){
		this.players = new ArrayList<Player>();
		this.canAdd  = true;
		this.currElem = 0;
		this.nextElem = 0;
		this.toRight = true;
	}
	
	public static PlayersManager getInstance(){
		if(pM == null)
			pM = new PlayersManager();
		
		return pM;			
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
			
			if(this.players.size() == 2)
				this.nextElem = 1;
		}
			
		return this.canAdd;
	}
	
	/**
	 * Allow the first player to play. 
	 */
	public void startRotation(){
		if(this.players.size() > 0)
			this.players.get(0).timeToPlay();
		else
			System.out.println("Insuficient players.");
	}
	
	/**
	 * Return the status of the players. This status is a formated string
	 * composed by manys "PlayerName : NumberOfCards".
	 * @return a string that contains the status of all the cards.
	 */
	public String getPlayersStatus(){
		String pStatus = "";
		Player player;
		for(int i = 0; i < this.players.size(); i++){
			player  = this.players.get(i);
			pStatus += "[" +player.getName() + ": ";
			pStatus += Integer.toString(player.numCards()) + "] ";
		} 
		
		return pStatus;
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
		this.players.get(this.currElem).passTurn(this.players.get(this.nextElem));
		this.currElem = this.nextElem;
		this.rotateNextPlayer();
	}
	
	public void rotateNextPlayer(){
		
		if(this.toRight)
			this.nextElem = (this.nextElem + 1) % players.size();
		else			
			this.nextElem = (this.nextElem - 1 + players.size()) % players.size();
	}
	
	/**
	 * Get the current player.
	 * @return the current player.
	 */
	public Player getCurrent(){
		Player p;
		try{
			p = this.players.get(this.currElem);
			
		} catch(IndexOutOfBoundsException e){
			System.out.println("There isn't any players.");
			p = null;
		}
			
		return p; 
	}
	
	/**
	 * Get the next player.
	 * @return the next player.
	 */
	public Player getNext(){
		return this.players.get(this.nextElem);
	}
	
}
