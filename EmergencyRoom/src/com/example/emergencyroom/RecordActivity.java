package com.example.emergencyroom;

import java.io.IOException;

import managers.PatientManager;
import emergencyroom.Patient;
import emergencyroom.VitalSign;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * Record a new patient; able to go back to choose options page
 * @author caozhi1
 *
 */
/**
 * @author caozhi1
 *
 */
public class RecordActivity extends Activity implements backButton{
	
	private PatientManager patientManager;
	public static final String PATIENTFILE = "patients.txt"; 
	private String filePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record);
		
		try {
			patientManager = new PatientManager(this.getApplicationContext().
					getFilesDir(), PATIENTFILE); 
			filePath = this.getApplicationContext().getFilesDir().toString() + 
					"/" + PATIENTFILE;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_record, menu);
		return true;
	}
	
	
	public void recordPatient(View view){
//		Intent intent = getIntent();
		Intent intent = new Intent(this, DisplayRecordActivity.class);
		/*
    	 * findViewById returns a View. We need to cast it EditText in
    	 * order to use the methods of EditText. 
    	 */
    	EditText patientNameText = (EditText) findViewById(R.id.name_field);
    	String namePatient = patientNameText.getText().toString();
    	
    	EditText healthNumText = (EditText) findViewById(R.id.health_card_num_field);
    	String healthNum = healthNumText.getText().toString();
    	
    	EditText dobText = (EditText) findViewById(R.id.dob_field);
    	String dob = dobText.getText().toString();
    	
    	EditText bodyTempText = (EditText) findViewById(R.id.body_temp_field);
    	double bodyTemp = Double.parseDouble(bodyTempText.getText().toString());
    	
    	EditText systolicText = (EditText) findViewById(R.id.systolic_bp_field);
    	int systolic = Integer.parseInt(systolicText.getText().toString());
    	
    	EditText diastolicText = (EditText) findViewById(R.id.diastolic_bp_field);
    	int diastolic = Integer.parseInt(diastolicText.getText().toString());
    	
    	EditText heartRateText = (EditText) findViewById(R.id.heart_rate_field);
    	int heartRate = Integer.parseInt(heartRateText.getText().toString());
    	
    	
    	Patient patient = new Patient(namePatient, healthNum, dob);
    	VitalSign vitalSign = new VitalSign (bodyTemp, systolic, diastolic, heartRate);
    	
    	patient.addVitalSign(vitalSign);
    	patient.addArrival();
    	
    	patientManager.addPatient(patient); // add the new Patient to my patientManager
    	
    	/*
    	 * In order to use the method putExtra (read the API -- it is
    	 * heavily overloaded), student needs to be Serializable.
    	 */
    	intent.putExtra("patientKey", patient);
    	intent.putExtra("vitalSign", vitalSign);
    	intent.putExtra("patientManager", patientManager);
    	intent.putExtra("filePath", filePath);
    	
//    	patientManager.addPatient(patient); // add the new Patient to my patientManager
		startActivity(intent);
	}
	
	public void backToChoices(View view) {
		Intent intent = new Intent(this, ChoiceActivity.class);
		startActivity(intent);
	}
	
}
