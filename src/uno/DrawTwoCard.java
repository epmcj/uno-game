package uno;

import tableGame.Play;

public class DrawTwoCard extends EspecialCard{
	public DrawTwoCard(EspecialCard.Color color){
		super(color, EspecialCard.Value.DRAWTWO);
	}
	
	@Override
	public void applyEffect(Play game){
		game.getNextPlayer().takeCard(game.getCardFromDeck());
		game.getNextPlayer().takeCard(game.getCardFromDeck());
	}
}
