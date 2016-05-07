package UNO;
import cardGame.*;

/**
 * This class represents a hand of a UNO player. There are basic operations like
 * add, get and show cards.
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class Hand extends CardCollection <UnoCard>{
	
	public Hand(){
		super();
	}
	
	/**
	 * Add a card in the hand of the player.
	 * @return if it was possible to add the card.
	 */
	@Override
	public boolean addCard(UnoCard card){
		return this.cardList.add(card);
	}

	/**
	 * Remove a card in the hand of the player.
	 * @param index of the desired card.
	 * @return the UNO card removed.
	 */
	@Override
	public UnoCard getCard(int index){
		try{
			return this.cardList.remove(index);
		} catch(IndexOutOfBoundsException e){
			return null;
		}
	}
	
	/**
	 * Show a card that is on the hand.
	 * @param index of the desired card.
	 * @return 
	 */
	public String showCard(int index){
		try{
			return this.cardList.get(index).toString();
		} catch(IndexOutOfBoundsException e){
			return null;
		}
	}
}
