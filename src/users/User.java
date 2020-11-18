package users;

import java.io.Serializable;
import java.util.LinkedList;

import history.HikingHistoryEntry;
import history.HikingHistoryStorageContainer;
/** This class represents a user's account.
 * 
 * @author Brenden Lynch
 *
 */
public class User implements Comparable<User>, Serializable {
	/*
	 * For the sake of simplicity, profilePicture is defined as String datatype. This will obviously
	 * be changed later on to accommodate an actual picture.
	 */
	private static final long serialVersionUID = -3312045872475389924L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String username;
	private String password;
	private String profilePicture;
	private HikingHistoryStorageContainer historyList;
	private boolean isAdmin;
	private int userHash;
	
	/** Create a new User object, profilePicture is not neccesary.
	 * 
	 * @param username The new user's username.
	 * @param password The new user's password.
	 * @param firstName The new user's first name.
	 * @param lastName The new user's last name.
	 * @param phoneNumber The new user's phone number.
	 */
	public User(String firstName, String lastName, String phoneNumber, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.historyList = new HikingHistoryStorageContainer();
		this.userHash = generateHash(username,password);
		this.isAdmin = false;
	}
	/** Create a new User object, profilePicture is neccesary.
	 * 
	 * @param username The new user's username.
	 * @param password The new user's password.
	 * @param profilePicture The new user's profile picture.
	 * @param firstName The new user's first name.
	 * @param lastName The new user's last name.
	 * @param phoneNumber The new user's phone number.
	 */
	public User(String firstName, String lastName, String phoneNumber,String username, String password, String profilePicture) {
		this.username = username;
		this.password = password;
		this.profilePicture = profilePicture;
		this.historyList = new HikingHistoryStorageContainer();
		this.userHash = generateHash(username,password);
		this.isAdmin = false;
	}
	/** Create a new User object with specified HikingHistoryStorageContainer, profilePicture is not neccesary.
	 * 
	 * @param username The new user's username.
	 * @param password The new user's password.
	 * @param firstName The new user's first name.
	 * @param lastName The new user's last name.
	 * @param phoneNumber The new user's phone number.
	 * @param historyList The new user's HikingHistoryStorageContainer.
	 */
	public User(String firstName, String lastName, String phoneNumber, String username, String password, HikingHistoryStorageContainer historyList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.historyList = historyList;
		this.userHash = generateHash(username,password);
		this.isAdmin = false;
	}
	/** Create a new User object from only username and password.
	 * 
	 * @param username The new user's username.
	 * @param password The new user's password.
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.profilePicture = "default";
		this.historyList = new HikingHistoryStorageContainer();
		this.userHash = generateHash(username,password);
		this.isAdmin = false;
	}
	private int generateHash(String username, String password) {
		String stringToHash = new String(username.concat(password));
		return stringToHash.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (historyList == null) {
			if (other.historyList != null)
				return false;
		} else if (!historyList.equals(other.historyList))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profilePicture == null) {
			if (other.profilePicture != null)
				return false;
		} else if (!profilePicture.equals(other.profilePicture))
			return false;
		if (userHash != other.userHash)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public int compareTo(User inputUserToCompare) {
		/*
		 * this compareTo method only looks at the userHash value!!! it is implemented in this manner so the
		 * Collections sorting algorithms(More efficient) can be used to sort the userStorageContainer, so that 
		 * a binary search can be properly performed at login time.
		 * 
		 */
		if(inputUserToCompare.userHash > this.userHash) {
			return -1;
		} else if(inputUserToCompare.userHash < this.userHash) {
			return 1;
		} else if(inputUserToCompare.userHash == this.userHash) {
			return 0;
		}
			return 1;
	}
	/** Gets the user's username.
	 * 
	 * @return a String containing the user's username.
	 */
	public String getUsername() {
		return username;
	}
	/** Sets the user's username.
	 * 
	 * @param username The user's new username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/** Gets the user's password.
	 * 
	 * @return a String containing the user's password.
	 */
	public String getPassword() {
		return password;
	}
	/** Sets the user's password.
	 * 
	 * @param password The user's new password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/** Gets the user's profile picture.
	 * 
	 * @return a String representation of the user's profile picture.
	 */
	public String getProfilePicture() {
		return profilePicture;
	}
	/** Sets the user's profile picture.
	 * 
	 * @param profilePicture a String representation of the user's profile picture.
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	/** Gets a copy of the HikingHistoryStorageContainer associated with a specific User object.
	 * 
	 * @return a HikingHistoryStorageContainer object.
	 */
	public HikingHistoryStorageContainer getHistoryList() {
		return historyList;
	}
	/** Sets the HikingHistoryStorageContainer to an input HikingHistoryStorageContainer object.
	 * 
	 * @param historyList The HikingHistoryStorageContainer to replace the one currently associated with this User object.
	 */
	public void setHikingHistoryStorageContainer(HikingHistoryStorageContainer historyList) {
		this.historyList = historyList;
	}
	/** Gets the userHash value.
	 * 
	 * @return an int userHash value.
	 */
	public int getUserHash() {
		return userHash;
	}
	/** Adds a specified HikingHistoryEntry to this user's HikingHistoryStorageContainer.
	 * 
	 * @param inputEntry the HikingHistoryEntry to be added to the container.
	 */
	public void addHistoryEntry(HikingHistoryEntry inputEntry) {
		historyList.addHistoryEntry(inputEntry);
	}
	/** Removes a specified HikingHistoryEntry from this user's HikingHistoryStorageContainer, if found.
	 * 
	 * @param inputEntry the HikingHistoryEntry to be removed from the container.
	 */
	public void deleteHistoryEntry(HikingHistoryEntry inputEntry) {
		historyList.deleteHistoryEntry(inputEntry);
	}
	/** Gets the first name of this user.
	 * 
	 * @return a String containing this user's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	/** Sets the first name of this user.
	 * 
	 * @param firstName The new first name of this user.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/** Gets the last name of this user.
	 * 
	 * @return a String containing this user's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	/** Sets the last name of this user.
	 * 
	 * @param lastName The new last name of this user.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/** Gets this user's phome number.
	 * 
	 * @return a String containing this user's phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/** Sets this user's phome number.
	 * 
	 * @param phoneNumber The new phone number of this user.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/** Returns true if this user is considered an administrator, false if the user is not.
	 * 
	 * @return a Boolean value reflecting the administrative status of this user.
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	/** Sets the isAdmin flag.
	 * 
	 * @param isAdmin the new value of isAdmin, true for administrator, false for normal user.
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
