package system;

import java.io.Serializable;

public abstract class Message implements Serializable{
	static final long serialVersionUID = 0;
	
	public abstract String getInfo();
	public abstract int receiverID(); 

}
