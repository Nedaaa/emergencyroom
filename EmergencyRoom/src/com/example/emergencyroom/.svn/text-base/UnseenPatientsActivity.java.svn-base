package com.example.emergencyroom;

import java.util.List;


import emergencyroom.Patient;

import managers.PatientManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class UnseenPatientsActivity extends Activity {
	
	private PatientManager patientManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unseen_patients);
		Intent intent = getIntent();
		patientManager = (PatientManager) 
				intent.getSerializableExtra("patientManager");
		
		List<Patient> unseenList = patientManager.getUrgencyList();
		int i = 0;
		String ret = "";
		while (i < unseenList.size()) {
			Patient p = unseenList.get(i);
			ret += p.getName() + ", " + p.getDob() + ", " + p.getHealthNum() + "/n";
			i++;
		}
		TextView unseenListStr = (TextView) findViewById(R.id.unseen_list);
		unseenListStr.setText(ret);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_unseen_patients, menu);
		return true;
	}
	
	

}
