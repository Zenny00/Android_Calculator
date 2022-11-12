package com.example.calculator;

import androidx.activity.result.contract.ActivityResultContracts;

public class SimpleExpression {
    //Private data members
    private Integer mOperand1;
    private Integer mOperand2;
    private String mOperator;
    private Integer mValue;

    //Constructor
    public SimpleExpression()
    {
        mOperand1 = 0;
        mOperand2 = 0;
        mOperator = "+";
        mValue = 0;
    }

    //Setters
    public void setOperand1(int v)
    {
        mOperand1 = v;
    }

    public void setOperand2(int v)
    {
        mOperand2 = v;
    }

    public void setOperator(String s)
    {
        mOperator = s;
    }

    //Getters
    public int getOperand1()
    {
        return mOperand1;
    }

    public int getOperand2()
    {
        return mOperand2;
    }

    public String getOperator()
    {
        return mOperator;
    }

    public Integer getValue()
    {
        //Compute the value and return it
        computeValue();
        return mValue;
    }

    //Clears model operands
    public void clearOperands()
    {
        mOperand1 = 0;
        mOperand2 = 0;
    }

    //Computes the total value
    private void computeValue()
    {
        mValue = 0;

        //Check the operator
        if (mOperator.contentEquals("+"))
            mValue = mOperand1 + mOperand2;
        else if (mOperator.contentEquals("-"))
            mValue = mOperand1 - mOperand2;
        else if (mOperator.contentEquals("x"))
            mValue = mOperand1 * mOperand2;
        else if (mOperator.contentEquals("/") && mOperand2 != 0) //Ensure no division by 0
            mValue = mOperand1 / mOperand2;
        else
            mValue = mOperand1 % mOperand2;
    }
}
