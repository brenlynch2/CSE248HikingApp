package trail_storage;

import java.util.Collections;
import java.util.LinkedList;

public class TrailStorageContainer {
	private LinkedList<Trail> trailList;
	
	public TrailStorageContainer() {
		this.trailList = new LinkedList<Trail>();
	}
	public void addTrail(Trail inputTrail) {
		if(trailList.add(inputTrail)) {
			sortTrailList();
		}
	}
	public void deleteTrail(Trail inputTrail) {
		if(trailList.remove(inputTrail)) {
			sortTrailList();
		}
	}
	public Trail getTrail(int index) {
		if(index <= trailList.size()) {
			return trailList.get(index);
		}
		return null;
	}
	public void sortTrailList() {
		/*
		 * This method uses the same sorting algorithm that is used in the UserStorageContainer class.
		 * See the comments within the sortUserList() method.
		 * 
		 */
		Collections.sort(trailList);
	}
	public LinkedList<Trail> searchTrailList(String searchTerms){
		/*
		 * This method will eventually be expanded to support searching by different criteria,
		 * and will make use of a special modified binary search method for more efficient searching.
		 * For the sake of simplicity, this method currently performs a linear search for all
		 * potential matches based on the .contains() method. The current time complexity of
		 * this method is O(n).
		 */
		LinkedList<Trail> searchResults = new LinkedList<Trail>();
		for(int i = 0; i < trailList.size(); i++) {
			if(trailList.get(i).getTrailName().contains(searchTerms)) {
				searchResults.add(trailList.get(i));
			}
		}
		return searchResults;
	}
}
