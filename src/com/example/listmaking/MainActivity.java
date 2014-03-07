package com.example.listmaking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import entity.classes.Events;

public class MainActivity extends Activity {
	/*
	
	// The data to show
	List<Map<String, String>> planetsList = new ArrayList<Map<String,String>>();
	 
	private HashMap<String, String> createPlanet(String key, String name) {
	    HashMap<String, String> planet = new HashMap<String, String>();
	    planet.put(key, name);
	    return planet;
	}
			 
	   private void initList() {
	    // We populate the planets
	    planetsList.add(createPlanet("planet", "Mercury"));
	    planetsList.add(createPlanet("planet", "Venus"));
	    planetsList.add(createPlanet("planet", "Mars"));
	    planetsList.add(createPlanet("planet", "Jupiter"));
	    planetsList.add(createPlanet("planet", "Saturn"));
	    planetsList.add(createPlanet("planet", "Uranus"));
	    planetsList.add(createPlanet("planet", "Neptune"));
	    
	}
	   SimpleAdapter simpleAdpt;
	   SimpleAdapter myEventList;
	   */
	 
	   
		   ArrayList<Events> myEvents = Events.getList();
		   EventAdapter myEventAdapter;
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 // initList();
		 ListView lv = (ListView) findViewById(R.id.listView);
		  
		   
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
		        	 TextView clickedView = (TextView) view; // We know the View is a TextView so we can cast it
		        	 Toast.makeText(MainActivity.this, "Item with id ["+id+"] - Position ["+position+"] " + "- Planet ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();
		     }
		    });		    

		    
		    //user click to add event; just redirect to the addEvent layout.
//		    public void addEvent(View view) {
//		    	  final Dialog d = new Dialog(this);
//		    	   d.setContentView(R.layout.activity_main);
//		    	   d.setTitle("Add Event");
//		    	   d.setCancelable(true);
//		    	   final EditText edit = (EditText) d.findViewById(R.id.editTextPlanet);
//		    	   Button b = (Button) d.findViewById(R.id.eventAddButton);
//		    	  
//		    	   b.setOnClickListener(new View.OnClickListener() {
//				    	  public void onClick(View v) {
//				    	         String planetName = edit.getText().toString();
//				    	         MainActivity.this.planetsList.add(planetName);
//				    	        // We notify the data model is changed 
//				    	        MainActivity.this.simpleAdpt.notifyDataSetChanged();
//				    	        d.dismiss();
//		    	      }
//		    	   });
//		    	   d.show();
//		    	 }
	}

	
	// We want to create a context Menu when the user long click on an item
	
	/*
	  @Override
	  public void onCreateContextMenu(ContextMenu menu, View v,
	          ContextMenuInfo menuInfo) {
	       
	      super.onCreateContextMenu(menu, v, menuInfo);
	      AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;
	       
	      //The AdapterContextMenuInfo has an attribute that holds the item position clicked so we use this information to retrieve the item information. 
	      // We know that each row in the adapter is a Map
	      HashMap map = new HashMap();
	      map = (HashMap)simpleAdpt.getItem(aInfo.position);
	       
	      menu.setHeaderTitle("Options for " + map.get("planet"));
	      menu.add(1, 1, 1, "Details");
	      menu.add(1, 2, 2, "Delete");
	      menu.add(1, 3, 3, "Hide");
	      menu.add(0,0,0, "none");
	     
	  }
	  */
	
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
	

}
