package UNO;

/**
 * This class represents an generic UNO card. In UNO game, there are cards
 * numbered from 0 to 9 and effect cards. The cards also have 5 different 
 * colors. In order to represent this features, at least two fields are 
 * necessary: the color of the card and its value.
 * @author Eduardo Pinto and Otávio Augusto
 *
 */
public abstract class UnoCard {
	
	public abstract String getColor();
	
	public abstract String getValue();
	
	public abstract String getEffect();
	
	public abstract boolean match(UnoCard card);
	
    public String toString(){
    	return this.getColor() + ' ' + this.getValue();
    }
}