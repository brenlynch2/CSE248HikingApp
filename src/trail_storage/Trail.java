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
	private LinkedList<PointOfInterest> pointsOfInterestContainer;
	
	public Trail(String trailName, String trailHeadAddress, double length, double elevationGain, int difficultyLevel) {
		this.trailName = trailName;
		this.trailHeadAddress = trailHeadAddress;
		this.length = length;
		this.elevationGain = elevationGain;
		this.difficultyLevel = difficultyLevel;
		this.pointsOfInterestContainer = new LinkedList<PointOfInterest>();
	}
	public Trail(String trailName) {
		this.trailName = trailName;
		this.trailHeadAddress = "default";
		this.length = 0.0;
		this.elevationGain = 0.0;
		this.difficultyLevel = 0;
		this.pointsOfInterestContainer = new LinkedList<PointOfInterest>();
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

	public LinkedList<PointOfInterest> getPointsOfInterestContainer() {
		return pointsOfInterestContainer;
	}

	public void setPointsOfInterestContainer(LinkedList<PointOfInterest> pointsOfInterestContainer) {
		this.pointsOfInterestContainer = pointsOfInterestContainer;
	}

	@Override
	public int compareTo(Trail t) {
		return this.trailName.compareTo(t.trailName);
	}
	
}
