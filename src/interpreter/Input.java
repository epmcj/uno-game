package interpreter;
import java.io.InputStream;
import java.util.Scanner;

public class Input {

	 private Scanner input = null;
	 
	 public Input(InputStream in){
	 	input = new Scanner(in);
	 }
	 	
	 public String[] readFields(){
	 	return this.input.nextLine().trim().split("\\s+");
	 }
	 	
	 public void close(){
	 	if(null != input)
	 		this.input.close();
	 }
}