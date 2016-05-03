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
        for(UnoCard.Color c:UnoCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                for(UnoCard.Value v:UnoCard.Value.values()){
                    if(c.equals(UnoCard.Color.BLACK) || j == 1 && v.equals(UnoCard.Value.ZERO) || j == 1 && (v.equals(UnoCard.Value.WILD) || v.equals(UnoCard.Value.WILDDRAWFOUR)))
                        continue;
                    else if(v.equals(UnoCard.Value.WILD) || v.equals(UnoCard.Value.WILDDRAWFOUR))
                        cardList.add(new UnoCard(UnoCard.Color.BLACK,v));
                    else 
                    	cardList.add(new UnoCard(c,v));
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
	public void addCard(UnoCard card){
		this.cardList.add(card);
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
