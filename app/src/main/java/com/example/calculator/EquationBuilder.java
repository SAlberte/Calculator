package com.example.calculator;

public class EquationBuilder
{
    public String equation = "";
    private final String allOperators = "+-/*";

    public void insertOperatorIntoEquation(String operator)
    {
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

    public void insertNumberIntoEquation(String number)
    {
        equation += number;
    }

    public void clearEquation()
    {
        equation = "";
    }
}
