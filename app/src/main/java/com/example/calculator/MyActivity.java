package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    //Private data members
    private TextView mNumberDisplay;
    //Model
    private SimpleExpression mExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Get view object for displaying result
        mNumberDisplay = (TextView) findViewById(R.id.textView1);

        //Initialize the model
        mExpression = new SimpleExpression();
    }

    //Reset the calculator
    public void goAC(View view)
    {
        mExpression.clearOperands();
        mNumberDisplay.setText("0");
    }

    //Use the operand
    public void goOperand(View view)
    {
        String val = (String) mNumberDisplay.getText();
        String digit = (String) view.getContentDescription();

        if (val.charAt(0) == '0')
            mNumberDisplay.setText(digit);
        else
            mNumberDisplay.setText((String) mNumberDisplay.getText() + digit.charAt(0));
    }

    //Use operator
    public void goOperator(View view)
    {
        String operator = (String) view.getContentDescription();
        try {
            String val = (String) mNumberDisplay.getText();
            mExpression.setOperand1((int) Integer.parseInt(val.toString()));
        } catch (NumberFormatException e) {
            mExpression.setOperand1(0);
        }

        mNumberDisplay.setText("0");
        mExpression.setOperator(operator);
    }

    //When = is click, compute the value and display to screen
    public void goCompute(View view)
    {
        try {
            String val = (String) mNumberDisplay.getText();
            mExpression.setOperand2((int) Integer.parseInt(val.toString()));
        } catch (NumberFormatException e) {
            mExpression.setOperand2(0);
        }

        mNumberDisplay.setText(mExpression.getValue().toString());
    }
}