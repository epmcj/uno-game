import java.util.*;

public class Test{
    public static void main(String[] argv){
        // UnoCard card = new UnoCard(UnoCard.Color.BLUE,UnoCard.Value.TWO);
        UnoDeck deck = new UnoDeck();
        // deck.toString();
        deck.shuffle();
        for(int i = 0; i < 108 ; i++)
            System.out.println(deck.get(i));
        // System.out.println(card.toString());
    }
}

