package tableGame;

import uno.NormalCard;
import uno.UnoCard;

/**
 * This class is responsible for creating the effects of the UNO cards in a
 * game. A Table Class and a PlayersManager Class are necessary to create 
 * this controller.
 * @author Eduardo Pinto and Otavio Augusto.
 *
 */
public class EffectsController {
	private Table tControl;
	private PlayersManager pControl;
	private String wildColor;
	
	public EffectsController(Table table, PlayersManager players){
		this.tControl = table;
		this.pControl = players;
		this.wildColor = null;
	}
	
	/**
	 * Verify if the color is valid and case positive, save it.
	 * @param color to be saved.
	 * @return true if it was possible to save the color, false otherwise.
	 */
	public boolean setWildColor(String color){
		if(NormalCard.validColor(color)){
			this.wildColor = color;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Get the last color that was saved.
	 * @return  string that contains the color.
	 */
	public String getWildColor(){
		return this.wildColor;
	}
	
	/**
	 * The next player is forced to draw two cards and lost its
	 * turn.
	 */
	public void applyDrawTwo(){
		UnoCard card1 = this.tControl.pullCard();
		UnoCard card2 = this.tControl.pullCard();
		this.pControl.getNext().takeCard(card1);
		this.pControl.getNext().takeCard(card2);
		this.pControl.rotateNextPlayer();
	}
	
	/**
	 * Revert the flow of the game.
	 */
	public void applyReverse(){
		this.pControl.changeDirection();
		
		if(this.pControl.getNumPlayers() == 2)
			this.pControl.rotateNextPlayer();
	}
	
	/**
	 * Rotate the game in order to skip the next player.
	 */
	public void applySkip(){
		System.out.println(pControl.getCurrent().getName());
		this.pControl.rotateNextPlayer();
	}
	
	/**
	 * Get the new color of a wild card and rotate the game.
	 * @return a string that contains the color.
	 */
	public String applyWild(){
		return this.getWildColor();
	}
	
	/**
	 * The next player is forced to draw four cards.
	 */
	public void applyDrawFour(){
		UnoCard card;
		for(int i = 0; i < 4; i++){
			card = this.tControl.pullCard();
			this.pControl.getNext().takeCard(card);
		}
		this.pControl.rotateNextPlayer();
	}

}
