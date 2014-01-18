package com.bigs.tobermath;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ResultDisplay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_display);
		
		//Get data from GamePlay
		Bundle extras = getIntent().getExtras();
		int correctA = extras.getInt("correctAnswer");
		int numberOfQuest = extras.getInt("numberOfQuestion");
		
		//Display result
		TextView result = (TextView) findViewById(R.id.resultDisplay);
		result.setText("Congratulation!\nYou answer correct: " + correctA + "/" + numberOfQuest +" questions!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result_display, menu);
		return true;
	}

}
