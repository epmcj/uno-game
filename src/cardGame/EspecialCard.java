package cardGame;

public class EspecialCard implements Card{
	private String color;
	private String effect;
	
	@Override
	public void setID(String ID){
		
	}
	
	@Override
	public String getID(){
		return this.color + ' ' + this.effect;
	}
	
	public String getEffect(){
		return this.effect;
	}
}
