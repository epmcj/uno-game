package interpreter;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This class is just responsible to read a entry from a standart input(keyboard), 
 * process it spliting in fiels and return it as array of strings.
 */ 
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
