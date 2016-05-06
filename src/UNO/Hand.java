package UNO;
import cardGame.*;

/**
 * 
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class Hand extends CardCollection <UnoCard>{
	
	public Hand(){
		super();
	}
	
	/**
	 * Add a card in the hand of the player.
	 */
	@Override
	public boolean addCard(UnoCard card){
		return this.cardList.add(card);
	}

	/**
	 * Remove a card in the hand of the player.
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
}
