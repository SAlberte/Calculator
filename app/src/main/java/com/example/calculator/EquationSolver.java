package com.example.calculator;
import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class EquationSolver
{
    private final static String allOperators="*-+/";

    public static float solveEquation(String equation)
    {
        ArrayList<Float> numbersInEquation = createNumbersArray(equation);
        ArrayList<String> operatorsInEquation = createOperatorsArray(equation);

        return calculateEquation(numbersInEquation, operatorsInEquation);
    }

    private static float calculateEquation(ArrayList<Float> numbers, ArrayList<String> operators)
    {
        float result = 0;
        boolean isDivOrMul = true;
        boolean isAddOrSub = true;
        if (numbers.size() != operators.size()+1)
            return Float.NaN;
        while(isDivOrMul)
        {
            isDivOrMul = false;
            for(int i=0; i<operators.size(); i++)
            {
                if(operators.get(i).equals("*") || operators.get(i).equals(("/")))
                {
                    isDivOrMul = true;
                    if(operators.get(i).equals("*"))
                    {
                        operators.remove(i);
                        numbers.set(i, numbers.get(i)*numbers.get(i+1));
                        numbers.remove(i+1);
                        break;
                    }
                    else
                    {
                        operators.remove(i);
                        numbers.set(i, numbers.get(i)/numbers.get(i+1));
                        numbers.remove(i+1);
                        break;
                    }
                }
            }
        }
        while(isAddOrSub)
        {
            isAddOrSub = false;
            for(int i=0; i<operators.size(); i++)
            {
                if(operators.get(i).equals("+") || operators.get(i).equals(("-")))
                {
                    isAddOrSub = true;
                    if(operators.get(i).equals("+"))
                    {
                        operators.remove(i);
                        numbers.set(i, numbers.get(i)+numbers.get(i+1));
                        numbers.remove(i+1);
                        break;
                    }
                    else
                    {
                        operators.remove(i);
                        numbers.set(i, numbers.get(i)-numbers.get(i+1));
                        numbers.remove(i+1);
                        break;
                    }
                }
            }
        }
        return numbers.get(0);
    }

    private static ArrayList <Float> createNumbersArray(String equation)
    {
        ArrayList<Float> numbersInEquation = new ArrayList<>();
        boolean isNegative = false;
        String number = "";
        for(int i=0; i<equation.length(); i++)
        {
            if(i == 0 && String.valueOf(equation.charAt(i)).equals("-"))
            {
                isNegative = true;
                continue;
            }
            if(allOperators.contains(String.valueOf(equation.charAt(i))) || i==equation.length()-1)
            {
                if(!allOperators.contains(String.valueOf(equation.charAt(i))))
                    number += String.valueOf(equation.charAt(i));
                if(!number.equals(""))
                {
                    float final_num = Float.parseFloat(number);
                    if(isNegative)
                    {
                        isNegative = false;
                        final_num *= -1;
                    }
                    numbersInEquation.add(final_num);

                }
                number = "";
                continue;
            }
            number += String.valueOf(equation.charAt(i));
        }
        return numbersInEquation;
    }

    private static ArrayList<String> createOperatorsArray(String equation)
    {
        ArrayList<String> operatorsInEquation = new ArrayList<>();
        for(int i=1; i<equation.length(); i++)
        {
            if(allOperators.contains(String.valueOf(equation.charAt(i))))
                operatorsInEquation.add(String.valueOf(equation.charAt(i)));
        }
        return operatorsInEquation;
    }


}
