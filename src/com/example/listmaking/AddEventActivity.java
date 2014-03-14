package com.example.listmaking;

import com.example.listmaking.R.layout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import entity.classes.Event;

public class AddEventActivity extends Activity{

	EditText eventName;
	EditText eventLocation;
	EditText eventTime;
	EditText eventDescription;
	Event event; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);

		// submit event button	
		Button submitEventButton = (Button) findViewById(R.id.submitEventButton);
		submitEventButton.setOnClickListener(submitEvent) ;

		// get all view IDs for text
		eventName = (EditText) findViewById(R.id.eventNameWhat);
		eventLocation = (EditText) findViewById(R.id.eventLocationWhere);
		eventTime = (EditText) findViewById(R.id.eventTimeWhen);
		eventDescription = (EditText) findViewById(R.id.eventDescription);

		// instantiate to create an event
		event = new Event();
	}


	//@Override
	public OnClickListener submitEvent = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Boolean incompleteFlag = false;
			// Make the colors to default
			eventName.setBackgroundColor(Color.TRANSPARENT);
			
			String eventNameString = eventName.getText().toString();
			String eventLocationString = eventLocation.getText().toString();
			String eventTimeString = eventTime.getText().toString();
			String eventDescriptionString = eventDescription.getText().toString();

			if(eventNameString == null || eventNameString.isEmpty())
			{
				eventName.setBackgroundColor(Color.LTGRAY);
				incompleteFlag = true;
			}
			
			if(incompleteFlag)
			{
				Toast.makeText(getApplicationContext(), "Looks like you missed these!!!", Toast.LENGTH_SHORT).show();
			}
			// check this comparison
			if ((eventNameString.equals("")  || eventLocationString.equals("") || eventTimeString.equals("") || eventDescriptionString.equals(""))) 
			{
				Toast.makeText(getApplicationContext(),"Please fill all the fields.",Toast.LENGTH_SHORT).show();
			} 
			else 
			{
				event.CreateEvent();
			}
		}
	};
}


