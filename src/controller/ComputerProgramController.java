/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week2.ComputerProgram;

/**
 *
 * @author bong
 */
public class ComputerProgramController {

    Validation validation = new Validation();
    ComputerProgram computerProgram = new ComputerProgram();

    public void display() {
        System.out.println(validation.MAUXANHBIEN + "   ____                            _              ____                                      \n"
                + validation.MAUXANHBIEN + "  / ___|___  _ __ ___  _ __  _   _| |_ ___ _ __  |  _ \\ _ __ ___   __ _ _ __ __ _ _ __ ___  \n"
                + validation.MAUXANHBIEN + " | |   / _ \\| '_ ` _ \\| '_ \\| | | | __/ _ \\ '__| | |_) | '__/ _ \\ / _` | '__/ _` | '_ ` _ \\ \n"
                + validation.MAUXANHBIEN + " | |__| (_) | | | | | | |_) | |_| | ||  __/ |    |  __/| | | (_) | (_| | | | (_| | | | | | |\n"
                + validation.MAUXANHBIEN + "  \\____\\___/|_| |_| |_| .__/ \\__,_|\\__\\___|_|    |_|   |_|  \\___/ \\__, |_|  \\__,_|_| |_| |_|\n"
                + validation.MAUXANHBIEN + "                      |_|                                         |___/                     " + validation.RESET);
        String[] menu = new String[]{
            "Normal calculator",
            "Calculator BMI index",
            "Exit the program."
        };

        int len = menu.length;
        int choice;
        do {
            choice = validation.getChoice(menu, "Computer Program");
            switch (choice) {
                case 1: {
                    System.out.println("=========Normal calculator=======");
                    double num1 = validation.getValidDouble("Enter number: ");
                    String operator;
                    double num2;
                    double result = num1;
                    do {
                        operator = validation.getValidOperator("Enter Operator: ");
                        if (operator.equals("=")) {
                            break;
                        }
                        num2 = validation.getValidDouble("Enter number: ");
                        result = computerProgram.normalCalculate(num1, operator, num2);
                        System.out.println("Memory: " + result);
                    } while (true);
                    System.out.print("Result: " + result);
                    break;
                }

                case 2: {
                    System.out.println("=========Calculator BMI index=======");
                    double weight = validation.getValidDouble("Enter Weight(kg): ");
                    double height = validation.getValidDouble("Enter Height(cm): ")*0.01;
                    computerProgram.BMICalculate(weight, height);
                    break;
                }
                case 3: {
                    System.out.println("Return main menu\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }

}
