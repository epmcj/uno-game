package interpreter;

import java.util.Scanner;
import player.Player;
import system.IDGenerator;
import tableGame.PlayersManager;


/**
 * 
 * @author Eduardo Pinto and Otavio Augusto.
 *
 */

public class SignUpPlayers {
	
	private Scanner input = new Scanner(System.in);
	private PlayersManager pM = PlayersManager.getInstance();
	private IDGenerator idGen = IDGenerator.getInstance();
	
	public void sign(){
		int number;
		System.out.print("DIGIT THE NUMBER OF PLAYER (2 TO 10): ");
		
		number = input.nextInt();
		
		while(number < 2 || number > 10){
			System.out.println("RANGER FROM 2 UNTIL 10 PLAYERS");
			System.out.print("DIGIT THE NUMBER OF PLAYER (2 TO 10): ");
			number =input.nextInt();
		}
		
		for(int i = 0 ; i < number ; i++){
			System.out.print("PLAYER " + String.valueOf(i+1) + " :");
			pM.addPlayer(new Player(input.next(), idGen.getAnID()));
		}
	}
}
