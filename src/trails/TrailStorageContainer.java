package trails;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
/** This class provides storage and organizational functionality for Trail objects.
 * 
 * @author Brenden Lynch
 *
 */
public class TrailStorageContainer implements Serializable {
	private static final long serialVersionUID = -3031531439222242680L;
	private LinkedList<Trail> trailList;
	
	/** Creates a new TrailStorageContainer object.
	 * 
	 */
	public TrailStorageContainer() {
		this.trailList = new LinkedList<Trail>();
	}
	/** Adds a new Trail to the container. Automatically sorts the container alphabetically if this is successful.
	 * 
	 * @param inputTrail The Trail to add to the container.
	 */
	public void addTrail(Trail inputTrail) {
		if(trailList.add(inputTrail)) {
			sortTrailList();
		}
	}
	/** Removes a specified Trail object from the container. If an element is successfully matched and removed, the container is sorted alphabetically.
	 * 
	 * @param inputTrail The Trail to be removed from the container.
	 */
	public void deleteTrail(Trail inputTrail) {
		if(trailList.remove(inputTrail)) {
			sortTrailList();
		}
	}
	/** Gets the Trail object at the specified index within the container's internal data structure.
	 * 
	 * @param index The index of the Trail to retrieve.
	 * @return The trail object at the specified index value, if found.
	 */
	public Trail getTrail(int index) {
		if(index <= trailList.size()) {
			return trailList.get(index);
		}
		return null;
	}
	/** Automatically sorts the container by alphabetical order.
	 * 
	 */
	public void sortTrailList() {
		/*
		 * This method uses the same sorting algorithm that is used in the LinkedListUserStorageContainer class.
		 * See the comments within the sortUserList() method.
		 * 
		 */
		Collections.sort(trailList);
	}
	/** Performs a search through the container and returns Trail objects matching specified input search criteria in the form of a LinkedList.
	 * 
	 * @param searchTerms The input search criteria to compare Trail objects to.
	 * @return a LinkedList containing all Trail objects that match the search criteria. If none found, this list is returned empty.
	 */
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
