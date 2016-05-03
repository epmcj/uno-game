package UNO;
import cardGame.*;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

/**
 * 
 * @author Eduardo Pinto and Otávio Augusto
 *
 */
public class DiscardPile extends CardCollection <UnoCard>{
	
	public DiscardPile(){
		super();
	}
	
	/**
	 * Add an card on the top of the pile.
	 */
	@Override
	public void addCard(UnoCard card){
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
