import game.Match;
import interpreter.Interpreter;
import system.SignUpPlayers;

public class Principal {

	public static void main(String[] args) {
		Interpreter inter = new Interpreter();	
		SignUpPlayers sign = new SignUpPlayers();
		Match game = Match.getInstance();
		
		// Cabeçalho do jogo.
		System.out.println("---------------------------------------"
				+ "-----------------------------------------");
		System.out.println("\t\t\t\tUNO CARD GAME");
		System.out.println("---------------------------------------"
				+ "-----------------------------------------");
		game.init();					// Initiate the game.
		while(sign.sign() == false);	// Registers players.
		game.start();					// Start the game.
		inter.readCommands();			// Read the commands from users.
		game.finish();					// Finishes the game.
		
	}

}
