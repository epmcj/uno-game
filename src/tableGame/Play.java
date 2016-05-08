package tableGame;
import java.util.ArrayList;

import player.Player;
import uno.*;

/**
 * This class represents a game of UNO. It includes the discard pile, the
 * deck, the players and their hands and info about the state of the game.
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class Play {
	private DiscardPile dPile;
	private UnoDeck deck;
	private ArrayList <Player> players;
	private p_represent current_player;
	private p_represent nextPlayer;
	private String direction;
	
	public Play(){
		
		
	}
	
	/**
	 * This class just represent a player for the table. It knows a player's
	 * info and its position on the array.
	 */
	private class p_represent{
		private Player p;
		private int i;
	}
	
	/**
	 * Changes the direction of the game and the next player.
	 */
	public void changeDirection(){
		// Altera proximo jogador.
		if(this.direction.equals("LEFT")){
			this.direction = "RIGHT";
		} else{
			this.direction = "LEFT";
		}
			
		rotateNextPlayer();
		rotateNextPlayer();
	}
	
	/**
	 * Get the direction that the table is using.
	 * @return an string with the direction.
	 */
	public String getDirection(){
		return this.direction;
	}
	
	/**
	 * Get the next player.
	 * @return the next player.
	 */
	public Player getNextPlayer(){
		return this.nextPlayer.p;
	}
	
	/**
	 * Get the number of players.
	 * @return
	 */
	public int getNumPlayers(){
		return this.players.size();
	}
	
	/**
	 * Choose the next player based on the direction of the game.
	 */
	private void rotateNextPlayer(){
		if(this.direction.equals("RIGHT")){
			this.nextPlayer.i = this.nextPlayer.i++ % this.players.size();
			
		} else{
			this.nextPlayer.i = this.nextPlayer.i--;
			if(this.nextPlayer.i < 0) 
				this.nextPlayer.i = this.players.size() - 1;	
		}
		
		this.nextPlayer.p = players.get(this.nextPlayer.i);
	}
	
	/**
	 * Rotate the table, making the next player became the current one and
	 * taking another one as the next.
	 */
	public void rotatePlayer(){
		this.current_player = this.nextPlayer;
		rotateNextPlayer();		
	}
	
	/**
	 * Finalizes one turn.
	 */
	public void passTurn(){
		this.current_player.p.passTurn(this.nextPlayer.p);
		this.rotatePlayer();
	}
	
	/**
	 * Take a card from the top of the deck. If the deck is empty, then
	 * the discard pile is used to provide more cards to the game.
	 * @return one card.
	 */
	public UnoCard getCardFromDeck(){		
		if(deck.isEmpty()){
			ArrayList <UnoCard> list = dPile.takeCardsBack();
			for(int i = 0; i < list.size(); i++)
				deck.addCard(list.remove(0));
			deck.shuffle();
		}	
			
		return deck.getCard(0);
	}
}
