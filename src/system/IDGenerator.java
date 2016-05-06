package system;

/**
 * This class is an ID Generator. It's unique 
 * @author Eduardo Pinto e Otavio Augusto
 *
 */
public class IDGenerator {
	private static IDGenerator generator = null;
	private int userID;
	private int limit;
	
	private IDGenerator(){
		this.userID = 1;
		this.limit = 100;
	}
	
	/**
	 * Create an unique instance of this class with the limit defined.
	 * @return a reference to the unique IDGenerator object.
	 */
	public static IDGenerator getInstance(){
		if(null == generator)
			generator = new IDGenerator();
		return generator;
	}
	
	/**
	 * Get an ID.
	 * @return an ID.
	 */
	public ID<Integer> getAnID(){
		if(this.userID > this.limit)
			throw new IndexOutOfBoundsException("Too many ID's.");
		ID <Integer> id = new ID <Integer> (this.userID);
		this.userID++;
		return id; 
	}
	
	/**
	 * Reset the ID counter.
	 */
	public void resetIDCount(){
		this.userID = 1;
	}
	
	/**
	 * Use to change the limit of the possibles ID's.
	 * @param lim
	 */
	public void setIDLim(int lim){
		this.limit = lim;
	}
}
