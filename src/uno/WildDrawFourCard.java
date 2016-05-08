package uno;

import player.Player;
import tableGame.Play;

/**
 * This class represents a Wild Draw Four Card.
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class WildDrawFourCard extends WildCard{
	private Value value;
	
	public WildDrawFourCard(){
		super();
        this.value = Value.WILDDRAWFOUR;	
	}
	
	/**
     * Get the value of the card (WILDDRAWFOUR).
     */
    @Override
    public String getValue(){
    	return this.value.name();
    }
    
	/**
	 * A "WILD DRAW FOUR" card change it's color like the "WILD" one 
	 * and make the next player take 4 new cards. Additionally, it 
	 * loses its turn.
	 */
    @Override
	public void applyEffect(Play game){
    	if(this.value == WildCard.Value.WILDDRAWFOUR){	
			Player p = game.getNextPlayer();
			for(int i = 0; i < 4; i++)
				p.takeCard(game.getCardFromDeck());
    	}
    	
    	super.applyEffect(game);	    	
    }

}
