package interpreter;
import tableGame.*;
/**
 * 
 * @author Eduardo Pinto and Otavio Augusto.
 *
 */
public class Commands {
	
	public boolean playCard(String[] fields){
		//chama comandos necessarios para realizar a jogada caso a entrada seja valida e passa a vez avisando se o usuario disse uno
		//se terminar o jogo retorna true
		//caso controrio retorna false
		
		//pega uma carta do jogador
		//joga em table
		//caso seja possivel verifica se é cor
		//se sim passa setcolor
		//	verifica se teve uno
		//	pass vez com argumento se teve uno
		//senao pass vez com argumento se teve uno
		return false;
	}
	
	public void draw(){
		//somente compra uma carta
		//from table pullCard
		//to playersManager/getcurrent.takeCard()
	}
	
	public boolean pass(){
		//passa a vez
		//from playersManager/passTurn(false) 
		return false;
	}

}
