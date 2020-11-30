package utilities;

import java.io.Serializable;
import java.util.LinkedList;

import trails.TrailStorageContainer;
import users.TreeMapUserStorageContainer;
/** This class provides a simple container to store the TreeMapUserStorageContainer and TrailStorageContainer before being written to disk in binary form.
 * 
 * @author Brenden Lynch
 *
 */
public class BackupContainer implements Serializable{
	private static final long serialVersionUID = 3213054246005022461L;
	private LinkedList<Object> internalStorage;
	/** Creates an empty BackupContainer.
	 * 
	 */
	public BackupContainer() {
		internalStorage = new LinkedList<Object>();
	}
	/** Creates a properly-ordered BackupContainer from a provided TreeMapUserStorageContainer and TrailStorageContainer.
	 * 
	 * @param inputUserList The input TreeMapUserStorageContainer.
	 * @param inputTrailList The input TrailStorageContainer.
	 */
	public BackupContainer(TreeMapUserStorageContainer inputUserList, TrailStorageContainer inputTrailList) {
		internalStorage = new LinkedList<Object>();
		internalStorage.add(0, inputUserList);
		internalStorage.add(1, inputTrailList);
	}
	/** Returns a Boolean value corresponding to the state of the internal data struture's contents.
	 * 
	 * @return a Boolean value: true if this container is empty, false if it is not.
	 */
	public boolean isEmpty() {
		return internalStorage.isEmpty();
	}
	/** Returns the data at a given index of the internal data structure, if valid.
	 * 
	 * @param index The int value corresponding to the index of the item to be retrieved.
	 * @return the Object present at said index, should it exist.
	 */
	public Object getData(int index) {
		if(index <= internalStorage.size()) {
			return internalStorage.get(index);
		} else {
			return null;
		}
	}
}
