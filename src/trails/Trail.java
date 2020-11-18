package trails;

import java.io.Serializable;
import java.util.LinkedList;
/** This class represents a trail.
 * 
 * @author Brenden Lynch
 *
 */
public class Trail implements Comparable<Trail>, Serializable {

	private static final long serialVersionUID = 584287922068617299L;
	private String trailName;
	private String trailHeadAddress;
	private double length;
	private double elevationGain;
	private int difficultyLevel;
	private PointOfInterestStorageContainer pointsOfInterestList;
	
	/** Creates a new Trail object.
	 * 
	 * @param trailName The name of the trail.
	 * @param trailHeadAddress The address of the trail.
	 * @param length The length of the trail.
	 * @param elevationGain The elevation gain of the trail.
	 * @param difficultyLevel The difficulty level of the trail.
	 */
	public Trail(String trailName, String trailHeadAddress, double length, double elevationGain, int difficultyLevel) {
		this.trailName = trailName;
		this.trailHeadAddress = trailHeadAddress;
		this.length = length;
		this.elevationGain = elevationGain;
		this.difficultyLevel = difficultyLevel;
		this.pointsOfInterestList = new PointOfInterestStorageContainer();
	}
	/** Creates a new trail object. This constructor places default values in all parameters except for trailName.
	 * 
	 * @param trailName The name of the trail.
	 */
	public Trail(String trailName) {
		this.trailName = trailName;
		this.trailHeadAddress = "default";
		this.length = 0.0;
		this.elevationGain = 0.0;
		this.difficultyLevel = 0;
		this.pointsOfInterestList = new PointOfInterestStorageContainer();
	}
	/** Gets the name of the trail.
	 * 
	 * @return a String containing the name of the trail.
	 */
	public String getTrailName() {
		return trailName;
	}
	/** Sets the name of the trail.
	 * 
	 * @param trailName The new name for the trail.
	 */
	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}
	/** Gets the address of the trail.
	 * 
	 * @return a String containing the address of the trail.
	 */
	public String getTrailHeadAddress() {
		return trailHeadAddress;
	}
	/** Sets the trail's address.
	 * 
	 * @param trailHeadAddress The new address for the trail.
	 */
	public void setTrailHeadAddress(String trailHeadAddress) {
		this.trailHeadAddress = trailHeadAddress;
	}
	/** Gets the length of the trail.
	 * 
	 * @return a double value containing the length of the trail.
	 */
	public double getLength() {
		return length;
	}
	/** Sets the length of the trail.
	 * 
	 * @param length The new length of the trail.
	 */
	public void setLength(double length) {
		this.length = length;
	}
	/** Gets the trail's elevation gain.
	 * 
	 * @return a double value containing the elevation gain.
	 */
	public double getElevationGain() {
		return elevationGain;
	}
	/** Sets the trail's elevation gain.
	 * 
	 * @param elevationGain The new elevation gain for the trail.
	 */
	public void setElevationGain(double elevationGain) {
		this.elevationGain = elevationGain;
	}
	/** Gets the difficulty level of the trail.
	 * 
	 * @return an int value containing the difficulty level of the trail.
	 */
	public int getDifficultyLevel() {
		return difficultyLevel;
	}
	/** Sets the difficulty level of the trail.
	 * 
	 * @param difficultyLevel The new difficulty level of the trail.
	 */
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	/** Gets the current PointOfInterestStorageContainer object associated with this trail.
	 * 
	 * @return a copy of the PointOfInterestContainer associated with this trail.
	 */
	public PointOfInterestStorageContainer getPointsOfInterestList() {
		return pointsOfInterestList;
	}
	/** Sets the PointOfInterestContainer associated with this trail.
	 * 
	 * @param pointsOfInterestList The new PointOfInterestStorageContainer.
	 */
	public void setPointsOfInterestList(PointOfInterestStorageContainer pointsOfInterestList) {
		this.pointsOfInterestList = pointsOfInterestList;
	}

	@Override
	public int compareTo(Trail t) {
		return this.trailName.compareTo(t.trailName);
	}
	@Override
	public String toString() {
		return "Trail [trailName=" + trailName + ", trailHeadAddress=" + trailHeadAddress + ", length=" + length
				+ ", elevationGain=" + elevationGain + ", difficultyLevel=" + difficultyLevel
				+ ", pointsOfInterestList=" + pointsOfInterestList + "]";
	}
}
