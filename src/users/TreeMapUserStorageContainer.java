package users;

import java.io.Serializable;
import java.util.TreeMap;
/** This class provides storage and authentication capabilities for User objects.
 * 
 * @author Brenden Lynch
 *
 */
public class TreeMapUserStorageContainer implements Serializable {
	private static final long serialVersionUID = 9047396112396890029L;
	private TreeMap<Integer,User> userMap;
	
	/** Creates a new TreeMapUserStorageContainer object.
	 * 
	 */
	public TreeMapUserStorageContainer() {
		userMap = new TreeMap<Integer,User>();
	}
	/** Adds a User object to the container.
	 * 
	 * @param inputUser The User to be added to the container.
	 */
	public void addUser(User inputUser) {
		userMap.put(inputUser.getUserHash(), inputUser);
	}
	/** Attempts to find a match within the container to given login credentials. If a match is found, the authentication is successful, and the matching User object is returned.
	 * 
	 * @param username The input username.
	 * @param password The input password.
	 * @return a User object that matches the input credentials, if found.
	 */
	public User authenticateUser(String username, String password) {
		String inputData = username.concat(password);
		Object returnedData = userMap.get(inputData.hashCode());
		if(returnedData != null) {
			User authenticatedUser = (User)returnedData;
			return authenticatedUser;
		} else {
			return null;
		}
	}
	/** Removes a given User object from the container, if found.
	 * 
	 * @param inputUser The User object to be removed from the container.
	 *
	 */
	public void deleteUser(User inputUser) {
		userMap.remove(inputUser.getUserHash());
	}
}
