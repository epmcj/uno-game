import java.util.Random;
/**
 * This class represents a normal deck of uno with 108 card.
*/
public class Deck {

    public final static int LENGTH = 108;

    private final Card[] deck = new Card[LENGTH];{
        int i = 0;
        //falta terminar o contrutor
        for(Card.Color c : Card.Color.values()){
            for(){
                deck[i] = new Card(c,v);
                ++i;
            }
        }
        //falta terminar o construtor
        for(
    }
    
    private final static Random souceRandom = new Random();

    public void shuffle() {
        for(int i = LENGTH - 1; i > 0; --i){
            int index = souceRandom.nexInt(i);
            Card c = deck[index];
            deck[index] = deck[i];
            deck[i] = c;
        }
    }

    public Card get(final int i) { return deck[i]; }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for(Card c : deck){ sb.append(c.toString() + " ");}
        return sb.toString();
    }
}
