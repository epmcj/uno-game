package clientSide;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import system.ActionMessage;

public class Interpreter {
	private Scanner input;
	private final Pattern p = Pattern.compile("(\\w+) *");
	
	public Interpreter(InputStream in){
		Scanner input = new Scanner(in);
	}
	
	public String read(){
		return this.input.nextLine();
	}
	
	public ActionMessage readAndExec(){
		ActionMessage mes;
		Matcher field = p.matcher(input.nextLine());
		
		while(field.find()){
			System.out.println(field.group());
		}
		
		return null;
	}
	
	public void close(){
		if(null != input)
			this.input.close();
	}
}
