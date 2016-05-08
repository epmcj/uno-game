package uno;

import player.Player;
import tableGame.Play;

public class WildDrawFourCard extends WildCard{
	private Value value;
	
	public WildDrawFourCard(){
		super();
        this.value = Value.WILDDRAWFOUR;	
	}
	
	/**
     * 
     */
    @Override
    public String getValue(){
    	return this.value.name();
    }
    
	/**
	 * A "WILD DRAW FOUR" card change it's color like the "WILD" one 
	 * and make the next player take 4 new cards.
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
