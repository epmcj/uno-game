package interpreter;

public class Interpreter {
	
	private int State = 0;
	private Input input = new Input(System.in);
	private Commands command = new Commands();
		
	public boolean readCommands(){
		String[] fields;
		
		while(true){
			
			fields = input.readFields();
			
			if(fields.length < 1 || fields.length > 4){
				//System.out.println("INVALID ENTRY. TRY AGAIN");
				continue;
			}
			
			switch(State){
			
				case 0:
					switch(fields[0]){		
						case "PLAY":
							if(command.playCard(fields))
								return true;//terminou partida
							break;
							
						case "DRAW":
							if(command.draw())
								this.State = 1;
							break;
					}
					break;
					
				case 1:
					switch(fields[0]){
						case "PLAY":
							if(command.playCard(fields))
								return true;//terminou partida
							this.State = 0;
							break;
														
						case "PASS":
							if(command.pass())
								this.State = 0;
							break;
					}
					break;
			
			}
		
		}
	
	}
}
