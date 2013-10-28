package edu.wcu.trackerapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * The application's map screen and main page.
 * 
 * @author Hayden Thomas
 * @version 10/27/13
 *
 */
public class Map extends Activity implements OnItemSelectedListener {
	
	/**
	 * A drop down menu that allows the user to navigate to other pages.
	 */
	private Spinner menu;
	
	/**
	 * Initializes the activity.
	 * 
	 * @param savedInstanceState saved data from a previous run, if any.
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        
        // Initialize the spinner
        menu = (Spinner) findViewById(R.id.menuSpinner);
        
        // Set up the listener for the spinner.
        menu.setOnItemSelectedListener(this);
        
    }


    /**
     * Adds options to the menu.
     * 
     * @param menu the menu options that will be added, if any.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map, menu);
        return true;
    }


    /**
     * Performs the appropriate action when an item is selected.
     * 
     * @param parent the object containing all of the list items.
     * @param view ?
     * @param pos the items position.
     * @param id ?
     */
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		String item = parent.getItemAtPosition(pos).toString();
		
		handleSelection(item);
		
	}
	
	/**
	 * Performs the action that is appropriate for the given selection. In this
	 * case, we will match the activity that matches the selection.
	 * 
	 * @param selection a string representing the user's selection.
	 */
	private void handleSelection(String selection) {
		Intent next = null;
		if (selection.equals("Key")) {
			next = new Intent(this, edu.wcu.trackerapp.Key.class);
			this.startActivity(next);
		} else if (selection.equals("Contact")) {
			next = new Intent(this, edu.wcu.trackerapp.Contact.class);
			this.startActivity(next);
		} else if (selection.equals("Help")) {
			next = new Intent(this, edu.wcu.trackerapp.Help.class);
			this.startActivity(next);
		} else if (selection.equals("About")) {
			next = new Intent(this, edu.wcu.trackerapp.About.class);
			this.startActivity(next);
		}
	}


	/**
	 * This method is called when nothing is selected.
	 */
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// Right now this does nothing; however, it will likely be useful,
		// so I'm leaving the TODO as a reminder to myself.
		
		// TODO Auto-generated method stub
		
	}
    
}
