package hiking_history;

import java.io.Serializable;
import java.util.LinkedList;

import trail_storage.Trail;

public class HikingHistoryEntry implements Serializable{
	/*
	 * For the sake of simplicity picturesTaken is defined with String as the list's storage datatype.
	 * This will obviously be changed later in the development of the program to accomodate pictures.
	 */
	private static final long serialVersionUID = -7426859900974503870L;
	private Trail trailHiked;
	private String timestamp;
	private double distance;
	private String duration;
	private LinkedList<String> picturesTaken;
	private double averagePace;
	
	public Trail getTrailHiked() {
		return trailHiked;
	}

	public void setTrailHiked(Trail trailHiked) {
		this.trailHiked = trailHiked;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public LinkedList<String> getPicturesTaken() {
		return picturesTaken;
	}

	public void setPicturesTaken(LinkedList<String> picturesTaken) {
		this.picturesTaken = picturesTaken;
	}

	public double getAveragePace() {
		return averagePace;
	}

	public void setAveragePace(double averagePace) {
		this.averagePace = averagePace;
	}

	public HikingHistoryEntry(Trail trailHiked, String timestamp, double distance, String duration, LinkedList<String> picturesTaken, double averagePace) {
		this.trailHiked = trailHiked;
		this.timestamp = timestamp;
		this.distance = distance;
		this.duration = duration;
		this.picturesTaken = new LinkedList<String>();
		this.averagePace = averagePace;
	}
}
