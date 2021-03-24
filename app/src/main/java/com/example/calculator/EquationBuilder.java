package com.example.calculator;

public class EquationBuilder
{
    public String equation = "";
    private final String allOperators = "+-/*";

    public void insertOperatorIntoEquation(String operator)
    {
        if(checkIfValueNotNumber(equation))
            equation = "";

        if(equation.length() == 1 && allOperators.contains(String.valueOf(equation.charAt(0))))
            return;
        if(equation.length() > 0)
        {
            if(allOperators.contains(String.valueOf(equation.charAt(equation.length()-1))))
            {
                equation = equation.substring(0, equation.length()-1);
                equation += operator;
            }
            else
                equation += operator;
        }
        else if(operator.equals("-"))
            equation += operator;
    }
    private boolean checkIfValueNotNumber(String value)
    {
        try
        {
            float myPotentialFloat = Float.parseFloat(value);
            System.out.println(myPotentialFloat);
            if(Float.isNaN(myPotentialFloat) || Float.isInfinite(myPotentialFloat))
            {
                System.out.println("TU");
                System.out.println(myPotentialFloat);
                return true;
            }
        } catch(Exception e){}
        return false;
    }
    public void insertNumberIntoEquation(String number)
    {
        if(checkIfValueNotNumber(equation))
            equation = "";
        equation += number;
    }

    public void clearEquation()
    {
        equation = "";
    }
}
