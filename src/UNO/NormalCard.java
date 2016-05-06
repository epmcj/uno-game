package UNO;

/**
 * This class represent one card in a normal deck of uno
 * @author Eduardo Pinto and Otavio Augusto
*/
public class NormalCard extends UnoCard{
    /**
     * This enum represent a type which elements are color of a deck card.
    */
    public enum Color {
        BLUE   { public String toString() { return "BLUE"; }},
        RED    { public String toString() { return "RED"; }},
        GREEN  { public String toString() { return "GREEN"; }},
        YELLOW { public String toString() { return "YELLOW"; }}
    }

    /**
     * This enum represent a type which elements are numbers of the card.
    */
    public enum Value {
        ZERO    { public String toString() { return "0";}},
        ONE     { public String toString() { return "1";}},
        TWO     { public String toString() { return "2";}},
        THREE   { public String toString() { return "3";}},
        FOUR    { public String toString() { return "4";}},
        FIVE    { public String toString() { return "5";}},
        SIX     { public String toString() { return "6";}},
        SEVEN   { public String toString() { return "7";}},
        EIGHT   { public String toString() { return "8";}},
        NINE    { public String toString() { return "9";}}
    }

    private final Color color;
    private final Value value;

    public NormalCard(final Color color, final Value value){
        this.color = color;
        this.value = value;
    }
    
    /**
     * 
     */
    @Override
    public String getColor(){
    	return this.color.name();
    }
    
    /**
     * 
     */
    @Override
    public String getValue(){
    	return this.value.name();
    }
    
    /**
     * 
     */
    @Override
    public String getEffect(){
    	return null;
    }
    
    /**
     * 
     */
    @Override
    public boolean match(UnoCard card){
    	if(card.getColor().equals("BLACK"))
    		return true;
    	
    	return (card.getColor().equals(this.getColor())
    			|| card.getValue().equals(this.getValue()));	
    }
}