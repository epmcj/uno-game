package interpreter;

/**
 * Interpreter is reponsible to identify the command passed by the current player
 * and invoke the adequate method from command class to execute it properly.
 * @author Eduardo Pinto and Otavio Augusto.
 */
public class Interpreter {
	
	private int State = 0;
	private Input input = new Input(System.in);
	private Commands command = new Commands();
	
	/**
	 * This method performs the task to read a entry by calling the method 
	 * "readFields" from Input class, compare the lenght if is acceptable
	 * and choose what command must be called from Command class.
	 * @return Boolean value. Case finish game return true.
	 */
	public boolean readCommands(){
		String[] fields;
		
		while(true){
			System.out.print("> ");
			fields = input.readFields();
			
			if(fields.length < 1 || fields.length > 4){
				//System.out.println("INVALID ENTRY. TRY AGAIN");
				continue;
			}
			
			for(int i = 0; i < fields.length; i++)
				fields[i] = fields[i].toUpperCase();
			
			if(fields[0].equals("EXIT"))
				return false;
			
			switch(this.State){
				// Responsible to check the first plays(only can be a "PLAY" or "DRAW").
				case 0:
					switch(fields[0]){		
						case "PLAY":
							// Verifies if there is a name of a card.
							if(fields.length < 2){
								System.out.println("HEY, YOU FORGOT TO "
										+ "CHOOSE A CARD.");
								break;
							}
							
							if(this.command.playCard(fields) == false){
								System.out.println("TRY AGAIN.");
								
							} else{
								if(this.command.verifyEndGame())
									return true;
							}
							
							this.State = 0;
							break;
							
						case "DRAW":
							this.command.draw();
							this.State = 1;
							break;
							
						case "PASS":
							System.out.println("YOU SHALL NOT PASS.");
							break;
							
						default:
							System.out.println("I COULDN'T UNDERSTANT YOU.");
							break;
					}
					break;
				// Check the second plays(only can be a "PLAY" or "PASS").
				case 1:
					switch(fields[0].toUpperCase()){
						case "PLAY":
							if(this.command.playCard(fields))
								this.State = 0;
							else
								System.out.println("TRY AGAIN");

							if(this.command.verifyEndGame())
								return true;
							break;
														
						case "PASS":
							this.command.pass();
							this.State = 0;
							break;
							
						case "DRAW":
							System.out.println("SORRY, BUT YOU CAN ONLY DO THAT"
									+ " ONCE A TURN.");
							break;
							
						default:
							System.out.println("I COULDN'T UNDERSTANT YOU. "
									+ "LETS TRY AGAIN.");
							break;
					}
					break;
			}
		}
	}
}
