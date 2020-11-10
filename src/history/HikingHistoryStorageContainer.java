package history;

import java.io.Serializable;
import java.util.LinkedList;
/** This class provides storage and organizational functionality for HikingHistoryEntry objects.
 * 
 * @author Brenden Lynch
 *
 */
public class HikingHistoryStorageContainer implements Serializable {
	
	private static final long serialVersionUID = -7009333831083038934L;
	private LinkedList<HikingHistoryEntry> hikingHistoryList;
	
	/** Creates a new HikingHistoryStorageContainer.
	 * 
	 */
	public HikingHistoryStorageContainer() {
		hikingHistoryList = new LinkedList<HikingHistoryEntry>();
	}
	/** Adds a new HikingHistoryEntry to the container.
	 * 
	 * @param entryToAdd The new HikingHistoryEntry to add to the container.
	 * @return a boolean value indicating the successful execution of the method.
	 */
	public boolean addHistoryEntry(HikingHistoryEntry entryToAdd) {
		return hikingHistoryList.add(entryToAdd);
	}
	/** Removes a specified HikingHistoryEntry from the container, if found.
	 * 
	 * @param entryToRemove The HikingHistoryEntry to remove from the container.
	 * @return a boolean value indicating the successful execution of the method.
	 */
	public boolean deleteHistoryEntry(HikingHistoryEntry entryToRemove) {
		return hikingHistoryList.remove(entryToRemove);
	}
	/** Gets the HikingHistoryEntry at a specified point in the container's internal data structure.
	 * 
	 * @param index The index of the HikingHistoryEntry to retrieve.
	 * @return a HikingHistoryEntry located at the specified value of index, if found.
	 */
	public HikingHistoryEntry getEntry(int index) {
		if(index <= hikingHistoryList.size()) {
			return hikingHistoryList.get(index);
		}
		return null;
	}
}
