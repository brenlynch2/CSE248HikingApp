package trail_storage;

import java.io.Serializable;
import java.util.LinkedList;

public class Trail implements Comparable<Trail>, Serializable {
	private static final long serialVersionUID = 584287922068617299L;
	private String trailName;
	private String trailHeadAddress;
	private double length;
	private double elevationGain;
	private int difficultyLevel;
	private PointOfInterestStorageContainer pointsOfInterestList;
	
	public Trail(String trailName, String trailHeadAddress, double length, double elevationGain, int difficultyLevel) {
		this.trailName = trailName;
		this.trailHeadAddress = trailHeadAddress;
		this.length = length;
		this.elevationGain = elevationGain;
		this.difficultyLevel = difficultyLevel;
		this.pointsOfInterestList = new PointOfInterestStorageContainer();
	}
	public Trail(String trailName) {
		this.trailName = trailName;
		this.trailHeadAddress = "default";
		this.length = 0.0;
		this.elevationGain = 0.0;
		this.difficultyLevel = 0;
		this.pointsOfInterestList = new PointOfInterestStorageContainer();
	}

	public String getTrailName() {
		return trailName;
	}

	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}

	public String getTrailHeadAddress() {
		return trailHeadAddress;
	}

	public void setTrailHeadAddress(String trailHeadAddress) {
		this.trailHeadAddress = trailHeadAddress;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getElevationGain() {
		return elevationGain;
	}

	public void setElevationGain(double elevationGain) {
		this.elevationGain = elevationGain;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public PointOfInterestStorageContainer getPointsOfInterestList() {
		return pointsOfInterestList;
	}

	public void setPointsOfInterestList(PointOfInterestStorageContainer pointsOfInterestList) {
		this.pointsOfInterestList = pointsOfInterestList;
	}

	@Override
	public int compareTo(Trail t) {
		return this.trailName.compareTo(t.trailName);
	}
	
}
