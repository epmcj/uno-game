package system;

/**
 * This class is an ID Generator. It's unique 
 * @author Eduardo Pinto e Otávio Augusto
 *
 */
public class IDGenerator {
	private static IDGenerator generator;
	private int userID;
	private final int limit;
	
	private IDGenerator(int limit){
		generator = null;
		this.userID = 1;
		this.limit = limit;
	}
	
	/**
	 * Create an unique instance of this class with the limit defined.
	 * @return a reference to the unique IDGenerator object.
	 */
	public IDGenerator getInstance(int limit){
		if(null == generator)
			generator = new IDGenerator(limit);
		return generator;
	}
	
	/**
	 * Get an ID.
	 * @return an ID.
	 */
	public int getAnID(){
		if(this.userID > this.limit)
			throw new IndexOutOfBoundsException("Too many ID's.");
		int ID = this.userID;
		this.userID++;
		return ID; 
	}
	
	/**
	 * Reset the ID counter.
	 */
	public void reset(){
		this.userID = 1;
	}
}
