package cardGame;

public class NormalCard implements Card{
	private String color;
	private int number;
	
	@Override
	public void setID(String ID){
		
	}
	
	@Override
	public String getID(){
		return this.color + ' ' + Integer.toString(this.number);
	}
}
