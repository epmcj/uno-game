package cardGame;
import java.util.ArrayList;

/** This abstract class represents a generic collection of cards.
 * 
 * @author Eduardo Pinto and Otávio Augusto
 *
 */
public abstract class CardCollection {
	protected ArrayList <Card> cardList;
	
	public abstract void add(Card card);
	public abstract Card remove();
	public abstract int getNumCards();
	public abstract boolean isEmpty();	
}