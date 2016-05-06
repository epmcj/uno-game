package system;

/**
 * This class represents an identification (ID). Since the ID is set by the 
 * constructor, it can't be modified. 
 * @author Eduardo Pinto and Otavio Augusto.
 * @param <Type> is the ID representation.  
 */
public class ID <Type>{
	private Type id;
	
	public ID(Type ID){
		this.id = ID;
	}
	
	public Type getID(){
		return this.id; 
	}
}
