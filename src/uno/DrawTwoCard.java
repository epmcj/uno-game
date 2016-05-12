package uno;

import tableGame.EffectsController;

public class DrawTwoCard extends EspecialCard{
	public DrawTwoCard(NormalCard.Color color){
		super(color, EspecialCard.Value.DRAWTWO);
	}
	
	/**
	 * This card makes the next player takes two more cards.
	 * It also loses its turn.
	 */
	@Override
	public void applyEffect(EffectsController ctrl){
		ctrl.applyDrawTwo();
	}
}
