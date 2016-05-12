package game;

/**
 * The interface game represents a abstration of game. It owns
 * three methods commons with almost games. The init method
 * configures the table and makes the players to be signed up.
 * Start is responsible to pass the control to interpreter to 
 * listen commands from users. The method finish just process
 * the task to show the winner and exit the game.
 */
public interface Game {
	
	public void init();
	
	public void start();
	
	public void finish();
}
