package utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import trails.Trail;
import trails.TrailStorageContainer;
import users.LinkedListUserStorageContainer;
import users.TreeMapUserStorageContainer;
import users.User;

public class TestingFunctions {
	private static LinkedList<String> listOfLastNames = new LinkedList<String>();
	private static LinkedList<String> listOfFirstNames = new LinkedList<String>();
	private static LinkedList<String> listOfTitles = new LinkedList<String>();
	
	public static TrailStorageContainer testRunTrailStorageContainer() {
		if(listOfLastNames.size() == 0 || listOfFirstNames.size() == 0 || listOfTitles.size() == 0) {
			populateLists();
		}
		TrailStorageContainer testContainer = new TrailStorageContainer();
		
		//add 2000 randomly generated trails and 1 static trail to the container and print the time this took
		long initialTime = System.nanoTime();
		for(int i = 0; i < 10; i++) {
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
		
		return testContainer;
	}

	public static TreeMapUserStorageContainer testRunTreeMapUserStorageContainer() {
		if(listOfLastNames.size() == 0 || listOfFirstNames.size() == 0 || listOfTitles.size() == 0) {
			populateLists();
		}
		TreeMapUserStorageContainer testContainer = new TreeMapUserStorageContainer();
		StringBuilder usernameBuilder = new StringBuilder();
		StringBuilder passwordBuilder = new StringBuilder();
		
		//add 2000 users to the list and return the time this took.
		long initialTime = System.nanoTime();
		for(int i = 0; i < 10; i++) {
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
		
		return testContainer;
		
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
		File firstNameFile = new File("resources/First_Names.txt");
		File lastNameFile = new File("resources/Last_Names.txt");
		File textbookTitleFile = new File("resources/textbook_titles.txt");
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
