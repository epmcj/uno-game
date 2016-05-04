package UNO;
/**
 *
 * 
*/
public class EspecialCard extends UnoCard{
    /**
     * 
    */
    public enum Color {
        BLUE   { public String name() { return "BLUE"; }},
        RED    { public String name() { return "RED"; }},
        GREEN  { public String name() { return "GREEN"; }},
        YELLOW { public String name() { return "YELLOW"; }}
    }

    /**
     * 
    */
    public enum Value {
        SKIP    { public String name() { return "10";}},
        REVERSE { public String name() { return "11";}},
        DRAWTWO { public String name() { return "12";}}
    }

    private final Color color;
    private final Value value;

    public EspecialCard(final Color color, final Value value){
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
    	if(card.getColor().equals("BLACK"))
    		return true;
    	
    	return (card.getColor().equals(this.getColor())
    			|| card.getValue().equals(this.getValue()));	
    }
}
