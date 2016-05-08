package uno;

import tableGame.Play;

/**
 * This class represents a Reverse Card.
 * @author Eduardo Pinto and Otavio Augusto
 *
 */
public class ReverseCard extends EspecialCard{
	
	public ReverseCard(EspecialCard.Color color){
		super(color, EspecialCard.Value.REVERSE);
	}
	
	/**
	 * Revert the direction of the game. If only two persons are playing, 
	 * then this effect is similar to the skip one.
	 */
	@Override
	public void applyEffect(Play game){
		if(game.getNumPlayers() > 2)
			game.changeDirection();
		else 
			game.rotatePlayer();
	}

}
