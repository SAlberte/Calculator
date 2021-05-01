package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.TextView;
import android.os.Vibrator;

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

    private void vibrate() {
        ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(
                VibrationEffect.createOneShot(80, VibrationEffect.DEFAULT_AMPLITUDE));
    }

    public void onButtonPlusClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("+");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonMinusClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("-");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonMultipClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("*");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonDivisionClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("/");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonModClick(View view)
    {
        equationBuilder.insertOperatorIntoEquation("%");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonOneClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("1");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonTwoClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("2");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonThreeClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("3");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonFourClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("4");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonFiveClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("5");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonSixClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("6");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonSevenClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("7");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonEightClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("8");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonNineClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("9");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonZeroClick(View view)
    {
        equationBuilder.insertNumberIntoEquation("0");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonDotClick (View view)
    {
        equationBuilder.insertNumberIntoEquation(".");
        vibrate();
        updateEquationTextView();
    }

    public void onButtonClearCClick(View view)
    {
        equationBuilder.clearEquation();
        vibrate();
        updateEquationTextView();
        equationBuilder.updateBuilderState();
    }

    public void onButtonEqualClick(View view)
    {
        float result = EquationSolver.solveEquation(equationBuilder.equation);
        equationBuilder.equation = String.valueOf(result);
        vibrate();
        updateEquationTextView();
        equationBuilder.updateBuilderState();
    }

    public void updateEquationTextView()
    {
        TextView textView = (TextView) findViewById(R.id.Equationview);
        textView.setText(equationBuilder.equation);
    }

}
