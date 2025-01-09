/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

import validation.Validation;

/**
 *
 * @author bong
 */
//Solving the equation, find the square numbers, even numbers, and odd numbers.
public class LastAssignment implements ILastAssignment {

    Validation validation = new Validation();

    @Override
    public void displayOddEvenSquareNumber(double[] numbers) {
        System.out.println(validation.MAUXANHBIEN + "Even numbers: " + validation.RESET);
        for (double number : numbers) {
            if (validation.isEven(number)) {
                System.out.printf("%.0f ", number);
            }
        }
        System.out.println();

        System.out.println(validation.MAUXANHBIEN + "Odd numbers: " + validation.RESET);
        for (double number : numbers) {
            if (validation.isOdd(number)) {
                System.out.printf("%.0f ", number);
            }
        }
        System.out.println();

        System.out.println(validation.MAUXANHBIEN + "Square numbers: " + validation.RESET);
        for (double number : numbers) {
            if (validation.isPerfectSquare(number)) {
                System.out.printf("%.0f ", number);
            }
        }
        System.out.println();
    }

    @Override
    public void calculateSuperlativeEquation(double a, double b) {
        if (a == 0) {
            if (b != 0) {
                System.out.println("No real solution.");
            } else {
                System.out.println("Have many solutions.");
            }
        } else {
            System.out.println("Solution = " + (-b / a));
        }
    }

    @Override
    public void calculateQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            calculateSuperlativeEquation(b, c);
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.printf("Two solutions x1: %.2f, x2: %.2f%n", x1, x2);
            } else if (delta == 0) {
                System.out.printf("One solution x: %.2f%n", (-b / (2 * a)));
            } else {
                System.out.println("No real solutions.");
            }
        }
    }
}
