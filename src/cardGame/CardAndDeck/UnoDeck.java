import java.util.Random;
import java.util.ArrayList;

/**
 * This class represents a normal deck of uno with 108 card.
*/
public class UnoDeck {

    public final static int LENGTH = 108;

    private ArrayList<UnoCard> deck = new ArrayList<UnoCard>();

    public UnoDeck(){
        for(UnoCard.Color c:UnoCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                for(UnoCard.Value v:UnoCard.Value.values()){
                    if(c.equals(UnoCard.Color.BLACK) || j == 1 && v.equals(UnoCard.Value.ZERO) || j == 1 && (v.equals(UnoCard.Value.WILD) || v.equals(UnoCard.Value.WILDDRAWFOUR)))
                        continue;
                    else if(v.equals(UnoCard.Value.WILD) || v.equals(UnoCard.Value.WILDDRAWFOUR))
                        deck.add(new UnoCard(UnoCard.Color.BLACK,v));
                    else 
                        deck.add(new UnoCard(c,v));
                }
            }
        }
    }

    private final static Random sourceRandom = new Random();

    public void shuffle() {
        for(int i = LENGTH - 1; i > 0; --i){
            int index = sourceRandom.nextInt(i);
            UnoCard c = deck.get(index);
            deck.set(index,deck.get(i));
            deck.set(i,c);
        }
    }

    public UnoCard get(final int i) { return deck.get(i); }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for(UnoCard c : deck){ sb.append(c.toString() + " ");}
        return sb.toString();
    }
}
