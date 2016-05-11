package interpreter;
import game.Match;
import uno.NormalCard;
/**
 * 
 * @author Eduardo Pinto and Otavio Augusto.
 *
 */
public class Commands {
	Match match = Match.getInstance();
			
	public boolean playCard(String[] fields){

		if(fields[1].startsWith("WILD") && !NormalCard.validColor(fields[2]))
			return false;
		
		if(this.match.playerPlayCard(fields[1])){
			if(this.match.emptyHand())
				return true;
			
			if(fields[1].startsWith("WILD")){
				System.out.println(fields.length);
				if(fields.length < 2)
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
		}
		
		return false;
	}
	
	public void draw(){
		match.playerTakeCard();	
		System.out.println("\n---------------------------------------"
				+ "-----------------------------------------");
		System.out.println("NEW CARD ADDED IN THE END OF THE LIST.");
		match.showHandStatus();
	}
	
	public void pass(){
		match.passTurn(false);
	}

}
