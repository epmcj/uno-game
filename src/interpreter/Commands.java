package interpreter;
import game.Match;
import uno.NormalCard;
/**
 * This class is responsible to implement the commands used by 
 * player. This commands are invoked by interpreter class when 
 * identify a instruction passed in standart input.
 * @author Eduardo Pinto and Otavio Augusto.
 */
public class Commands {
	private Match match = Match.getInstance();
		
	/**
	 *PlayCard represents one played executed when the player try
	 * to play a card in discard pile. The card must be accept if it is the same color
	 * or the same number if was normal card. If was a especial, the played depends of the effect produced.
	 * @param Name of the card that must be played.
	 * @return Return a boolean value. If was possible to play return true, otherwise false.
	 */
	public boolean playCard(String[] fields){
		if(this.match.playerPlayCard(fields[1])){	
			
			if(fields[1].startsWith("WILD")){
				if(fields.length < 3 || !NormalCard.validColor(fields[2]))
					return false;
				 
				if(this.match.applyEffect(fields[2]) == false)
					return false;
				
				if(fields.length == 4)
					this.match.passTurn(true);
				else
					this.match.passTurn(false);
			} else{
				
				this.match.applyEffect();
				if(fields.length == 3)
					this.match.passTurn(true);
				else
					this.match.passTurn(false);
			}
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * The match ends when one play has a empty hand. This method 
	 * verify when a hand is empty a advertise about.
	 * @return If the hand is empty return true, otherwise false.
	 */
	public boolean verifyEndGame(){
		return match.isEmptyHand();
	}
	
	/**
	 * When player request a new card from a deck, the interpreter invokes 
	 * this method. It is responsible to implement a played to take a card
	 * from a table and add it to hand. Moreover, it shows the state hand.
	 */
	public void draw(){
		match.playerTakeCard();	
		System.out.println("\n---------------------------------------"
				+ "-----------------------------------------");
		System.out.println("NEW CARD ADDED IN THE END OF THE LIST.");
		match.showHandStatus();
	}
	
	/**
	 * The player can pass his turn when was in the second played. When interpreter
	 * receive this command, it call this method that only pass the turn to the 
	 * next player.
	 */ 
	public void pass(){
		match.passTurn(false);
	}

}
