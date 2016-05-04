package UNO;

import java.util.Random;
import cardGame.*;

/**
 * 
 * @author Eduardo Pinto and Otávio Augusto
 *
 */
public class UnoDeck extends CardCollection <UnoCard>{
	private final static Random sourceRandom = new Random();
	public final static int LENGTH = 108;
	
	public UnoDeck(){
        for(NormalCard.Color c:NormalCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                for(NormalCard.Value v:NormalCard.Value.values()){
                    if(j == 1 && v.equals(NormalCard.Value.ZERO) )
                        continue;
                    else 
                        cardList.add(new NormalCard(c,v));s
                }
            }
        }

        for(EspecialCard.Color c:EspecialCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                for(EspecialCard.Value v:EspecialCard.Value.values()){
                    cardList.add(new EspecialCard(c,v));
                }
            }
        }

        for(WildCard.Color c:WildCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                for(WildCard.Value v:WildCard.Value.values()){
                    if(j == 1 && (v.equals(WildCard.Value.WILD) || v.equals(WildCard.Value.WILDDRAWFOUR)))
                        continue;
                    else 
                        deck.add(new WildCard(c,v));
                }
            }
        }
    }

    public void shuffle() {
        for(int i = LENGTH - 1; i > 0; --i){
            int index = sourceRandom.nextInt(i);
            UnoCard c = cardList.get(index);
            cardList.set(index,cardList.get(i));
            cardList.set(i,c);
        }
    }

    public UnoCard get(final int i) { return cardList.get(i); }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for(UnoCard c : cardList){ sb.append(c.toString() + " ");}
        return sb.toString();
    }
	
	@Override
	public boolean addCard(UnoCard card){
		return this.cardList.add(card);     // PRECISA SER MODIFICADO.
	}

	@Override
	public UnoCard getCard(int index){
		try{
			return this.cardList.remove(index);
		} catch(IndexOutOfBoundsException e){
			return null;
		}
	}

}
