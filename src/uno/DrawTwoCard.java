package uno;

import tableGame.Play;

public class DrawTwoCard extends EspecialCard{
	public DrawTwoCard(EspecialCard.Color color){
		super(color, EspecialCard.Value.DRAWTWO);
	}
	
	/**
	 * This card makes the next player takes two more cards.
	 * It also loses its turn.
	 */
	@Override
	public void applyEffect(Play game){
		game.getNextPlayer().takeCard(game.getCardFromDeck());
		game.getNextPlayer().takeCard(game.getCardFromDeck());
		game.rotatePlayer();
	}
}
