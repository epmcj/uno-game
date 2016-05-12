package uno;
import java.util.ArrayList;

/** 
 * This abstract class represents a generic collection of cards. Basic 
 * operations are provided: add and remove a card from the collection, 
 * count the number of cards in the collection and verify if it is empty.
 * @author Eduardo Pinto and Otávio Augusto
 *
 */
public abstract class CardCollection <CardType> {
	protected ArrayList <CardType> cardList;
	
	public CardCollection(){
		cardList = new ArrayList<CardType>();
	}
	
	public abstract boolean addCard(CardType card);
	public abstract CardType getCard(int index);
	
	/**
	 * Count the number of cards in the collection.
	 * @return the number of cards in the collection.
	 */
	public int getNumCards(){
		return cardList.size();
	}
	
	/**
	 * Verify if the collection is empty.
	 * @return true if it is empty, false otherwise.
	 */
	public boolean isEmpty(){
		if(0 == cardList.size())
			return true;
		else
			return false;
	}
}