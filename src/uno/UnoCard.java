package uno;

import tableGame.EffectsController;

/**
 * This class represents an generic UNO card. In UNO game, there are cards
 * numbered from 0 to 9 and effect cards. The cards also have 5 different 
 * colors. In order to represent this features, at least two fields are 
 * necessary: the color of the card and its value.
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public abstract class UnoCard {
	/**
	 * Get the color of the UNO card.
	 * @return a string that contains the color of the UNO card.
	 */
	public abstract String getColor();
	
	/**
	 * Get the value of the UNO card. It can be a number or an effect.
	 * @return a string that contains the value of the UNO card.
	 */
	public abstract String getValue();
	
	
	/**
	 * Apply the effect of a UNO card in the game.
	 * @param game: the game that will be affected.
	 */
	public abstract void applyEffect(EffectsController ctrl);
	
	/**
	 * Verify if the UNO card matches with another one.
	 * @param card to be compared.
	 * @return true if the two UNO cards match or false otherwise.
	 */
	public abstract boolean match(UnoCard card);
	
	/**
	 * Get a representation of the UNO card.
	 * @return a string that contains the representation of the UNO card.
	 */
	@Override
    public String toString(){
    	return this.getColor()  + this.getValue();
    }
}