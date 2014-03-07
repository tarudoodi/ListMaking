package entity.classes;

import java.util.ArrayList;

public class Events {
	
	private String eventName;
	private String eventLocation;
	private String eventTime;

	private static ArrayList<Events> EventList = new ArrayList<Events>();
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * Creates a new event
	 * @return boolean : true if successful else false
	 **/
	public boolean CreateEvent()
	{
		return false;
		
	}
	
	public static ArrayList<Events> getList()
	{
		for(int i=1;i<9;i++)
		{
			Events event= new Events();
			event.eventLocation = "location " + i;
			event.eventName = "Event number " + i;
			event.eventTime = "Time "+ i;
			
			EventList.add(event);
		}
		return EventList;
	}
 
	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	
}
