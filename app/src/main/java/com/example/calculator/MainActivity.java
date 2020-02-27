package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    String Equation="";
    boolean IsError=false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plus(View view)
    {
        Equation+=" + ";
        Display(Equation);
    }

    public void minus(View view)
    {

        Equation+=" - ";
        Display(Equation);
    }

    public void multip(View view)
    {

        Equation+=" * ";
        Display(Equation);
    }

    public void division(View view)
    {
        Equation+=" / ";
        Display(Equation);
    }

    public void One(View view)
    {

        Equation+="1";
        Display(Equation);
    }

    public void Two(View view)
    {

        Equation+="2";
        Display(Equation);
    }

    public void Three(View view)
    {
        Equation+="3";
        Display(Equation);
    }

    public void Four(View view)
    {
        Equation+="4";
        Display(Equation);
    }

    public void Five(View view)
    {

        Equation+="5";
        Display(Equation);
    }

    public void Six(View view)
    {
        Equation+="6";
        Display(Equation);
    }

    public void Seven(View view)
    {
        Equation+="7";
        Display(Equation);
    }

    public void Eight(View view)
    {

        Equation+="8";
        Display(Equation);
    }

    public void Nine(View view)
    {
        Equation+="9";
        Display(Equation);
    }

    public void Zero(View view)
    {
        Equation+="0";
        Display(Equation);
    }

    public void ClearC(View view)
    {
        Equation="";
        Display(Equation);
    }

    public void Equal(View view)
    {
        Equation= Double.toString(SolveEquation());
        if(IsError)
        {Equation="ERROR";Display(Equation);IsError=false;}
        Display(Equation);
        Equation="";
    }

    public double SolveEquation()
    {
        int A=0;
        int B=0;
        char sign=' ';
        boolean isFirstValue = true;
        double result =0.d;
        boolean isnegative=false;
        for(int i=0;i<Equation.length();i++)
        {
            if(Objects.equals(Equation.charAt(i), ' '))
            {
                if(i==0)
                {
                    if(Objects.equals(Equation.charAt(i+1), '-'))
                    {
                        isnegative=true;
                        i+=2;
                        continue;
                    }
                }
                sign = Equation.charAt(i + 1);
                i += 2;
                isFirstValue = false;
                continue;
            }
            if(isFirstValue)
                A=10*A+Character.getNumericValue(Equation.charAt(i));
            else B=10*B+Character.getNumericValue(Equation.charAt(i));

        }
        if(isnegative) A*=-1;
        switch(sign)
        {
            case '+':
                result = (double)A+(double)B;
                break;
            case '-':
                result = (double)A-(double)B;
                break;
            case '*':
                result = (double)A*(double)B;
                break;
            case '/':
                if(B==0)
                    IsError=true;
                else
                 result = (double)A/(double)B;
                 break;
        }
        return result;
    }

    public void Display(String equation)
    {
        TextView textView = (TextView) findViewById(R.id.Equationview);
        textView.setText(equation);
    }

}
