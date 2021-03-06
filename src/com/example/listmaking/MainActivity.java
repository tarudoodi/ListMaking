package com.example.listmaking;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.listmaking.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import entity.classes.Event;

public class MainActivity extends Activity implements OnClickListener{

	ArrayList<Event> myEvents = Event.getList();
	EventAdapter myEventAdapter;
	Button addEventButton;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// initList();
		lv  = (ListView) findViewById(R.id.listView);
		addEventButton = (Button)findViewById(R.id.eventAddButton); // Bind the button within a method

		//We get the ListView component from the layout
		// This is a simple adapter that accepts as parameter
		// Context
		// Data list
		// The row layout that is used during the row creation
		// The keys used to retrieve the data
		// The View id used to show the data. The key number and the view id must match

		//simpleAdpt = new SimpleAdapter(this, planetsList, android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] {android.R.id.text1});


		myEventAdapter = new EventAdapter(myEvents, this);
		lv.setAdapter(myEventAdapter);
		registerForContextMenu(lv);   // REGISTER FOR CONTEXT MENU  -- FOR THE OPTIONS ON LIST

		// React to user clicks on item

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position,long id) {
				//TextView clickedView = (TextView) view; // We know the View is a TextView so we can cast it
				setContentView(R.layout.one_event_layout);
				//Toast.makeText(MainActivity.this, "Item with id ["+id+"] - Position ["+position+"] " + "- Planet ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();
			}
		});		


		//user click to add event; just redirect to the addEvent layout.
		// We want to create a context Menu when the user long click on an item
		// Replace this by swipe to hide 

		addEventButton.setOnClickListener(this);

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		// Implements our logic
		Toast.makeText(this, "Item id ["+itemId+"]", Toast.LENGTH_SHORT).show();
		return true;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == addEventButton)
		{
		    //create a new intent that will launch the new 'page'
	    	Intent addEventIntent = new Intent(MainActivity.this, AddEventActivity.class);
	    	startActivity(addEventIntent);
		}
	}
}