package uno;

import player.Player;
import tableGame.Play;

/**
 *
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
        WILD            { public String toString() { return "13";}},
        WILDDRAWFOUR    { public String toString() { return "14";}}
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
     * 
     */
    @Override
    public String getColor(){
    	if(!this.used)
    		return this.color.name();
    	else
    		return this.effectiveColor;
    }
    
    /**
     * 
     */
    @Override
    public String getValue(){
    	return this.value.name();
    }
    
    /**
     * Apply the effect of the wild card in the game. A "WILD" card
     * changes it's color for BLUE, RED, YELLOR or GREEN. 
     */
    @Override
    public void applyEffect(Play game){   	
    	
    	
    }
    
    /**
     * 
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
