package com.example.calculator;

public class EquationBuilder
{
    public String equation = "";
    private final String allOperators = "+-/*%";
    public boolean canPlaceDot = true;

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
                canPlaceDot = true;
            }
            else
            {
                equation += operator;
                canPlaceDot = true;
            }

        }
        else if(operator.equals("-"))
        {
            equation += operator;
            canPlaceDot = true;
        }
    }
    private boolean checkIfValueNotNumber(String value)
    {
        try
        {
            float myPotentialFloat = Float.parseFloat(value);
            System.out.println(myPotentialFloat);
            if(Float.isNaN(myPotentialFloat) || Float.isInfinite(myPotentialFloat))
            {
                return true;
            }
        } catch(Exception e){}
        return false;
    }

    private boolean isDot(String value)
    {
        return value.equals(".");
    }

    public void insertNumberIntoEquation(String number)
    {
        if(checkIfValueNotNumber(equation))
            equation = "";
        if(isDot(number) && isNumberBefore() && canPlaceDot)
        {
            canPlaceDot = false;
            equation += number;
        }
        else if(!isDot(number))
            equation += number;
    }

    private boolean isNumberBefore()
    {
        return (equation.length() > 0 &&
                !allOperators.contains(String.valueOf(
                        equation.charAt(equation.length()-1))));
    }

    public void clearEquation()
    {
        equation = "";
    }

    public void updateBuilderState()
    {
        canPlaceDot = !equation.contains(".");
    }
}
