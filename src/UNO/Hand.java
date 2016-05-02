package UNO;
import cardGame.*;

/**
 * 
 * @author Eduardo Pinto and Otávio Augusto
 *
 */
public class Hand <CardType> extends CardCollection <CardType>{
	
	public Hand(){
		super();
	}
	
	/**
	 * Add a card in the hand of the player.
	 */
	@Override
	public void add(CardType card){
		this.cardList.add(card);
	}

	/**
	 * Remove a card in the hand of the player.
	 * @return the UNO card removed.
	 */
	@Override
	public CardType remove(int index){
		try{
			return this.cardList.remove(index);
		} catch(IndexOutOfBoundsException e){
			return null;
		}
	}
}
