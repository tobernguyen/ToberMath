package com.bigs.tobermath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void start(View view){
		Bundle setting = new Bundle();
		
		//Get number of question, and interval of operand
		EditText noOfQuestion = (EditText) findViewById(R.id.noOfQuestionEditText);
		int noOfQuest = Integer.parseInt(noOfQuestion.getText().toString());
		
		EditText minimum = (EditText) findViewById(R.id.minimumEditText);
		int min = Integer.parseInt(minimum.getText().toString());	
		
		EditText maximum = (EditText) findViewById(R.id.maximumEditText);
		int max = Integer.parseInt(maximum.getText().toString());	
		
		//Set Bundle
		setting.putInt("noOfQuest", noOfQuest);
		setting.putInt("min", min);
		setting.putInt("max", max);
		
		//Intent for GamePlay Activity
		Intent intent = new Intent(this, GamePlay.class);
		intent.putExtras(setting);
		startActivity(intent);
	}
}
