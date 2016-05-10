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
public class Play implements Plays {
	private DiscardPile dPile;
	private UnoDeck deck;
	private ArrayList <Player> players;
	private Player current_player = null;
	private Player nextPlayer = null;
	private String direction = null;
	
	public Play(){
		this.dPile = new DiscardPile(); 
		this.deck = new UnoDeck();
		this.players = new ArrayList<Player>(); 
	}
	
	/**
	 * This method creates a new player and put it in array of players
	 */
	public void createPlayer(String name){
		if(name == null)
			this.players.add(new Player());
		else
			this.players.add(new Player(name));
	}
	
	/**
	 * Distribute card between player and initialize the current and next player
	 */
	public void configPlay(){
		this.current_player = players.get(0);
		this.nextPlayer = players.get(1);
		this.direction = "RIGTH";
		
		for(int i = 0; i < getNumPlayers(); i++)
			for(int j = 0; j < 7 ; j++)
				this.players.get(i).takeCard(getCardFromDeck());
	}
	
	/**
	 * Try to play a card that is in the hand of the current player. If it 
	 * is possible, then the card is put in the discard pile and its effect
	 * is applied in the game. 
	 * @param cardName the name of the card that will be played.
	 * @return if the operation was successful.
	 */
	public boolean pushCard(String cardName){
		UnoCard cardToComp = this.current_player.playCard(cardName);
		
		if(cardToComp == null)
			return false;
		
		if(this.dPile.getTopCard().match(cardToComp)){
			this.dPile.addCard(cardToComp);
			cardToComp.applyEffect(this);
			return true;
			
		} else{
			this.current_player.takeCard(cardToComp);
			return false;
		}		
	}

	/**
	 * Try to pull a card from de deck to the hand of the current player. If it 
	 * is possible, then the card is put in the hand. 
	 * @return if the operation was successful.
	 */
	public void pullCard() {
		UnoCard card = getCardFromDeck();
		this.current_player.takeCard(card);
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
		return this.nextPlayer;
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
			this.nextPlayer = players.get(this.nextPlayer.getID() % this.players.size());
		} else{
			if(this.nextPlayer.getID() - 2 < 0) 
				this.nextPlayer = players.get(this.players.size() - 1);
			else
				this.nextPlayer = players.get(this.nextPlayer.getID()-2);
			
		}
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
	public void passTurn(boolean advertisedUno){
		/**it will makes the user draw two card if he said uno without
		 * having only one card in hand or no indicate uno and having only one card.
		 */
		if(advertisedUno && (current_player.numCards() > 1)){
			current_player.takeCard(getCardFromDeck());
			current_player.takeCard(getCardFromDeck());
		}
		
		if(!advertisedUno && (current_player.numCards() == 1)){
			current_player.takeCard(getCardFromDeck());
			current_player.takeCard(getCardFromDeck());
		}
		
		this.current_player.passTurn(this.nextPlayer);
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
	
	public void showNumPlayerCards(){
		for(int i = 0;i < getNumPlayers();i++){
			System.out.print("PLAYER("+String.valueOf(i)+")"+" "+String.valueOf(players.get(i).numCards())+" ");
		}
		System.out.println();
	}
	
	public void showCurrentPlayerCards(){
		current_players.showCards();
		System.out.println();
	}
}
