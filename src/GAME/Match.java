package GAME;
import tableGame.Play;
import interpreter.Commands;

public class Match implements game {
	
	Play table = new Play();

	@Override
	public void init() {
		//.signUpPlayer(); //by commands 
		this.table.configPlay();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		//		
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		//show winner 
	}
	
	
}
