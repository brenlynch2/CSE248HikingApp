package utilities;

import java.io.Serializable;
import java.util.LinkedList;

public class BackupContainer implements Serializable{
	private static final long serialVersionUID = 3213054246005022461L;
	private LinkedList<Object> internalStorage;
	
	public BackupContainer() {
		internalStorage = new LinkedList<Object>();
	}
	public boolean addData(Object input) {
		return internalStorage.add(input);
	}
	public boolean deleteData(Object input) {
		return internalStorage.remove(input);
	}
	/*
	 * Container should always store the UserStorageContainer at index 0 and TrailStorageContainer at index 1.
	 */
	public Object getData(int index) {
		if(index <= internalStorage.size()) {
			return internalStorage.get(index);
		} else {
			return null;
		}
	}
}
