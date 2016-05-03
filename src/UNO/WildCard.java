package UNO;
/**
 *
 * 
*/
public class WildCard extends UnoCard{
    /**
     *
    */
    public enum Color {        
        BLACK  { public String toString() { return "K"; }}
    }

    /**
     *
    */
    public enum Value {        
        WILD { public String toString() { return "13";}},
        WILDDRAWFOUR { public String toString() { return "14";}}
    }

    private final Color color;
    private final Value value;

    public WildCard(final Color color, final Value value){
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
    	return this.getValue();
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
}
