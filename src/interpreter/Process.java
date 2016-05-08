package interpreter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Process {
	
	private final Pattern p = Pattern.compile("(\\w+) *");
	
	public Matcher fields(String input){
		return p.matcher(input);
	}
	
	public boolean consistentInput(Matcher field){
		//field must be at the least one and less the three
		
		return false ;
		
	}
}
