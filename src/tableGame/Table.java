package tableGame;
import java.util.ArrayList;

import uno.*;

/**
 * This class represents a game of UNO. It includes the discard pile, the
 * deck, the players and their hands and info about the state of the game.
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class Table{
	private DiscardPile dPile;
	private UnoDeck deck;
	
	public Table(){
		this.dPile = new DiscardPile(); 
		this.deck = new UnoDeck(); 
	}
	
	/**
	 * Prepares the table to start the game. The cards (if there is some) in
	 * the Discard Pile are put back into the deck and then it is shuffle. 
	 * Finally, one card is put back in the discard pile.
	 */
	public void prepareTable(){
		if(this.dPile.getNumCards() != 0){
			ArrayList <UnoCard> list = dPile.takeCardsBack();
			for(int i = 0; i < list.size(); i++)
				this.deck.addCard(list.remove(0));
		}
		
		deck.shuffle();
		
		UnoCard card = this.deck.getCard(0);
		while(card.getColor().equals("BLACK")){
			this.deck.addCard(card);
			card = this.deck.getCard(0);
		}
		
		this.dPile.putFirstCard(card);
	} 
	
	/**
	 * Get the last played card.
	 * @return the card on the top of the discard pile.
	 */
	public UnoCard showTopCard(){
		return this.dPile.getTopCard();
	}

	/**
	 * Try to play a card that is in the hand of the current player. If it 
	 * is possible, then the card is put in the discard pile and its effect
	 * is applied in the game. 
	 * @param cardName the name of the card that will be played.
	 * @return if the operation was successful.
	 */
	public boolean pushCard(UnoCard card){		
		if(card == null)
			return false;
		
		if(this.dPile.getTopCard().match(card)){
			this.dPile.addCard(card);
			return true;
			
		} else{
			return false;
		}		
	}
	
	/**
	 * Take a card from the top of the deck. If the deck is empty, then
	 * the discard pile is used to provide more cards to the game.
	 * @return one card.
	 */
	public UnoCard pullCard(){		
		if(this.deck.isEmpty()){
			ArrayList <UnoCard> list = dPile.takeCardsBack();
			for(int i = 0; i < list.size(); i++)
				deck.addCard(list.remove(0));
			deck.shuffle();
		}	
			
		return deck.getCard(0);
	}
}
