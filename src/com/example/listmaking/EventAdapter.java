package com.example.listmaking;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import entity.classes.Event;

public class EventAdapter extends ArrayAdapter<Event> {
	   
//	   private List<events> planetList;
	   ArrayList<Event> myEvents = Event.getList();
	   private Context context;
	    
	   public EventAdapter(List<Event> myEvents , Context ctx) {
	       super(ctx, R.layout.events_view, myEvents);
	       this.myEvents = (ArrayList<Event>) myEvents;
	       this.context = ctx;
	   }
	    
	   public View getView(int position, View convertView, ViewGroup parent) {
	        
	       // First let's verify the convertView is not null
	       if (convertView == null) {
	           // This a new view we inflate the new layout
	           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	           convertView = inflater.inflate(R.layout.events_view, parent, false);
	       }
	           // Now we can fill the layout with the right values
	           TextView eventNameView = (TextView) convertView.findViewById(R.id.eventName);
	           TextView eventLocationView = (TextView) convertView.findViewById(R.id.eventLocation);
	           TextView eventTimeView = (TextView) convertView.findViewById(R.id.eventTime);
	           Event eventId = myEvents.get(position);
	           
	           //p = planetList.get(position);
	    
	           eventNameView.setText(eventId.getEventName());
	           eventLocationView.setText(eventId.getEventLocation());
	           eventTimeView.setText(eventId.getEventTime());
	           //distView.setText("" + p.getDistance());
	       return convertView;
	   }
}
