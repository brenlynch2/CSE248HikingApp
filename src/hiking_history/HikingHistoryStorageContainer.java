package hiking_history;

import java.io.Serializable;
import java.util.LinkedList;

public class HikingHistoryStorageContainer implements Serializable {
	/*
	 * Since the project specifications clearly state that the entries into the Hiking History
	 * must not be changed from the order in which they were taken, and for the sake of simplicity,
	 * there are no sorting methods yet avaliable for this class. They will be designed and implemented
	 * later.
	 */
	private static final long serialVersionUID = -7009333831083038934L;
	private LinkedList<HikingEntry> hikingHistoryList;
	
	public HikingHistoryStorageContainer() {
		hikingHistoryList = new LinkedList<HikingEntry>();
	}
	public boolean addHistoryEntry(HikingEntry entryToAdd) {
		return hikingHistoryList.add(entryToAdd);
	}
	public boolean deleteHistoryEntry(HikingEntry entryToRemove) {
		return hikingHistoryList.remove(entryToRemove);
	}
	public HikingEntry getEntry(int index) {
		if(index <= hikingHistoryList.size()) {
			return hikingHistoryList.get(index);
		}
		return null;
	}
}
