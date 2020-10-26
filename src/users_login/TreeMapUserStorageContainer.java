package users_login;

import java.util.TreeMap;

public class TreeMapUserStorageContainer {
	private TreeMap<Integer,User> userMap;
	
	public TreeMapUserStorageContainer() {
		userMap = new TreeMap<Integer,User>();
	}
	public void addUser(User inputUser) {
		userMap.put(inputUser.getUserHash(), inputUser);
	}
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
	public void deleteUser(User inputUser) {
		userMap.remove(inputUser.getUserHash());
	}
}
