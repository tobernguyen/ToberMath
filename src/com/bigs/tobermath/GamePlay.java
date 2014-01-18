package com.bigs.tobermath;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamePlay extends Activity {

	// Initiate point and correctButt (for Correct Button ID)
	String correctButt = new String();
	int point = 0;
	int n = 10;
	int i = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_play);

		// Start game first time
		showQuestion(n);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_play, menu);
		return true;
	}

	// Display expression and button
	void showQuestion(int n){

		// Clear Congrats text
		TextView congrats = (TextView) findViewById(R.id.congrats);
		congrats.setText("");

		if (i <= n) {

			// Display question number/total number of question
			TextView questionNum = (TextView) findViewById(R.id.questionNumber);
			questionNum.setText("Question: " + i + "/" + n);

			// Create expression view
			int result = expressGen(50, 100);

			// Generate button for possible answer
			correctButt = buttonGen(result);
			i++;
		}
		else {
			Bundle data = new Bundle();
			data.putInt("correctAnswer", point);
			data.putInt("numberOfQuestion", n);
			Intent intent = new Intent(this, ResultDisplay.class);
			intent.putExtras(data);
			startActivity(intent);
		}
	}

	int expressGen(int min, int max) {

		// Generate 2 random numbers with min and max interval
		Random rand = new Random();
		int ranNum1 = rand.nextInt((max - min) + 1) + min;
		int ranNum2 = rand.nextInt((max - min) + 1) + min;
		// Random number for divide operator
		int ranNum3 = ranNum1 / ranNum2 + 1;

		// Generate random operator
		String[] operator = { "+", "-", "*", ":" };
		int idx = new Random().nextInt(operator.length);
		String ranOper = (operator[idx]);

		// Generate string to display expression and calculate the result
		int result;
		String expression;

		if (ranOper == "+") {
			result = ranNum1 + ranNum2;
		} else if (ranOper == "-") {
			result = ranNum1 - ranNum2;
		} else if (ranOper == "*") {
			result = ranNum1 * ranNum2;
		} else {
			ranNum1 = ranNum2 * ranNum3;
			result = ranNum1 / ranNum2;
		}

		expression = (ranNum1 + " " + ranOper + " " + ranNum2);

		// Display expression on TextView expView
		TextView expView = (TextView) findViewById(R.id.expression);
		expView.setText(expression);

		return result;
	}

	// Function to generate button with one correct answer and 3 random buttons
	// This function return the id of the button with correct answer
	String buttonGen(int result) {
		int[] arrAnswer = new int[] { result, result + 1, result + 2,
				result + 3 };
		Random rgen = new Random();
		for (int i = 0; i < arrAnswer.length; i++) {
			int randomPosition = rgen.nextInt(arrAnswer.length);
			int temp = arrAnswer[i];
			arrAnswer[i] = arrAnswer[randomPosition];
			arrAnswer[randomPosition] = temp;
		}

		// Find the correct id of the button with correct answer
		String correctButton = null;
		for (int i = 0; i < arrAnswer.length; i++) {
			if (arrAnswer[i] == result) {
				correctButton = new String("button" + (i + 1));
				break;
			}
		}

		// Set value for buttons
		Button butt1 = (Button) findViewById(R.id.button1);
		Button butt2 = (Button) findViewById(R.id.button2);
		Button butt3 = (Button) findViewById(R.id.button3);
		Button butt4 = (Button) findViewById(R.id.button4);
		butt1.setText("" + arrAnswer[0]);
		butt2.setText("" + arrAnswer[1]);
		butt3.setText("" + arrAnswer[2]);
		butt4.setText("" + arrAnswer[3]);

		return correctButton;
	}

	public void butt1(View view) {
		TextView congrats = (TextView) findViewById(R.id.congrats);
		if (correctButt.equals("button1")){
			point++;
			congrats.setText("CORRECT!!!");}
		else
			congrats.setText("INCORRECT ANSWER!!!");
		keepPlaying(n);
	}

	public void butt2(View view) {
		TextView congrats = (TextView) findViewById(R.id.congrats);
		if (correctButt.equals("button2")){
			point++;
			congrats.setText("CORRECT!!!");}
		else
			congrats.setText("INCORRECT ANSWER!!!");
		keepPlaying(n);
	}

	public void butt3(View view) {
		TextView congrats = (TextView) findViewById(R.id.congrats);
		if (correctButt.equals("button3")){
			point++;
			congrats.setText("CORRECT!!!");}
		else
			congrats.setText("INCORRECT ANSWER!!!");
		keepPlaying(n);
	}

	public void butt4(View view) {
		TextView congrats = (TextView) findViewById(R.id.congrats);
		if (correctButt.equals("button4")){
			point++;
			congrats.setText("CORRECT!!!");}
		else
			congrats.setText("INCORRECT ANSWER!!!");
		keepPlaying(n);
	}

	void keepPlaying(int n) {
		showQuestion(n);
	}
}
