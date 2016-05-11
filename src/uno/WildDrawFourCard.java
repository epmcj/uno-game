package uno;

import tableGame.EffectsController;

/**
 * This class represents a Wild Draw Four Card.
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class WildDrawFourCard extends WildCard{
	private Value value;
	
	public WildDrawFourCard(){
		super();
        this.value = Value.WILDDRAWFOUR;	
	}
	
	/**
     * Get the value of the card (WILDDRAWFOUR).
     */
    @Override
    public String getValue(){
    	return this.value.toString();
    }
    
	/**
	 * A "WILD DRAW FOUR" card change it's color like the "WILD" one 
	 * and make the next player take 4 new cards. Additionally, it 
	 * loses its turn.
	 */
    @Override
	public void applyEffect(EffectsController ctrl){
    	ctrl.applyDrawFour();
    	super.setColor(ctrl.applyWild());
    }

}
