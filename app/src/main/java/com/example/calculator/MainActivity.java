package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    private EquationBuilder equationBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equationBuilder = new EquationBuilder();
    }

    public void onButtonPlusClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("+");
        updateEquationTextView();
    }

    public void onButtonMinusClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("-");
        updateEquationTextView();
    }

    public void onButtonMultipClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("*");
        updateEquationTextView();
    }

    public void onButtonDivisionClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("/");
        updateEquationTextView();
    }

    public void onButtonOneClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("1");
        updateEquationTextView();
    }

    public void onButtonTwoClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("2");
        updateEquationTextView();
    }

    public void onButtonThreeClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("3");
        updateEquationTextView();
    }

    public void onButtonFourClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("4");
        updateEquationTextView();
    }

    public void onButtonFiveClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("5");
        updateEquationTextView();
    }

    public void onButtonSixClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("6");
        updateEquationTextView();
    }

    public void onButtonSevenClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("7");
        updateEquationTextView();
    }

    public void onButtonEightClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("8");
        updateEquationTextView();
    }

    public void onButtonNineClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("9");
        updateEquationTextView();
    }

    public void onButtonZeroClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("0");
        updateEquationTextView();
    }

    public void onButtonClearCClick(View view)
    {
        equationBuilder.clearEquation();
        updateEquationTextView();
    }

    public void onButtonEqualClick(View view)
    {
        float result = EquationSolver.solveEquation(equationBuilder.equation);
        equationBuilder.equation = String.valueOf(result);
        updateEquationTextView();
    }

    public void updateEquationTextView()
    {
        TextView textView = (TextView) findViewById(R.id.Equationview);
        textView.setText(equationBuilder.equation);
    }

}
