/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

import static java.lang.Math.pow;

/**
 *
 * @author bong
 */
public class ComputerProgram {
//    o Option 1: Normal calculator
//a. Require to input task information including “number, operator”.

    public Double normalCalculate(double num1, String operator, double num2) {
        double result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/": {
                result = (num1 / num2);
                break;
            }
            case "^":
                result = pow(num1, num2);
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }

    public void BMICalculate(double weight, double height){
        double bmi = weight/(height*height);
        System.out.println("BMI number: "+ String.format("%.2f", bmi));
        System.out.print("BMI status: ");
        if(bmi < 19){
            System.out.println("Under-standard");
        }
        else if(bmi< 25){
            System.out.println("Standard");
        }
        else if(bmi < 30){
            System.out.println("Overweight");
        }
        else if(bmi < 40){
            System.out.println("Fat - should lose weight");
        }
        else System.out.println("Very fat - should lose weight immediately");
    }
}
