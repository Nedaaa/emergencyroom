package com.example.emergencyroom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import managers.PatientManager;
import emergencyroom.Patient;
import emergencyroom.VitalSign;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/**
 * display the successful updated page;
 *  able to save; able to go back to choose options page (content not saved)
 * @author caozhi1
 *
 */
public class DisplayUpdateActivity extends Activity implements backButton{
	
	public static final String PATIENTFILE = "patients.txt"; 
	private Patient patient;
	private FileOutputStream patientFileOut;
	private PatientManager patientManager;
	private String filePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_update);
		
		Intent intent = getIntent();
		
		patient = (Patient) intent.getSerializableExtra("patientKey");
		VitalSign vital = (VitalSign) intent.getSerializableExtra("vitalSign");
		patientManager = (PatientManager) 
				intent.getSerializableExtra("patientManager");
		
		filePath = (String) intent.getSerializableExtra("filePath");
		
		String name = patient.getName();
		String healthNum = patient.getHealthNum();
		double temp = vital.getTemperature();
		int systolic = vital.getSystolic();
		int diastolic = vital.getDiastolic();
		int heartRate = vital.getHeartRate();
//		Map<String, VitalSign> vitalMap = patient.getVitalSigns();
		
		TextView newlyUpdated = (TextView) findViewById(R.id.newly_updated);
		newlyUpdated.setText(name + " (" + healthNum + 
					") was updated successfully.\n" +
					"new Vital Signs: \n\tBody Temperature:\t"+ temp + 
					"\nBlood Pressure: \n\t\tSystolic:\t" + systolic + 
					"\n\t\tDiastolic:\t" + diastolic + 
					"\nHeart Rate:\t" + heartRate);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; 
		//this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display_update, menu);
		return true;
	}
	
	public void backToChoices(View view) {
		Intent intent = new Intent(this, ChoiceActivity.class);
		startActivity(intent);
	}
	
	public void chooseSave(View view){	
//		Intent intentPre = getIntent();
		Intent intent = new Intent(this, DisplaySaveActivity.class);
		
//		PatientManager patientManager = (PatientManager) 
//				intentPre.getSerializableExtra("patientManager");
//		
//		String filePath = (String) intentPre.getSerializableExtra("filePath");
		
//		File patientFile = new File(this.getApplicationContext().
//				getFilesDir().toString());
		File patientFile = new File(filePath);
		
		try {
			patientFileOut = new FileOutputStream(patientFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		patientManager.saveToFile(patientFileOut);
		
		intent.putExtra("patientKey", patient);
		
		startActivity(intent);
	}

}
