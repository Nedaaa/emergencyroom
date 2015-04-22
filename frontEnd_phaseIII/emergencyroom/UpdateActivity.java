package com.example.emergencyroom;

//import java.io.IOException;

import managers.PatientManager;
import emergencyroom.Patient;
import emergencyroom.VitalSign;

//import managers.PatientManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * Update vital signs for an existing patient;
 *  able to go back to choose options page
 * @author caozhi1
 *
 */
public class UpdateActivity extends Activity implements backButton{
	
	public static final String PATIENTFILE = "patients.txt"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_update, menu);
		return true;
	}
	
	/**
	 * update Patient with his/her vital signs with given health card number
	 * @param view
	 */
	public void updatePatient(View view){
	// save the updated patient to file
		Intent intentPre = getIntent();
		Intent intent = new Intent(this, DisplayUpdateActivity.class);
		
		PatientManager patientManager = (PatientManager) 
				intentPre.getSerializableExtra("patientManager");
		String healthNum = (String) intentPre.getSerializableExtra("healthNum");
		String filePath = (String) intentPre.getSerializableExtra("filePath");
		
		EditText bodyTempText = (EditText) findViewById(R.id.body_temp_field);
    	double bodyTemp = Double.parseDouble(bodyTempText.getText().toString());
    	
    	EditText systolicText = (EditText) findViewById(R.id.systolic_bp_field);
    	int systolic = Integer.parseInt(systolicText.getText().toString());
    	
    	EditText diastolicText = (EditText) findViewById(R.id.diastolic_bp_field);
    	int diastolic = Integer.parseInt(diastolicText.getText().toString());
    	
    	EditText heartRateText = (EditText) findViewById(R.id.heart_rate_field);
    	int heartRate = Integer.parseInt(heartRateText.getText().toString());
		
//    	Patient patient = (Patient) intentPre.getSerializableExtra("patientKey");
    	Patient patient = patientManager.getPatient(healthNum);
    	VitalSign vitalSign = new VitalSign (bodyTemp, systolic, diastolic, heartRate);
    	
    	patient.addVitalSign(vitalSign);
    	
    	intent.putExtra("patientKey", patient);
    	intent.putExtra("vitalSign", vitalSign);
    	intent.putExtra("patientManager", patientManager);
    	intent.putExtra("filePath", filePath);
    	
		startActivity(intent);
	}
	
	/**
	 * Back to the View which choose options
	 */
//	public void backToChoices(View view) {
	public void back(View view){
		Intent intent = new Intent(this, ChoiceActivity.class);
		startActivity(intent);
	}
}
