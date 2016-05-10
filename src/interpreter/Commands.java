package interpreter;
import game.Match;
/**
 * 
 * @author Eduardo Pinto and Otavio Augusto.
 *
 */
public class Commands {
	Match match = Match.getInstance();
			
	public boolean playCard(String[] fields){

		if(this.match.playerPlayCard(fields[1])){
			if(this.match.emptyHand())
				return true;
			
			if(fields[1].startsWith("WILD")){
				this.match.applyEffect(fields[2]);
				
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
		match.showStatus();
	}
	
	public void pass(){
		match.passTurn(false);
	}

}
