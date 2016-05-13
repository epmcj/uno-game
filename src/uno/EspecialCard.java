package uno;

import tableGame.EffectsController;;

/**
 *
 * 
*/
public abstract class EspecialCard extends UnoCard{

    public enum Color {
        BLUE   { public String toString() { return "BLUE"; }},
        RED    { public String toString() { return "RED"; }},
        GREEN  { public String toString() { return "GREEN"; }},
        YELLOW { public String toString() { return "YELLOW"; }}
    }

    public enum Value {
        SKIP    { public String toString() { return "SKIP";}},
        REVERSE { public String toString() { return "REVERSE";}},
        DRAWTWO { public String toString() { return "+2";}}
    }

    private final NormalCard.Color color;
    private final Value value;

    public EspecialCard(final NormalCard.Color color, final Value value){
        this.color = color;
        this.value = value;
    }
    
    /**
     * Get the color of the card.
     */
    @Override
    public String getColor(){
    	return this.color.name();
    }
    
    /**
     * Get the value of the card.
     */
    @Override
    public String getValue(){
    	return this.value.toString();
    }
    
    /**
     * Apply the effect of the card in the game.
     */
    @Override
    public abstract void applyEffect(EffectsController ctrl);
    
    /**
     * Verify if the cards match.
     */
    @Override
    public boolean match(UnoCard card){
    	if(card.getColor().equals("BLACK"))
    		return true;
    	
    	return (card.getColor().equals(this.getColor())
    			|| card.getValue().equals(this.getValue()));	
    }
}
