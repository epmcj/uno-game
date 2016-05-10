package interpreter;
import java.util.Scanner;

public class SignUpPlayers {
	
	private Scanner input = new Scanner(System.in);
	
	public void sign(){
		int number;
		System.out.println("DIGIT THE NUMBER OF PLAYER:");
		
		number = Integer.getInteger(input.nextLine());
		
		while(number < 2 || number > 10){
			System.out.println("RANGER FROM 2 UNTIL 10 PLAYERS");
			number = Integer.getInteger(input.nextLine());
		}
		
		for(int i = 0 ; i < number ; i++){
			System.out.println("PLAYER " + String.valueOf(i+1) + " :");
			//create a new player...
		}
	}
}
