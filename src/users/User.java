package users;

import java.io.Serializable;
import java.util.LinkedList;

import history.HikingHistoryEntry;
import history.HikingHistoryStorageContainer;

public class User implements Comparable<User>, Serializable{
	/*
	 * For the sake of simplicity, profilePicture is defined as String datatype. This will obviously
	 * be changed later on to accommodate an actual picture.
	 */
	private static final long serialVersionUID = -3312045872475389924L;
	private String username;
	private String password;
	private String profilePicture;
	private HikingHistoryStorageContainer historyList;
	private int userHash;
	
	public User(String username, String password, String profilePicture) {
		this.username = username;
		this.password = password;
		this.profilePicture = profilePicture;
		this.historyList = new HikingHistoryStorageContainer();
		this.userHash = generateHash(username,password);
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.profilePicture = "default";
		this.historyList = new HikingHistoryStorageContainer();
		this.userHash = generateHash(username,password);
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public HikingHistoryStorageContainer getHistoryList() {
		return historyList;
	}
	public void setHikingHistoryStorageContainer(HikingHistoryStorageContainer historyList) {
		this.historyList = historyList;
	}
	public int getUserHash() {
		return userHash;
	}
}
