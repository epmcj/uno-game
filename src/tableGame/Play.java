package tableGame;
import java.util.ArrayList;

import player.Player;
import uno.*;
/**
*
*/
public class Play {
	private DiscardPile dPile;
	private UnoDeck deck;
	private ArrayList <Player> players;
	private Player current_player;
	private Player nextPlayer;
	private String direction;
	
	public Play(){
		
		
	}
	
	public void changeDirection(){
		// Altera proximo jogador.
		if(this.direction.equals("LEFT")){
			this.direction = "RIGHT";
		} else{
			this.direction = "LEFT";
		}
			
	}
	
	public String getDirection(){
		return this.direction;
	}
	
	public Player getNextPlayer(){
		return this.nextPlayer;
	}
	
	public int getNumPlayers(){
		return this.players.size();
	}
	
	public UnoCard getCardFromDeck(){
		UnoCard card;
		
		if(deck.isEmpty()){
			ArrayList <UnoCard> list = dPile.takeCardsBack();
			for(int i = 0; i < list.size(); i++)
				deck.addCard(list.remove(0));
		}	
			
		return deck.getCard(0);
	}

}
