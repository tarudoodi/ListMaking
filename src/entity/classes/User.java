package entity.classes;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.exapmle.helper.Location;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PhoneNumber;

/**
 * Class representing a single user.
 * @author Nik
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	private PhoneNumber phoneNumber;
	private String userName;
	private Boolean isPublisher;
	private Location userLocation;
	
	public User() {
		phoneNumber = null;
		userName = "Anonymous";
		isPublisher = false;
		userLocation = new Location();
	}
	
	/**
	 * Key is read only.
	 * @return Key value
	 */
	public Key getKey() {
		return key;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getIsPublisher() {
		return isPublisher;
	}

	public void setIsPublisher(Boolean isPublisher) {
		this.isPublisher = isPublisher;
	}

	public Location getLocation() {
		return userLocation;
	}

	public void setLocation(Location location) {
		this.userLocation = location;
	}
	
	/**
	 * Creates a new event if the current user has publishing privileges
	 * @return Event if event created. Null if the user does not have the privileges
	 */
	public Event createEvent()
	{
		Event newEvent = null;
		if(this.isPublisher == true)
		{
			newEvent = new Event(); //TODO change it to parameterized
		}
		return newEvent;
	}
	
}


