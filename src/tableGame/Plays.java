package tableGame;
import uno.UnoCard;

interface Plays {
	
	/*
	 * Request that the table game create a 
	 * new player and informs its name if it was passed.
	 */
	public boolean createPlayer(String name);
	
	/*
	 * this method is responsible to request a card to discard 
	 * when the input was correct pass. 
	 */
	public boolean pushCard(UnoCard card);
	
	/*
	 * User request get a card from deck if 
	 * the input was correct.
	 */
	public void pullCard(UnoCard card);
	
	/*
	 * It pass the turn to another player.
	 */
	public void passTurn(boolean advertisedUno);
	
}
