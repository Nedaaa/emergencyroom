package com.example.emergencyroom;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/**
 * Choose options whether record a new patient or update a patient;
 * able to log out
 * @author caozhi1
 *
 */
public class ChoiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_choice, menu);
		return true;
	}
	
	public void chooseRecord(View view) {
    	
    	/*  Intent is used to launch the next activity and to pass
    	 * information to it. 
    	 */
    	Intent intent = new Intent(this, RecordActivity.class);
    	
    	// if the user name and password are correct, go to the next view (choices view)
    	startActivity(intent);
    }
	
	/**
	 * use to update a patient
	 * @param view
	 */
	public void chooseUpdate(View view){
		Intent intent = new Intent(this, FindPatientActivity.class);
		startActivity(intent);
	}
	
//	public void chooseSave(View view){
//		Intent intent = new Intent(this, DisplaySaveActivity.class);
//		startActivity(intent);
//	}
	
	/**
	 * Log out nurse (user)
	 * @param view
	 */
	public void chooseLogout(View view){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
