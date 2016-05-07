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
	 * Get the last ID given.
	 * @return the last ID given.
	 */
	public int getLastID(){
		return (this.userID - 1);
	}
	
	/**
	 * Reset the ID counter.
	 */
	public void resetIDCount(){
		this.userID = 1;
	}
	
	/**
	 * Use to change the limit of the possibles ID's. The limit is altered only
	 * if the new limit is bigger or equal than the current ID.
	 * @param lim: the new limit.
	 */
	public void setIDLim(int lim){
		if(lim >= this.userID)
			this.limit = lim;
	}
	
	/**
	 * Get the generator limit.
	 * @return the generator limit.
	 */
	public int getIDLim(){
		return this.limit;
	}
}
