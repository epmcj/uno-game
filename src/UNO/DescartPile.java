package UNO;
import cardGame.*;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

/**
 * 
 * @author Eduardo Pinto and Otávio Augusto
 *
 */
public class DescartPile <CardType> extends CardCollection <CardType>{
	
	public DescartPile(){
		super();
	}
	
	/**
	 * Add an card on the top of the pile.
	 */
	@Override
	public void add(CardType card){
		this.cardList.add(card);
	}

	/**
	 * This operation is not allowed in this class, since the only way to
	 * remove cards from this collection is removing all but the top.
	 */
	@Override
	public CardType remove(int index){
		throw new UnsupportedOperationException("Operation not allowed.");
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<CardType> takeCardsBack(){
		if(0 == this.cardList.size())
			return null;
		
		ArrayList<CardType> newDeck = new ArrayList();
		
		while(this.cardList.size() != 1){
			newDeck.add(this.cardList.remove(0));
		}
		
		return newDeck;		
	}
}
