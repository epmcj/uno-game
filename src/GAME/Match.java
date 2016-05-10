package GAME;
import tableGame.*;
import interpreter.Commands;
import interpreter.SignUpPlayers;
import player.Player;
import uno.UnoCard;

public class Match implements game {
	
	private EffectsController eControl;
	private PlayersManager pControl;
	private Table table;
	private SignUpPlayers sUp;
	
	public Match(){
		this.table = Table.getInstance();
		this.pControl = PlayersManager.getInstance();
		this.eControl = new EffectsController(this.table,this.pControl);
		this.sUp = new SignUpPlayers();
	}

	@Override
	public void init() {
		this.sUp.sign();
		this.table.prepareTable();		
	}

	@Override
	public void start() {
		if(this.verifyNumPlayers() == false){
			System.out.println("Number of players is too low or too high.");
			return;
		}
		
		this.distributeCards();
		
		this.pControl.startRotation();
		
		System.out.println(this.pControl.getPlayersStatus());
	}
	
	public boolean playerTakeCard(){
		Player cPlayer = this.pControl.getCurrent();
		UnoCard card = this.table.pullCard();
		
		return cPlayer.takeCard(card);
		
	}
	
	private boolean verifyNumPlayers(){
		if(this.pControl.getNumPlayers() < 10 && 
				this.pControl.getNumPlayers() > 1)
			return true;
		
		return false;
	}
	
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
	
	public boolean playerPlayCard(int i){
		Player cPlayer = this.pControl.getCurrent();
		UnoCard card = cPlayer.playCard(i);
		if(card == null)
			return false;
		
		if(this.table.pushCard(card) == false){
			cPlayer.takeCard(card);
			return false;
		} 
		
		return true;
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		//show winner 
	}
	
	
}
