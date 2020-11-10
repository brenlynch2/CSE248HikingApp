package trails;

import java.io.Serializable;
/** This class represents any waypoints (points of interest) that can be found on a particular trail.
 * 
 * @author Brenden Lynch
 *
 */
public class PointOfInterest implements Serializable, Comparable<PointOfInterest> {
	private static final long serialVersionUID = 1664500342903251687L;
	private String pointIdentifiers;
	private int typeOfPoint;
	private double altitude;
	private double mileMarker;
	
	/** Creates a new PointOfInterest object.
	 * 
	 * @param pointIdentifiers A String containing any identifiable features associated with this point of interest.
	 * @param typeOfPoint The int value indicating the type of point of this point of interest.
	 * @param altitude The double value indicating the altitute of this point of interest.
	 * @param mileMarker The double value indicating this point of interest's mile marker along the trail.
	 */
	public PointOfInterest(String pointIdentifiers, int typeOfPoint, double altitude, double mileMarker) {
		this.pointIdentifiers = pointIdentifiers;
		this.typeOfPoint = typeOfPoint;
		this.altitude = altitude;
		this.mileMarker = mileMarker;
	}
	/** Gets the point identifiers associated with this PointOfInterest.
	 * 
	 * @return the point identifiers associated with this PointOfInterest.
	 */
	public String getPointIdentifiers() {
		return pointIdentifiers;
	}
	/** Sets the point identifiers associated with this PointOfInterest.
	 * 
	 * @param pointIdentifiers The new point identifiers to be associated with this PointOfInterest.
	 */
	public void setPointIdentifiers(String pointIdentifiers) {
		this.pointIdentifiers = pointIdentifiers;
	}
	/** Gets an int value representing the type of point this PointOfInterest is.
	 * 
	 * @return the int value indicating the type of point of this PointOfInterest.
	 */
	public int getTypeOfPoint() {
		return typeOfPoint;
	}
	/** Sets the int value representing the type of point this PointOfInterest is.
	 * 
	 * @param typeOfPoint The new int value to be associated with the typeOfPoint property of this PointOfInterest.
	 */
	public void setTypeOfPoint(int typeOfPoint) {
		this.typeOfPoint = typeOfPoint;
	}
	/** Gets the double altitude value associated with this PointOfInterest.
	 * 
	 * @return the altitude value associated with this PointOfInterest.
	 */
	public double getAltitude() {
		return altitude;
	}
	/** Sets the double altitude value associated with this PointOfInterest.
	 * 
	 * @param altitude The new altitude value to be associated with this PointOfInterest.
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	/** Gets the double mile marker value associated with this PointOfInterest.
	 * 
	 * @return the double mile marker value associated with this PointOfInterest.
	 */
	public double getMileMarker() {
		return mileMarker;
	}
	/** Sets the double mile marker value associated with this PointOfInterest.
	 * 
	 * @param mileMarker The new double mile marker value to be associated with this PointOfInterest.
	 */
	public void setMileMarker(double mileMarker) {
		this.mileMarker = mileMarker;
	}

	@Override
	public int compareTo(PointOfInterest p) {
		if(this.mileMarker > p.mileMarker) {
			return 1;
		} else if(this.mileMarker < p.mileMarker) {
			return -1;
		} else {
			return 0;
		}
	}
}
