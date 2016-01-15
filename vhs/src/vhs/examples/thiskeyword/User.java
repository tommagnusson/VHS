package vhs.examples.thiskeyword;

// Server perspective
public class User {

	// Instance variables
	private String userName;
	private int id;
	private boolean newUser;
	
	// Constructor
	// The client uses this to create a new User object.
	public User(String userName, int id, boolean newUser) {
		// this.userName refers to the instance variable up above
		// userName refers to the local variable, which in this case is a parameter.
		this.userName = userName;
		this.id = id;
		this.newUser = newUser;
	}

	// Accessor aka "Getter": client wants to obtain an instance variable
	public String getUserName() {
		// What happened to "this"??
		// Aren't we supposed to use it?
		// Since we have no local variables of the
		// same name in this method, Java knows we mean
		// to return the instance variable userName
		return userName;
	}

	// Mutator aka "Setter": client wants to change an instance variable
	public void setUserName(String userName) {
		// this.userName refers to the instance variable
		// userName refers to the local variable, which in this case is a parameter
		this.userName = userName;
	}

	// Accessor
	public int getId() {
		return id;
	}

	// Mutator
	public void setId(int id) {
		this.id = id;
	}

	/* Accessor naming convention for a boolean instance variables
	 * is a little special.
	 * A client might use this method like so:
	 * 
	 * User user = new User("Name", 10, true);
	 * if (user.isNewUser()) { ... do something
	 * 
	 * Notice how it reads almost like English.
	 * 
	 */
	public boolean isNewUser() {
		return newUser;
	}

	// Mutator
	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}
	
	
}
