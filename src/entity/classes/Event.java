package entity.classes;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.exapmle.helper.Location;
import com.google.appengine.api.datastore.Key;
/**
 * Class representing an event.
 * @author Nik
 *
 */
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	//The publishing user's ID
	
	private long upVotes;
	private long downVotes;
	/**
	 * Madatory fields at the time of event creation
	 */
	private Key ownerId;
	private Date eventTime;
	private Location eventLocation;
	private EventType eventType;
	//TODO Find a way to get the GPS coordinates from address provided by user
	
	/**
	 * Default Constructor.
	 * @exception Should not be used to create an event that has to be stored in the datastore. Use parameterized constructor. 
	 * 
	 */
	public Event() {
		ownerId = null;
		upVotes = 0;
		downVotes = 0;
		eventTime = null ;
		eventLocation = new Location();
		eventType = EventType.Default;
	}
	
	/**
	 * Creates a new Event with all the required fields. Must be used to create event while storing in the datastore.
	 * @param ownerId	ID of the user publishing the event. Pass user.getKey().
	 * @param eventTime	The date and time of the event.
	 * @param eventLocation The GPS coordinates of the event	
	 * @param eventType The type of event being created. Use enumeration Event.EventType.
	 */
	public Event(Key ownerId, Date eventTime, Location eventLocation,
			EventType eventType) {
		super();
		this.ownerId = ownerId;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.eventType = eventType;
	}


	public Key getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Key ownerId) {
		this.ownerId = ownerId;
	}
	public long getUpVotes() {
		return upVotes;
	}
	public void setUpVotes(long upVotes) {
		this.upVotes = upVotes;
	}
	public long getDownVotes() {
		return downVotes;
	}
	public void setDownVotes(long downVotes) {
		this.downVotes = downVotes;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	public Location getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(Location eventLocation) {
		this.eventLocation = eventLocation;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	public Key getKey() {
		return key;
	}
	
}

/**
 * Types of Events.
 * @author Nik
 *
 */
enum EventType{
	//The default value of the type of event
	Default,
	Academic,
	Social,
	Free;
}
