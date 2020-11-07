package trail_storage;

import java.io.Serializable;

public class PointOfInterest implements Serializable, Comparable<PointOfInterest> {
	private static final long serialVersionUID = 1664500342903251687L;
	private String pointIdentifiers;
	private int typeOfPoint;
	private double altitude;
	private double mileMarker;
	
	public PointOfInterest(String pointIdentifiers, int typeOfPoint, double altitude, double mileMarker) {
		this.pointIdentifiers = pointIdentifiers;
		this.typeOfPoint = typeOfPoint;
		this.altitude = altitude;
		this.mileMarker = mileMarker;
	}

	public String getPointIdentifiers() {
		return pointIdentifiers;
	}

	public void setPointIdentifiers(String pointIdentifiers) {
		this.pointIdentifiers = pointIdentifiers;
	}

	public int getTypeOfPoint() {
		return typeOfPoint;
	}

	public void setTypeOfPoint(int typeOfPoint) {
		this.typeOfPoint = typeOfPoint;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public double getMileMarker() {
		return mileMarker;
	}

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
