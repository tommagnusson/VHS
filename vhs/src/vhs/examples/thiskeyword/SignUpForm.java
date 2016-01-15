package vhs.examples.thiskeyword;

import java.util.Random;
import java.util.Scanner;

// Client perspective
// SignUpForm can be referred to as a "client".

/**
 * Sign up takes a user's desired user name
 * and creates a new User object.
 */
public class SignUpForm {

	public static void main(String[] args) {
		
		// Collect User Input
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter your desired username:");
		String userName = reader.next();
		
		// Random ID
		int id = createRandomId();
		
		// Using the constructor defined in User.java
		User newUser = new User(userName, id, true);
		
		outputUserSuccess(newUser);
		
		// Now that the user is set up, he's not a new user
		// We want to mutate the instance variable to reflect
		// the fact that he is no longer a new user.
		newUser.setNewUser(false);
		outputUserSuccess(newUser);
		
	}

	private static void outputUserSuccess(User user) {
		System.out.println("Success! Hey there, " + user.getUserName() + "!");
		System.out.println("Your number is: " + user.getId());
		
		// This accessor method name makes the statement read almost like natural English
		if (user.isNewUser()) { // if the user is a new user then...
			System.out.println("You are a new user.\n");
		} else {
			System.out.println("You're a regular.\n");
		}
	}

	// Our old friend the Random class
	private static int createRandomId() {
		Random random = new Random(); // we instantiate a new Random object using a constructor which takes no arguments
		return random.nextInt(1000); // [0, 1000)
	}
}
