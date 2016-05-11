package uno;

import tableGame.EffectsController;

/**
 * This class represents a Wild Card.
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class WildCard extends UnoCard{
    /**
     *
    */
    public enum Color {        
        BLACK  { public String toString() { return "BLACK"; }}
    }

    /**
     *
    */
    public enum Value {        
        WILD            { public String toString() { return "WILD";}},
        WILDDRAWFOUR    { public String toString() { return "WILD+4";}}
    }

    private final Color color;
    private final Value value;
    private boolean used;
    private String effectiveColor;

    public WildCard(){
        this.color = Color.BLACK;
        this.value = Value.WILD;
        this.used = false;
    }
    
    /**
     * Get the color of the card. If this card was already played, then
     * the new color is showed.
     */
    @Override
    public String getColor(){
    	if(!this.used)
    		return this.color.name();
    	else
    		return this.effectiveColor;
    }
    
    /**
     * Get the value of the card(WILD).
     */
    @Override
    public String getValue(){
    	return this.value.name();
    }
    
    /**
     * Apply the effect of the wild card in the game. A "WILD" card
     * changes it's color for BLUE, RED, YELLOR or GREEN. Additionally, 
	 * the next player loses its turn.
     */
    @Override
    public void applyEffect(EffectsController crtl){   	
    	this.setColor(crtl.applyWild());
    }
    
    /**
     * Only matches with other cards if its has a color different of BLACK.
     */
    @Override
    public boolean match(UnoCard card){
    	if(this.getColor().equals("BLACK"))
    		return false;
    	
    	return (card.getColor().equals(this.getColor()));	
    }
    
    /**
     * Set the color of the wild card.
     * @param color desired.
     * @return if the operation could be done.
     */
    public boolean setColor(String color){
    	if(this.used)
    		return false;
    	if(!NormalCard.validColor(color))
    		throw new IllegalArgumentException();
    	
    	this.effectiveColor = color;
    	this.used = true;
    	return true;  	
    }
    
    /**
     * Get the representation of the card. 
     * @return the value of the wild card if the card wasn't used yet. If the
     * card was already used, then it returns the color chosen and the type.
     */
    @Override
    public String toString(){
    	if(this.used)
    		return super.toString();
    		
    	return this.getValue();
    }
}
