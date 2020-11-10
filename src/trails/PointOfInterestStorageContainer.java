package trails;

import java.io.Serializable;
import java.util.LinkedList;

/** This class provides storage and organizational functionality for PointOfInterest objects.
 * 
 * @author Brenden Lynch
 *
 */
public class PointOfInterestStorageContainer implements Serializable {
	private static final long serialVersionUID = 5831817591743592862L;
	private LinkedList<PointOfInterest> pointsOfInterestList;
	
	/** Creates a new PointOfInterestStorageContainer object.
	 * 
	 */
	public PointOfInterestStorageContainer() {
		pointsOfInterestList = new LinkedList<PointOfInterest>();
	}
	/** Adds a new PointOfInterest to the container.
	 * 
	 * @param inputPointOfInterest The PointOfInterest to add to the container.
	 * @return a boolean value indicating the successful execution of the method.
	 */
	public boolean addPointOfInterest(PointOfInterest inputPointOfInterest) {
		return pointsOfInterestList.add(inputPointOfInterest);
	}
	/** Removes a specified PointOfInterest from the container, if found.
	 * 
	 * @param inputPointOfInterest The PointOfInterest to be removed.
	 * @return a boolean value indicating the successful execution of this method.
	 */
	public boolean deletePointOfInterest(PointOfInterest inputPointOfInterest) {
		return pointsOfInterestList.remove(inputPointOfInterest);
	}
	/** Gets the PointOfInterest at a specified point within the container's internal data structure.
	 * 
	 * @param index The index of the PointOfInterest to retrieve.
	 * @return a PointOfInterest located at the specified value of index, if found.
	 */
	public PointOfInterest getPointOfInterest(int index) {
		if(index <= pointsOfInterestList.size()) {
			return pointsOfInterestList.get(index);
		}
		return null;
	}
}
