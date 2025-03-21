/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;

/**
 *
 * @author bong
 */
public class AllWeekController {
    Validation validation = new Validation();
    Week_1_Controller week1 = new Week_1_Controller();
    Week2_controller week2 = new Week2_controller();
    Week3_controller week3 = new Week3_controller();
    week4_controller week4 = new week4_controller();
    public void menu() {
        String[] menu = new String[]{
            "Week 1",
            "Week 2",
            "Week 3",
            "Week 4",
            "Week 5",
            "Week 6",
            "Return main menu"
        };
        int len = menu.length;
        int choice;
        do {
            choice = validation.getChoice(menu, "CHOOSE A WEEK");
            switch (choice) {
                case 1: {
                    week1.menu();
                    break;
                }
                case 2:{
                    week2.menu();
                    break;
                }
                case 3:{
                    week3.menu();
                    break;
                }
                case 4:{
                    week4.menu();
                    break;
                }
                case 5:{
                    System.out.println("Return main menu\n");
                    break;
                }
                default:{
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }
}
