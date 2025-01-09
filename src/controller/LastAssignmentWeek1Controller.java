/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week1.ILastAssignment;

/**
 *
 * @author bong
 */
public class LastAssignmentWeek1Controller {

    Validation validation = new Validation();
//    LastAssignment lastAssignment = new LastAssignment();
    ILastAssignment iLastAssignment;
    
    public void display() {
        //ivrit
        System.out.println(validation.MAUXANHLA + "  ____        _       _               _   _                                   _   _                                                                                                       \n"
                + validation.MAUXANHLA + " / ___|  ___ | |_   _(_)_ __   __ _  | |_| |__   ___    ___  __ _ _   _  __ _| |_(_) ___  _ __                                                                                            \n"
                + validation.MAUXANHLA + " \\___ \\ / _ \\| \\ \\ / / | '_ \\ / _` | | __| '_ \\ / _ \\  / _ \\/ _` | | | |/ _` | __| |/ _ \\| '_ \\                                                                                           \n"
                + validation.MAUXANHLA + "  ___) | (_) | |\\ V /| | | | | (_| | | |_| | | |  __/ |  __/ (_| | |_| | (_| | |_| | (_) | | | |                                                                                          \n"
                + validation.MAUXANHLA + " |____/ \\___/|_| \\_/ |_|_| |_|\\__, |  \\__|_| |_|\\___|  \\___|\\__, |\\__,_|\\__,_|\\__|_|\\___/|_| |_|                                                                                          \n"
                + validation.MAUDO + "  _____ _           _   _   _ |___/                            |_|                              _                                                                    _                    \n"
                + validation.MAUDO + " |  ___(_)_ __   __| | | |_| |__   ___   ___  __ _ _   _  __ _ _ __ ___   _ __  _   _ _ __ ___ | |__   ___ _ __ ___      _____   _____ _ __    _ __  _   _ _ __ ___ | |__   ___ _ __ ___  \n"
                + validation.MAUDO + " | |_  | | '_ \\ / _` | | __| '_ \\ / _ \\ / __|/ _` | | | |/ _` | '__/ _ \\ | '_ \\| | | | '_ ` _ \\| '_ \\ / _ \\ '__/ __|    / _ \\ \\ / / _ \\ '_ \\  | '_ \\| | | | '_ ` _ \\| '_ \\ / _ \\ '__/ __| \n"
                + validation.MAUDO + " |  _| | | | | | (_| | | |_| | | |  __/ \\__ \\ (_| | |_| | (_| | | |  __/ | | | | |_| | | | | | | |_) |  __/ |  \\__ \\_  |  __/\\ V /  __/ | | | | | | | |_| | | | | | | |_) |  __/ |  \\__ \\ \n"
                + validation.MAUDO + " |_|   |_|_| |_|\\__,_|  \\__|_| |_|\\___| |___/\\__, |\\__,_|\\__,_|_|  \\___| |_| |_|\\__,_|_| |_| |_|_.__/ \\___|_|  |___( )  \\___| \\_/ \\___|_| |_| |_| |_|\\__,_|_| |_| |_|_.__/ \\___|_|  |___/ \n"
                + validation.MAUDO + "                  _             _     _         |_|             _                                                  |/                                                                     \n"
                + validation.MAUXANHBIEN + "   __ _ _ __   __| |   ___   __| | __| |  _ __  _   _ _ __ ___ | |__   ___ _ __ ___                                                                                                       \n"
                + validation.MAUXANHBIEN + "  / _` | '_ \\ / _` |  / _ \\ / _` |/ _` | | '_ \\| | | | '_ ` _ \\| '_ \\ / _ \\ '__/ __|                                                                                                      \n"
                + validation.MAUXANHBIEN + " | (_| | | | | (_| | | (_) | (_| | (_| | | | | | |_| | | | | | | |_) |  __/ |  \\__ \\_                                                                                                     \n"
                + validation.MAUXANHBIEN + "  \\__,_|_| |_|\\__,_|  \\___/ \\__,_|\\__,_| |_| |_|\\__,_|_| |_| |_|_.__/ \\___|_|  |___(_)                                                                                                    \n"
                + validation.MAUXANHBIEN + "                                                                                                                                                                                          " + validation.RESET);
        String[] menu = new String[]{
            "Calculate Superlative Equation",
            "Calculate Quadratic Equation",
            "Exit the program"
        };
        int len = menu.length;
        int choice;
        do {
            choice = validation.getChoice(menu, "MENU");
            switch (choice) {
                case 1: {
                    double a = validation.getValidDouble("Enter a: ");
                    double b = validation.getValidDouble("Enter b: ");
                    iLastAssignment.calculateSuperlativeEquation(a, b);
                    double[] numbers = {a, b};
                    iLastAssignment.displayOddEvenSquareNumber(numbers);
                    break;
                }
                case 2: {
                    double a = validation.getValidDouble("Enter a ");
                    double b = validation.getValidDouble("Enter b ");
                    double c = validation.getValidDouble("Enter c ");
                    iLastAssignment.calculateQuadraticEquation(a, b, c);
                    double[] numbers = {a, b, c};
                    iLastAssignment.displayOddEvenSquareNumber(numbers);
                    break;
                }
                case 3: {
                    System.out.println("Exit the program\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }
}
