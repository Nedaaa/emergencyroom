package com.example.emergencyroom;

import java.io.IOException;

import managers.PatientManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends Activity {
	
//	public static final String PATIENTFILE = "patients.txt"; 
	private PatientManager patientManager;
	public static final String PATIENTFILE = "patients.txt"; 
	private String filePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_search, menu);
		return true;
	}
	
	public void searchPatient(View view){
		Intent intent = new Intent(this, DisplayPatientActivity.class);
		
		EditText healthNumText = (EditText) findViewById(R.id.health_card_num_field);
    	String healthNum = healthNumText.getText().toString();
    	
    	CharSequence findPatientFailText = "There's no such patient exist";

    	// we need this part for the real case, right now for testing without txt I comment it out
    	// patient with specific health card number exists or not
    	if (patientManager.getPatients().containsKey(healthNum)){
    		intent.putExtra("patientKey", patientManager.getPatient(healthNum));
    		intent.putExtra("healthNum", healthNum);
        	intent.putExtra("patientManager", patientManager);
        	intent.putExtra("filePath", filePath);
    		startActivity(intent);
    	}else{
    		Toast toast = Toast.makeText(getApplicationContext(), 
    				findPatientFailText, Toast.LENGTH_SHORT);
        	toast.show();
    	}
    	
//    	intent.putExtra("patientKey", patientManager.getPatient(healthNum));
//    	intent.putExtra("healthNum", healthNum);
//    	intent.putExtra("patientManager", patientManager);
//    	intent.putExtra("filePath", filePath);
    	
    	// just for testing purpose
//		startActivity(intent);
	}
    			
//    public String getHealthCardNum(){
//    	return healthCardNum;
//    }
	public void backToChoices(View view) {
		Intent intent = new Intent(this, ChoiceActivity.class);
		startActivity(intent);
	}

}
