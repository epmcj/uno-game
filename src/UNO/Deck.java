package UNO;
import cardGame.*;

/**
 * 
 * @author Eduardo Pinto and Otávio Augusto
 *
 */
public class Deck extends CardCollection <UnoCard>{
	
	@Override
	public void add(UnoCard card){
		this.cardList.add(card);
	}

	@Override
	public UnoCard remove(int index){
		try{
			return this.cardList.remove(index);
		} catch(IndexOutOfBoundsException e){
			return null;
		}
	}

}
