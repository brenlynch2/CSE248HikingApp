package users;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
/**
 * 
 * @author Brenden Lynch
 * @deprecated This class is superceded by the TreeMapUserStorageContainer, which has already been proven to be more efficient.
 *
 */
@Deprecated
public class LinkedListUserStorageContainer {
	private LinkedList<User> userList;
	
	public LinkedListUserStorageContainer() {
		userList = new LinkedList<User>();
	}
	public void addUser(User inputUser) {
		if(userList.add(inputUser)) {
			Collections.sort(userList);
		}
	}
	public void deleteUser(User inputUser) {
		if(userList.remove(inputUser)) {
			Collections.sort(userList);
		}
	}
	public User getUser(int index) {
		if(index <= userList.size()) {
			return userList.get(index);
		}
		return null;
	}
	public void sortUserList() {
		/*
		 * According to the documentation, the algorithm behind this method is a special mergesort
		 * that provides a worst-case (List is completely unsorted) time complexity of nlog(n). This
		 * algorithm becomes more efficient once the list has been at least partially sorted, hence
		 * adding a user into an already-sorted list is much more efficient than nlog(n). This is
		 * good for the overall efficiency of the program.
		 */
		Collections.sort(userList);
	}
	public User authenticateUser(String username, String password) {
		/*
		 * This method attempts to find a User object generated at runtime with the credentials
		 * provided to the login window in the userList. Instead of comparing Strings, the userHash
		 * of the input User object(int datatype) is used as a key in a binary search method to 
		 * locate a matching User entry in the userList. This is more efficient than linearly searching 
		 * the userList and performing String comparisons. This method returns null if a match cannot 
		 * be found (Indiciative of an Invalid username and/or password) and returns a copy of the
		 * matching  User object if a match is found.
		 * 
		 */
		Comparator<User> userHashComparator = new Comparator<User>(){
			@Override
			public int compare(User u1, User u2) {
				if(u1.getUserHash() == u2.getUserHash()) {
					return 0;
				} else if(u1.getUserHash() > u2.getUserHash()) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		User inputUser = new User(username,password);
		int result = Collections.binarySearch(userList, inputUser, userHashComparator);
		if(result >= 0 && result <= userList.size()) {
			return userList.get(result);
		} else {
			return null;
		}
	}
}
