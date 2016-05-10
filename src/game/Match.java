package game;
import tableGame.*;
import interpreter.SignUpPlayers;
import player.Player;
import uno.UnoCard;

public class Match implements game {
	
	private EffectsController eControl;
	private PlayersManager pControl;
	private Table table;
	private static Match match = null;
	
	private Match(){
		this.table = Table.getInstance();
		this.pControl = PlayersManager.getInstance();
		this.eControl = new EffectsController(this.table,this.pControl);
	}

	
	public static Match getInstance(){
		if(match == null)
			match = new Match();
		
		return match;
	}
	/**
	 * 
	 */
	@Override
	public void init() {
		this.table.prepareTable();		
	}

	/**
	 * 
	 */
	@Override
	public void start() {
		if(this.verifyNumPlayers() == false){
			System.out.println("Number of players is too low or too high.");
			return;
		}
		
		this.distributeCards();
		
		this.pControl.startRotation();
		
		System.out.println(this.pControl.getPlayersStatus());
		this.showStatus();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean playerTakeCard(){
		Player cPlayer = this.pControl.getCurrent();
		UnoCard card = this.table.pullCard();
		
		return cPlayer.takeCard(card);
		
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean verifyNumPlayers(){
		if(this.pControl.getNumPlayers() < 10 && 
				this.pControl.getNumPlayers() > 1)
			return true;
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean distributeCards(){
		Player p = this.pControl.getCurrent();
		int firstID = p.getID();
		int i;
		UnoCard card;

		
		do{
			for(i = 0; i < 7; i++){
				card = this.table.pullCard();
				if(card == null)
					return false;
				
				p.forceToTakeCard(card);
			}
			
			pControl.rotate();
			p = this.pControl.getCurrent();
		}while(p.getID() != firstID);
		
		return true;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean playerPlayCard(String name){
		Player cPlayer = this.pControl.getCurrent();
		UnoCard card = cPlayer.playCard(name);
		if(card == null)
			return false;
		
		if(this.table.pushCard(card) == false){
			cPlayer.takeCard(card);
			return false;
		} 
		return true;
	}
	
	/**
	 * 
	 */
	public void applyEffect(){
		UnoCard card = this.table.showTopCard();
		card.applyEffect(eControl);
		
	}
	
	/**
	 * 
	 * @param wildColor
	 */
	public void applyEffect(String wildColor){
		this.eControl.setWildColor(wildColor);
		this.applyEffect();
		
	}
	
	/**
	 * 
	 * @param advertUno
	 */
	public void passTurn(boolean advertUno){
		if(advertUno){
			if(pControl.getCurrent().numCards() != 1){
				this.playerTakeCard();
				this.playerTakeCard();
			}
			
		} else{
			if(pControl.getCurrent().numCards() == 1){
				this.playerTakeCard();
				this.playerTakeCard();
			}
		}
		
		pControl.rotate();
		this.showStatus();
			
	}

	/**
	 * 
	 * @return
	 */
	public boolean emptyHand(){
		return (0 == pControl.getCurrent().numCards());
	}
	
	public void showStatus(){
		Player p = this.pControl.getCurrent();
		System.out.println(p.getName() + ":");
		p.showCards();
		System.out.println("DP TOP: " + this.table.showTopCard().toString());
	}
	
	/**
	 * 
	 */
	@Override
	public void finish() {
		
		 
	}
	
	
}
