package history;

import java.io.Serializable;
import java.util.LinkedList;

import trails.Trail;
/** This class represents a hike that a user has completed.
 * 
 * @author Brenden Lynch
 *
 */
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
	/** Creates a new HikingHistoryEntry object.
	 * 
	 * @param trailHiked A copy of the Trail object associated with this history entry.
	 * @param timestamp The timestamp associated with this history entry.
	 * @param distance The distance value associated with this history entry.
	 * @param duration The duration value associated with this history entry.
	 * @param picturesTaken A LinkedList of all pictures to be associated with this history entry.
	 * @param averagePace The average pace value associated with this history entry.
	 */
	public HikingHistoryEntry(Trail trailHiked, String timestamp, double distance, String duration, LinkedList<String> picturesTaken, double averagePace) {
		this.trailHiked = trailHiked;
		this.timestamp = timestamp;
		this.distance = distance;
		this.duration = duration;
		this.picturesTaken = new LinkedList<String>();
		this.averagePace = averagePace;
	}
	/** Creates a new HikingHistoryEntry object. picturesTaken is not neccesary.
	 * 
	 * @param trailHiked A copy of the Trail object associated with this history entry.
	 * @param timestamp The timestamp associated with this history entry.
	 * @param distance The distance value associated with this history entry.
	 * @param duration The duration value associated with this history entry.
	 * @param picturesTaken A LinkedList of all pictures to be associated with this history entry.
	 * @param averagePace The average pace value associated with this history entry.
	 */
	public HikingHistoryEntry(Trail trailHiked, String timestamp, double distance, String duration, double averagePace) {
		this.trailHiked = trailHiked;
		this.timestamp = timestamp;
		this.distance = distance;
		this.duration = duration;
		this.picturesTaken = new LinkedList<String>();
		this.averagePace = averagePace;
	}
	/** Get the Trail object associated with this history entry.
	 * 
	 * @return the Trail object associated with this hike.
	 */
	public Trail getTrailHiked() {
		return trailHiked;
	}
	/** Sets the Trail object associated with this history entry.
	 * 
	 * @param trailHiked The new Trail object to be associated with this history entry.
	 */
	public void setTrailHiked(Trail trailHiked) {
		this.trailHiked = trailHiked;
	}
	/** Gets the timestamp associated with this history entry.
	 * 
	 * @return the String timestamp associated with this history entry, 
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/** Sets the timestamp associated with this history entry.
	 * 
	 * @param timestamp The new timestamp to be associated with this history entry.
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/** Gets the distance value associated with this history entry.
	 * 
	 * @return a double value containing the distance associated with this history entry.
	 */
	public double getDistance() {
		return distance;
	}
	/** Sets the distance value associated with this history entry.
	 * 
	 * @param distance The new distance value to be associated with this history entry.
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	/** Gets the duration associated with this history entry.
	 * 
	 * @return a String containing the duration associated with this history entry.
	 */
	public String getDuration() {
		return duration;
	}
	/** Sets the duration associated with this history entry.
	 * 
	 * @param duration The new duration to be associated with this history entry.
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/** Gets a LinkedList containing all the pictures associated with this history entry.
	 * 
	 * @return a LinkedList object containing all pictures associated with this history entry.
	 */
	public LinkedList<String> getPicturesTaken() {
		return picturesTaken;
	}
	/** Sets the LinkedList used to store all pictures associated with this history entry.
	 * 
	 * @param picturesTaken The new LinkedList to replace the existing LinkedList that stores all pictures associated with this history entry.
	 */
	public void setPicturesTaken(LinkedList<String> picturesTaken) {
		this.picturesTaken = picturesTaken;
	}
	/** Gets the average pace associated with this history entry.
	 * 
	 * @return a double value representing the average pace associated with this history entry.
	 */
	public double getAveragePace() {
		return averagePace;
	}
	/** Sets the average pace associated with this history entry.
	 * 
	 * @param averagePace The new average pace to be associated with this history entry.
	 */
	public void setAveragePace(double averagePace) {
		this.averagePace = averagePace;
	}
	@Override
	public String toString() {
		return "HikingHistoryEntry [trailHiked=" + trailHiked + ", timestamp=" + timestamp + ", distance=" + distance
				+ ", duration=" + duration + ", picturesTaken=" + picturesTaken + ", averagePace=" + averagePace + "]";
	}
	
}
