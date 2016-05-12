package uno;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

/**
 * 
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class DiscardPile extends CardCollection <UnoCard>{
	
	public DiscardPile(){
		//super();
	}
	
	/**
	 * Add an card on the top of the pile.
	 */
	@Override
	public boolean addCard(UnoCard card){
		if(this.getTopCard() == null)
			return false;
		
		if(!this.getTopCard().match(card))
			return false;

		return this.cardList.add(card);
	}

	/**
	 * Starts the discard pile putting the first card.
	 * @param card : the first card in the pile.
	 */
	public void initialize(UnoCard card){
		if(this.cardList.size() == 0)
			this.cardList.add(card);
	}
	
	/**
	 * This operation is not allowed in this class, since the only way to
	 * remove cards from this collection is removing all but the top.
	 */
	@Override
	public UnoCard getCard(int index){
		throw new UnsupportedOperationException("Operation not allowed.");
	}

	/**
	 * This function get the last card discarded in the game.
	 * @return the card on the top of the discard pile.
	 */
	public UnoCard getTopCard(){
		UnoCard aux;
		
		try{
			aux = cardList.get(cardList.size()-1);
		}catch(IndexOutOfBoundsException e){
			aux = null;
		}
		
		return aux;
	}
	
	/**
	 * This method take the cards in the Discard Pile and make a new deck.
	 * Only the last discarded card remains after this operation.
	 * @return a list with all the cards but the top.
	 */
	public ArrayList<UnoCard> takeCardsBack(){		
		ArrayList<UnoCard> newDeck = new ArrayList<UnoCard>();
		
		while(this.cardList.size() > 1){
			newDeck.add(this.cardList.remove(0));
		}
		
		return newDeck;		
	}
}
