package interpreter;
import uno.*;

public interface Plays {
	/*
	 * Request that the table game create a 
	 * new player and informs its name if it was passed.
	 */
	public boolean createPlayer(String name);
	
	/*
	 * this method is responsible to request a card from deck 
	 * when the input was correct. 
	 */
	public boolean pushCard(UnoCard card);
	
	/*
	 * this method makes the inverse.
	 * User request to put a card on a discard pile if 
	 * the input was correct.
	 */
	public boolean pullCard(UnoCard card);
	
	/*
	 * It makes the turn to another player.
	 */
	public boolean passTurn();
	
	/*
	 * This method is called when the player signalize
	 * that has only one card.
	 */
	public boolean uno();
}
