	package uno;

import java.util.Random;
import cardGame.*;

/**
 * 
 * @author Eduardo Pinto and Otavio Augusto
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
                        cardList.add(new NormalCard(c,v));
                }
            }
        }

        for(EspecialCard.Color c:EspecialCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                cardList.add(new SkipCard(c));
                cardList.add(new ReverseCard(c));
                cardList.add(new DrawTwoCard(c));
                
            }
        }

        
        for(int j = 0; j < 4; j++) {
             cardList.add(new WildCard());
             cardList.add(new WildDrawFourCard());
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

    public UnoCard get(final int i) { 
    	try{
			return this.cardList.get(i);
			
		} catch(IndexOutOfBoundsException e){
			return null;
		} 
    }

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
