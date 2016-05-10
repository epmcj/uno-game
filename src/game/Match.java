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
	 * Get prepare to start the game. 
	 */
	@Override
	public void init() {
		this.table.prepareTable();		
	}

	/**
	 * Starts the game distributing cards to all players.
	 */
	@Override
	public void start() {
		if(this.verifyNumPlayers() == false){
			System.out.println("Number of players is too low or too high.");
			return;
		}
		
		this.distributeCards();
		
		this.pControl.startRotation();
		
		this.showStatus();
	}
	
	/**
	 * The current player takes a card from the deck.
	 * @return true if the operation was successful, false otherwise.
	 */
	public boolean playerTakeCard(){
		Player cPlayer = this.pControl.getCurrent();
		UnoCard card = this.table.pullCard();
		
		return cPlayer.takeCard(card);
		
	}
	
	/**
	 * Verify if the number of players is a valid. To be valid, the game
	 * must contain at least two players and a maximum of ten.  
	 * @return true if the number of players is in the valid interval, false 
	 * otherwise.
	 */
	private boolean verifyNumPlayers(){
		if(this.pControl.getNumPlayers() < 10 && 
				this.pControl.getNumPlayers() > 1)
			return true;
		
		return false;
	}
	
	/**
	 * Distribute 7 cards to all players in the game.
	 * @return true if the operation was successful, false otherwise.
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
	 * The current player plays the desired card. If the card requested
	 * is not in player's hand, than nothing is done and the failure is
	 * reported.
	 * @param name: the name of the card that will be played.
	 * @return true if the operation was successful, false otherwise.
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
	 * Apply the effect of the last card played in the game.
	 */
	public void applyEffect(){
		UnoCard card = this.table.showTopCard();
		card.applyEffect(eControl);
		
	}
	
	/**
	 * Apply the effect of an color change card in the game.
	 * @param wildColor - the color choosed by the user.
	 */
	public void applyEffect(String wildColor){
		this.eControl.setWildColor(wildColor);
		this.applyEffect();
		
	}
	
	/**
	 * Finish a player's turn. If the player has only one more card left,
	 * then it must signalizes with 'UNO'.
	 * @param advertUno true if the player says 'UNO', false otherwise.
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
	 * Verify if the current player have no more cards.
	 * @return true if the player has no more cards, false otherwise.
	 */
	public boolean emptyHand(){
		return (0 == pControl.getCurrent().numCards());
	}
	
	/**
	 * Show the status of the game printing them in the console.
	 */
	public void showStatus(){
		Player p = this.pControl.getCurrent();
		System.out.println("---------------------------------------"
				+ "-----------------------------------------");
		System.out.println(this.pControl.getPlayersStatus());
		System.out.print("LAST CARD PLAYED: " 
				+ this.table.showTopCard().toString() + "\t\t\t");
		System.out.println(table.getNumCardsOnDeck() + " CARDS LEFT ON DECK.");
		System.out.println("---------------------------------------"
				+ "-----------------------------------------");
		System.out.println(p.getName() + "'S TURN. CHOOSE ONE CARD:");
		p.showCards();
		System.out.println("---------------------------------------"
				+ "-----------------------------------------");
		
	}
	
	/**
	 * 
	 */
	@Override
	public void finish() {
		
		 
	}
	
	
}
