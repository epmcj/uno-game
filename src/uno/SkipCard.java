package uno;

import tableGame.Play;

public class SkipCard extends EspecialCard{

	public SkipCard(EspecialCard.Color color){
		super(color, EspecialCard.Value.SKIP);
	}
	
	@Override
	public void applyEffect(Play game){
		
	}
}
