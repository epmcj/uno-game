package uno;

import tableGame.Play;

public class ReverseCard extends EspecialCard{
	
	public ReverseCard(EspecialCard.Color color){
		super(color, EspecialCard.Value.REVERSE);
	}
	
	@Override
	public void applyEffect(Play game){
		game.changeDirection();
	}

}
