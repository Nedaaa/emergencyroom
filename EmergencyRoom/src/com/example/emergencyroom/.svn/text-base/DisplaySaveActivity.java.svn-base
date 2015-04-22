package com.example.emergencyroom;

import emergencyroom.Patient;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/**
 * display the successful save page;
 *  able to continue to choose options page
 *   (continue to record a new patient or update a patient)
 * @author caozhi1
 *
 */
public class DisplaySaveActivity extends Activity implements backButton{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_save);
		
		Intent intent = getIntent();
		
		Patient patient = (Patient) intent.getSerializableExtra("patientKey");
		String name = patient.getName();
		String healthNum = patient.getHealthNum();
		
		TextView newlySaved = (TextView) findViewById(R.id.newly_saved);
		newlySaved.setText(name + " (" + healthNum + 
					") was saved successfully.");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display_save, menu);
		return true;
	}
	
	public void backToChoices(View view) {
		Intent intent = new Intent(this, ChoiceActivity.class);
		startActivity(intent);
	}

}
