package com.example.emergencyroom;

import java.io.IOException;

import managers.NurseManager;
import managers.PhysicianManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;

/**
 * Login page; able to log out
 * @author caozhi1
 *
 */
public class MainActivity extends Activity {

	public static final String NURSEFILE = "nursePasswords.txt";
	private NurseManager nurseManager;
	public static final String PHYSICIANFILE = "physicianPasswords.txt";
	private PhysicianManager physicianManager;
	private int jobType;
	private static int temp = 0;
//	private boolean loginSuccess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			if (jobType == 1){
			nurseManager = new NurseManager(this.getApplicationContext().
					getFilesDir(), NURSEFILE); 
//				nurseManager = new NurseManager("caozhi1/", NURSEFILE);
			}else if (jobType == 2){
			physicianManager = new PhysicianManager(this.getApplicationContext().
					getFilesDir(), PHYSICIANFILE); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * whether the user is Nurse or Physician
	 */
	public void chooseJob(View view){
		boolean checked = ((RadioButton)view).isChecked();
		
		switch(view.getId()) {
	        case R.id.nurseButton:
	            if (checked)
	            	jobType = 1; // nurse
	            break;
	        case R.id.physicianButton:
	            if (checked)
	            	jobType = 2; // physician		
	            break;
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; 
		//  this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	/**
	 * go to the Choice Activity if the user name and password is correct
	 * @param view
	 */
	public void checkLogin(View view) {
    	
    	/*  Create new Intent for different job type (nurse and physician)
    	 */
    	Intent intent = null;
    	boolean loginSuccess = false;
    	
    	CharSequence loginFailText = "Error user name or password";
    	
    	/*
    	 * findViewById returns a View. We need to cast it EditText in
    	 * order to use the methods of EditText. 
    	 */
    	EditText userNameText = (EditText) findViewById(R.id.user_name_field);
    	String userName = userNameText.getText().toString();
    	
    	EditText passwordText = (EditText) findViewById(R.id.password_field);
    	String password = passwordText.getText().toString();
    	
    	// this if statement will not be needed if 
    	//    the if statement has isNuse is working
    	// this part is just for testing purpose
    	// can only login on the even number of login (ex: 2nd, 4th time login)
    	if (temp % 2 != 0){
    		if (jobType == 1){ // nurse
    			nurseManager.add(userName,password);
        	} else if (jobType == 2){
        		physicianManager.add(userName,password);
        	}
    	}
    	temp ++;
    	
    	if (jobType == 1){ // nurse
    		intent = new Intent(this, ChoiceActivity.class);
    		loginSuccess = nurseManager.isNurse(userName,password);
    	} else if (jobType == 2){ // physician
    		intent = new Intent(this, SearchActivity.class);
    		loginSuccess = physicianManager.isPhysician(userName,password);
    	}
    	
    	// if the user name and password are correct, 
    	//  go to the next view (choices/search view)
//    	if (nurseManager.isNurse(userName,password)){
    	if (loginSuccess){
    		startActivity(intent);
    	// otherwise, pop up an error message
    	}else{
    		Toast toast = Toast.makeText(getApplicationContext(), 
    				loginFailText, Toast.LENGTH_SHORT);
        	toast.show();
    	}
    	
//    	// this is only presented when temp valuable is used
//    	startActivity(intent);
    	
    }

}
