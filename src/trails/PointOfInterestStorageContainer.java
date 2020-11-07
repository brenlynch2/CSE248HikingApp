package trails;

import java.util.LinkedList;

public class PointOfInterestStorageContainer {
	private LinkedList<PointOfInterest> pointsOfInterestList;
	
	public PointOfInterestStorageContainer() {
		pointsOfInterestList = new LinkedList<PointOfInterest>();
	}
	public boolean addPointOfInterest(PointOfInterest inputPointOfInterest) {
		return pointsOfInterestList.add(inputPointOfInterest);
	}
	public boolean deletePointOfInterest(PointOfInterest inputPointOfInterest) {
		return pointsOfInterestList.remove(inputPointOfInterest);
	}
	public PointOfInterest getPointOfInterest(int index) {
		if(index <= pointsOfInterestList.size()) {
			return pointsOfInterestList.get(index);
		}
		return null;
	}
}
