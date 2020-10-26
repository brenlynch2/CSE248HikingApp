package utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import trail_storage.Trail;
import trail_storage.TrailStorageContainer;
import users_login.LinkedListUserStorageContainer;
import users_login.TreeMapUserStorageContainer;
import users_login.User;

public class TestingFunctions {
	private static LinkedList<String> listOfLastNames = new LinkedList<String>();
	private static LinkedList<String> listOfFirstNames = new LinkedList<String>();
	private static LinkedList<String> listOfTitles = new LinkedList<String>();
	
	public static void main(String[] args) {
		populateLists();
		System.out.println("Test Results for LinkedList based UserStorageContainer:");
		testRunLinkedListUserStorageContainer();
		System.out.println("Test Results for TreeMap based UserStorageContainer:");
		testRunTreeMapUserStorageContainer();
		System.out.println("Test Results for TrailStorageContainer:");
		testRunTrailStorageContainer();
		System.out.println("Testing is complete.");
	}
	
	private static void testRunTrailStorageContainer() {
		TrailStorageContainer testContainer = new TrailStorageContainer();
		
		//add 2000 randomly generated trails and 1 static trail to the container and print the time this took
		long initialTime = System.nanoTime();
		for(int i = 0; i < 2000; i++) {
			testContainer.addTrail(new Trail(listOfTitles.get(i)));
		}
		Trail testTrail = new Trail("Brenden's Trail");
		testContainer.addTrail(testTrail);
		long timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
		
		//search for trails based on the input string "a" and print time this took
		initialTime = System.nanoTime();
		LinkedList<Trail> testSearchResults = testContainer.searchTrailList("a");
		timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
		
		//delete the static trail added to the list and print the time this took
		initialTime = System.nanoTime();
		testContainer.deleteTrail(testTrail);
		timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
	}

	private static void testRunTreeMapUserStorageContainer() {
		TreeMapUserStorageContainer testContainer = new TreeMapUserStorageContainer();
		StringBuilder usernameBuilder = new StringBuilder();
		StringBuilder passwordBuilder = new StringBuilder();
		
		//add 2000 users to the list and return the time this took.
		long initialTime = System.nanoTime();
		for(int i = 0; i < 2000; i++) {
			usernameBuilder.append(listOfFirstNames.get(i) + ' ' + listOfLastNames.get(i));
			passwordBuilder.append(listOfTitles.get(i));
			testContainer.addUser(new User(usernameBuilder.toString(), passwordBuilder.toString()));
		}
		long timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
		
		//authenticate a user already added to the list
		User testUser = new User("Brenden Lynch", "123456789");
		testContainer.addUser(testUser);
		initialTime = System.nanoTime();
		testContainer.authenticateUser("Brenden Lynch", "123456789");
		timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
		
		//remove a user from the list
		initialTime = System.nanoTime();
		testContainer.deleteUser(testUser);
		timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
		
	}

	private static void testRunLinkedListUserStorageContainer() {
		LinkedListUserStorageContainer testContainer = new LinkedListUserStorageContainer();
		StringBuilder usernameBuilder = new StringBuilder();
		StringBuilder passwordBuilder = new StringBuilder();
		
		//add 2000 users to the list and return the time this took.
		long initialTime = System.nanoTime();
		for(int i = 0; i < 2000; i++) {
			usernameBuilder.append(listOfFirstNames.get(i) + ' ' + listOfLastNames.get(i));
			passwordBuilder.append(listOfTitles.get(i));
			testContainer.addUser(new User(usernameBuilder.toString(), passwordBuilder.toString()));
		}
		long timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
		
		//authenticate a user already added to the list
		User testUser = new User("Brenden Lynch", "123456789");
		testContainer.addUser(testUser);
		initialTime = System.nanoTime();
		testContainer.authenticateUser("Brenden Lynch", "123456789");
		timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
		
		//remove a user from the list
		initialTime = System.nanoTime();
		testContainer.deleteUser(testUser);
		timeToComplete = System.nanoTime() - initialTime;
		System.out.println(timeToComplete);
	}

	private static void populateLists() {
		File firstNameFile = new File("First_Names.txt");
		File lastNameFile = new File("Last_Names.txt");
		File textbookTitleFile = new File("textbook_titles.txt");
		Scanner firstNameReader = null;
		Scanner lastNameReader = null;
		Scanner textbookTitleReader = null;
	
		try {
			firstNameReader = new Scanner(firstNameFile);
			lastNameReader = new Scanner(lastNameFile);
			textbookTitleReader = new Scanner(textbookTitleFile);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(),"One of the resources required to start the program is missing or damaged.", "Error", JOptionPane.PLAIN_MESSAGE);
			e.printStackTrace();
			return;
		}
		
		while(firstNameReader.hasNextLine()) {
			listOfFirstNames.add(firstNameReader.nextLine());
		}
		while(lastNameReader.hasNextLine()) {
			listOfLastNames.add(lastNameReader.nextLine());
		}
		while(textbookTitleReader.hasNextLine()) {
			listOfTitles.add(textbookTitleReader.nextLine());
		}
		firstNameReader.close();
		lastNameReader.close();
		textbookTitleReader.close();
	}
}
