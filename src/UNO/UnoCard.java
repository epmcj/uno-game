package UNO;

/**
 * This class represent one card in a normal deck of uno
 * 
*/
public abstract class UnoCard {

	public abstract boolean match(UnoCard card);
    public abstract String toString();
}